grammar Calculette;

/*==================================================
==================FONCTIONS UTILES==================
==================================================*/

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();           //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                             //liens id/type et les valeurs dans les adresses
    private String getNewLabel(String name) { return "B" +(_cur_label++); } //Generateur de nom d'etiquettes pour les boucles 
    //private String getNewLabel(String name) { return ("B " + name); }     //Enlever commentaire seulement pour debug 
    
    private int nbErrorsEmptyString = 0;                                     //Comptage des erreurs
    private int nbErrorsAddress = 0;                              
    private int nbErrorsOperator = 0;                             
    private int nbErrorsCondition = 0;                            
    private int nbErrorsCast = 0;                                 
    private int nbErrorsAutoCast = 0;   
    private int nbErrorsTotal                                     
            = nbErrorsEmptyString + nbErrorsAddress               
            + nbErrorsOperator + nbErrorsCondition 
            + nbErrorsCast + nbErrorsAutoCast;  

    //private ArrayList<String> errors = new ArrayList();                   //Liste des erreurs 
    private int mvapStackSize = 0;                                          //On garde la taille de la pile pour pouvoir la vider 

    /****************FONCTIONS DEBUG****************/

    private void printFinalDisplay(){
      System.out.println("#mvapStackSize : " + mvapStackSize);              //Commentaires hashtag pour eviter erreur compilation de la stack machine
      if(nbErrorsTotal > 0){
        System.out.println("#!!! Found " + nbErrorsTotal + " total errors in code !!!"); 
        System.out.println("#!!! Found " + nbErrorsAddress + " address errors in code !!!"); 
        System.out.println("#!!! Found " + nbErrorsOperator + " operator errors in code !!!");
        System.out.println("#!!! Found " + nbErrorsCondition + " condition errors in code !!!");
        System.out.println("#!!! Found " + nbErrorsCast + " cast errors in code !!!"); 
        System.out.println("#!!! Found " + nbErrorsAutoCast + " auto-cast errors in code !!!");
      }else{
        System.out.println("#Compilation successful !"); 
      }
    }

    /*private void printErrors(){
      for(String s : errors){
        System.out.println(s);
      }
    }*/

    private void testEmptyStringErrors(String ... strings){
      for(String s : strings){
        if(s.isEmpty()){
          nbErrorsEmptyString++;
          System.err.println("-->ERROR empty string");
          break;
        }
      }
    }

    private void testAddressNotFound(AdresseType at){
      //boolean noAddressTest = at.adresse == ???;
      boolean noRightTypeTest = !(at.type.equals("int") || at.type.equals("float") || at.type.equals("bool"));
      if(noRightTypeTest){
        nbErrorsAddress++;
        System.err.println("-->ERROR address, Address can't be found or is empty : [adress:" + at.adresse + ",type:" + at.type + "]");
      }
    }

    private void triggerOperatorError(String op){
      nbErrorsOperator++;
      System.err.println("-->ERROR operator, found : " + op + ", expected : '+','-','*','/'");
    }

    private void triggerConditionError(String cond){
      nbErrorsCondition++;
      System.err.println("-->ERROR condition, found : " + cond + ", expected : '==','<=','>=','<','>','!='");
    }

    private void triggerCastError(String targetType){
      nbErrorsCast++;
      System.err.println("-->ERROR cast, found : " + targetType + ", expected : 'int','float','bool'");
    }

    private void triggerAutoCastError(String type, String type2){
      nbErrorsAutoCast++;
      System.err.println("-->ERROR auto-cast, found : [" + type + "," + type2 + "], expected : 'int','float','bool'");
    }

    /****************FONCTIONS CAST****************/

    //Renvoie le code pour un cast simple d'un type a un autre
    private String tradOneElement(String currentType, String targetType){ 
      String res = "";
      switch(targetType){
        case "int":                           
          if(currentType.equals("float")){    //Passage de float ===> int
            res += "FTOI\n";   
          }
          break;  
        case "float":                         
          res += "ITOF\n";                    //Passage de int ===> float
          break;                             
        case "bool":                          
          String trueLabel = getNewLabel("true");
          String falseLabel = getNewLabel("false");                           
          String pushType;
          String equalType;
          if(currentType.equals("float")){    //Passage de float ===> bool
            pushType = "PUSHF 0.0\n";
            equalType = "FEQUAL\n"; 
          }else{                              //Passage de int ===> bool
            pushType = "PUSHI 0\n";
            equalType = "EQUAL\n";
          }   
          res += pushType 
              + equalType 
              + "JUMPF " + trueLabel + "\n"
              + "PUSHI 0\n" 
              + "JUMP " + falseLabel + "\n"
              + "LABEL " + trueLabel + "\n"
              + "PUSHI 1\n" 
              + "LABEL " + falseLabel + "\n";
          mvapStackSize += 1;
          break;
        default:
          triggerCastError(targetType);
          break;
      }
      return res;
    }

    //Met au meme type 2 expressions en renvoyant le type et en modifier l'object StringBuilder
    private String tradTwoElements(String type, String expr, String type2, String expr2, StringBuilder exprRes){
      String typeRes = "";
      if(type.equals(type2)){               //Operation sur deux expressions de meme type
        typeRes = type;
        exprRes.append(expr + expr2);
      }else if(type.equals("float")){       //Passage de float + int ===> float
        typeRes = "float";
        exprRes.append(expr + expr2 + "ITOF\n");
      }else if(type2.equals("float")){      //Passage de int + float ===> float
        typeRes = "float";
        exprRes.append(expr + "ITOF\n" + expr2);
      }else{
        triggerAutoCastError(type, type2);
      }
      return typeRes;
    }

    /****************FONCTIONS REFACTORING****************/

    //Renvoie STOREG ou STOREL + l'adresse suivant le type de l'id
    private String storeGOrL(String id){
      String res = "";
      AdresseType at = tablesSymboles.getAdresseType(id);        //Adresses positives : variables globales,
      String storer = (at.adresse >= 0) ? "STOREG " : "STOREL "; //Adresses negatives : variables locales
      boolean isIntOrBoolOrReturn = (at.type.equals("int") || at.type.equals("bool") || at.type.equals("return"));
      if(isIntOrBoolOrReturn){
        mvapStackSize += 1;
        res = storer + at.adresse + "\n";                                      //Un store suffit pour les int et bool
      }else{
        mvapStackSize += 2;
        res = storer + (at.adresse + 1) + "\n"                                       //Alors que les float ont besoin de deux
            + storer + at.adresse + "\n"; //places il faut donc store 2 elements
      }
      return res;
    }

    //Renvoie PUSHG 0 ou PUSHL 0 suivant le type en entree
    private String pushGOrL(String id){
      String res = "";
      AdresseType at = tablesSymboles.getAdresseType(id);       //Adresses positives : variables globales,
      String pusher = (at.adresse >= 0) ? "PUSHG " : "PUSHL ";  //Adresses negatives : variables locales
      boolean isIntOrBool = (at.type.equals("int") || at.type.equals("bool"));
      if(isIntOrBool){
        mvapStackSize += 1;
        res = pusher 
            + tablesSymboles.getAdresseType(id).adresse + "\n"; //Les int et bool ne prennent qu'une place dans la table
      }else{
        mvapStackSize += 2;
        res = pusher 
            + tablesSymboles.getAdresseType(id).adresse + "\n"  //Alors que les float ont besoin de deux place il faut donc
            + pusher                                            //push deux fois
            + (tablesSymboles.getAdresseType(id).adresse + 1) + "\n";
      }
      return res;
    }

    //Renvoie PUSHI 0 ou PUSHF 0.0 suivant le type en entree
    private String pushIOrF(String type){
      String res = "";
      if(type.equals("int") || type.equals("bool")){
        mvapStackSize += 1;
        res = "PUSHI ";
      }else{
        mvapStackSize += 2;
        res = "PUSHF ";
      }
      return res;
    }

    //Renvoie PUSHI 0 ou PUSHF 0.0 suivant le type en entree
    private String pushIOrFZero(String type){
      String res = "";
      if(type.equals("int") || type.equals("bool")){
        res = "PUSHI 0\n";
        mvapStackSize += 1;
      }else{
        res = "PUSHF 0.0\n";
        mvapStackSize += 2;
      }
      return res;
    }

    /****************FONCTIONS OPERATORS****************/

    //Renvoie le code mvap pour chacune des operations possibles en prenant en compte le type
    private String evalOp(String type, String op){
      String res = "";
      mvapStackSize -= 1;       //1 element en moins car les operations change 2 elements en 1 element
      if(type.equals("float")){ //Si type float alors 
        res += "F";             //FADD FSUB ... pour la stack machine*
        mvapStackSize -= 1;     //1 element en moins dans la pile car float prend 2 places
      }
      switch(op){
        case "+" :
          res += "ADD\n";
          break;
        case "-" :
          res += "SUB\n";
          break;
        case "*" :
          res += "MUL\n";
          break;
        case "/" :
          res += "DIV\n";
          break;
        default :
          triggerOperatorError(op);
          break;
      }   
      return res;                                   
    }

    //Renvoie le code approprier pour incrementer une variable
    private String evalIncrement(String id, String incr){
      AdresseType at = tablesSymboles.getAdresseType(id);
      testAddressNotFound(at);
      testEmptyStringErrors(id, incr);
      String pusher = pushGOrL(id);
      String storer = storeGOrL(id);
      String incrementer = "";
      if(incr.equals("++")){
        if(at.type.equals("float")){
          incrementer = "PUSHF 1.0\nFSUB\n";
          mvapStackSize += 1;
        }else{
          incrementer = "PUSHI 1\nSUB\n";
        }  
      }else if(incr.equals("--")){
        if(at.type.equals("float")){
          incrementer = "PUSHF 1.0\nFSUB\n";
          mvapStackSize += 1;
        }else{
          incrementer = "PUSHI 1\nSUB\n";
        }   
      }
      return pusher + incrementer + storer;
    }

    //Renvoie le code mvap pour chacune des conditions possibles
    private String evalCond(String type, String exp1, String cond, String exp2){  
      mvapStackSize -= 1;
      String res = exp1 + exp2;  
      if(type.equals("float")){ //Si type float alors
        res += "F";             //FEQUAL FINFEQ ... pour la stack machine
        mvapStackSize -= 1;
      }                                   
      switch(cond){
        case "==" :
          res += "EQUAL\n";
          break;
        case "<=" :
          res += "INFEQ\n";
          break;
        case ">=" :
          res += "SUPEQ\n";
          break;
        case "<" :
          res += "INF\n";
          break;
        case ">" :
          res += "SUP\n";
          break;
        case "!=" :
          res += "NEQ\n";
          break;
        default :
          triggerConditionError(cond);
          break;
      }
      return res;
    }

    //Renvoie le code mvap lors d'une negation unitaire
    private String evalNegPP(String type, String expr){
      String pusher = pushIOrFZero(type);
      String content = expr;
      String operator = evalOp(type, "-");
      return pusher + content + operator;
    }

    /****************FONCTIONS DECLARATION ASSIGNATION****************/

    //Renvoie le code pour une declaration simple suivant le type de l'id
    private String evalDeclaration(String type, String id){  
      tablesSymboles.putVar(id, type);
      testEmptyStringErrors(type, id);
      return pushIOrFZero(type) /*+ storeGOrL(id)*/; 
    }

    //Renvoie le code pour une declaration + assignation suivant le type de l'id
    private String evalDeclarationExpr(String type, String id, String exprType, String expr){
      tablesSymboles.putVar(id, type);  
      AdresseType at = tablesSymboles.getAdresseType(id); 
      testAddressNotFound(at);
      testEmptyStringErrors(type, id, exprType, expr);
      return expr /*+ storeGOrL(id)*/;
    }

    //Renvoie le code pour une assignation suivant le type de l'id
    private String evalAssign(String id, String exprType, String expr){ 
      AdresseType at = tablesSymboles.getAdresseType(id);
      testAddressNotFound(at);
      testEmptyStringErrors(id, exprType, expr);
      return expr + tradOneElement(exprType, at.type) + storeGOrL(id);
    }

    /*******************FONCTIONS BOUCLES*******************/

    //Fonction renvoyant le code mvap pour creer une boucle while
    private String evalWhileLoop(String exprType, String expr, String instructions){ 
      String startLabelW = getNewLabel("startWhile");                                     
      String endLabelW = getNewLabel("endWhile");
      expr += tradOneElement(exprType, "bool");
      mvapStackSize -= 1;
      testEmptyStringErrors(exprType, expr, instructions);
      return "LABEL " + startLabelW + "\n" 
             + expr 
             + "JUMPF " + endLabelW + "\n"
             + instructions 
             + "JUMP " + startLabelW + "\n" 
             + "LABEL " + endLabelW + "\n";
    }

    //Fonction renvoyant le code mvap pour creer une boucle for
    private String evalForLoop(String init, String exprType, String expr, String iteration, String instructions){  
      String startLabelF = getNewLabel("startFor");                                                                    
      String endLabelF = getNewLabel("endFor");
      expr += tradOneElement(exprType, "bool");
      mvapStackSize -= 1;
      testEmptyStringErrors(init, exprType, expr, iteration, instructions);
      return init 
             + "LABEL " + startLabelF + "\n" 
             + expr 
             + "JUMPF " + endLabelF + "\n"
             + instructions 
             + iteration 
             + "JUMP " + startLabelF + "\n" 
             + "LABEL " + endLabelF + "\n";
    }

    //Fonction renvoyant le code mvap pour creer une boucle repeat until
    private String evalRepeatLoop(String exprType, String expr, String instructions){                                                  
      String startLabelR = getNewLabel("startRepeat");
      String endLabelR = getNewLabel("endRepeat");
      expr += tradOneElement(exprType, "bool"); 
      mvapStackSize -= 1;
      testEmptyStringErrors(exprType, expr, instructions);
      return "LABEL " + startLabelR + "\n" 
             + instructions 
             + expr 
             + "JUMPF " + startLabelR + "\n"
             + "JUMP "+ endLabelR + "\n"
             + "LABEL "+ endLabelR + "\n";
    }

    /*******************FONCTIONS INPUT OUTPUT*******************/

    //Fonction renvoyant le code mvap pour utiliser read suivant le type de l'id
    private String evalInput(String id){
      mvapStackSize += 1;
      AdresseType at = tablesSymboles.getAdresseType(id);
      String reader = at.type.equals("int") ? "READ\n" : "READF\n";
      String storer = storeGOrL(id);
      testAddressNotFound(at);
      testEmptyStringErrors(id, reader, storer);
      return reader + storer;
    }

    //Fonction renvoyant le code mvap pour utiliser write
    private String evalOutput(String type){
      testEmptyStringErrors(type);
      String res = "";
      if(type.equals("int") || (type.equals("bool"))){
        res = "WRITE\nPOP\n";       //Un seul POP normal pour l'output
        mvapStackSize -= 1;
      }else{
        res = "WRITEF\nPOP\nPOP\n"; //Double POP si c'est un float car les float 
        mvapStackSize -= 2;         //prennent plus de place dans la stack machine
      }                             
      return res;
    }                                      

    /*******************FONCTIONS LOGIQUE*******************/

    //Fonction renvoyant le code apres avoir tester
    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                  
      String falseLabel1And = getNewLabel("false1And");
      String trueLabel2And = getNewLabel("true2And");
      expr1 += tradOneElement(expr1Type, "bool");
      expr2 += tradOneElement(expr2Type, "bool"); 
      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
      return expr1 
             + "JUMPF " + falseLabel1And + "\n" 
             + expr2 
             + "JUMP " + trueLabel2And + "\n"                    
             + "LABEL " + falseLabel1And + "\n" 
             + "PUSHI 0\n" 
             + "LABEL " + trueLabel2And + "\n";
    }

    //Fonction renvoyant le code apres avoir tester
    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    
      String falseLabel1Or = getNewLabel("false1Or");
      String trueLabel1Or = getNewLabel("true1Or");
      expr1 += tradOneElement(expr1Type, "bool");
      expr2 += tradOneElement(expr2Type, "bool"); 
      testEmptyStringErrors(expr1Type, expr1, expr2Type, expr2);
      return expr1 
             + "JUMPF " + falseLabel1Or + "\n" 
             + "PUSHI 1\n" 
             + "JUMP " + trueLabel1Or + "\n"
             + "LABEL " + falseLabel1Or + "\n"
             + expr2 
             + "LABEL " + trueLabel1Or + "\n";
    }

    /*******************FONCTIONS BRANCHEMENTS*******************/

    //Fonction renvoyant le code mvap lors d'un branchement if else
    private String evalIfElse(String exprType, String expr, String ifInstructions, String elseInstructions){                                                                                 
      String elseStartLabel = getNewLabel("startIfElse");                                                                   
      String ifEndLabel = getNewLabel("endIfElse"); 
      expr += tradOneElement(exprType, "bool"); 
      testEmptyStringErrors(exprType, expr, ifInstructions, elseInstructions);
      mvapStackSize -= 1;
      return expr 
             + "JUMPF " + elseStartLabel +"\n" 
             + ifInstructions + "\n" 
             + "JUMP " + ifEndLabel + "\n" 
             + "LABEL " + elseStartLabel + "\n" 
             + elseInstructions 
             + "JUMP " + ifEndLabel + "\n"
             + "LABEL " + ifEndLabel + "\n";
    }

    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
    private String evalIf(String exprType, String expr, String ifInstructions){      
      String ifEndLabel = getNewLabel("ifOnly");                                           
      expr += tradOneElement(exprType, "bool"); 
      testEmptyStringErrors(exprType, expr, ifInstructions);  
      mvapStackSize -= 1;                                                   
      return expr 
             + "JUMPF " + ifEndLabel + "\n" 
             + ifInstructions 
             + "JUMP " + ifEndLabel + "\n"
             + "LABEL " + ifEndLabel + "\n";
    }

    /*******************FONCTION RETURN*******************/

    //Fonction renvoyant le code mvap pour les return
    private String evalReturn(String exprType, String expr){
      AdresseType at = tablesSymboles.getAdresseType("return");
      testAddressNotFound(at);
      testEmptyStringErrors(exprType, expr);
      expr += tradOneElement(exprType, at.type);
      return expr 
             + "STOREL " + at.adresse + "\n"
             + "RETURN\n";
    }                                                                                               
}

/*==================================================
================AXIOME DE DEPART====================
==================================================*/

start : maincode EOF;

/*==================================================
===============FONCTION PRINCIPALE==================
==================================================*/

maincode returns [ String code ]
@init{ $code = new String(); }       //Initialisation de $code qui contiendra le code mvap
@after{ System.out.println($code); printFinalDisplay(); }
    : 
      (declaration { $code += $declaration.code; })* //On commence un fichier de code par les declaration
      { $code += "JUMP " + "Main\n"; }               //Apres les declarations globales on passe au main

      NEWLINE*

      (fonction { $code += $fonction.code; })*       //Puis par les declarations de fonctions
      
      NEWLINE*

      { $code += "LABEL " + "Main\n"; }              //Apres les declarations nous arrivons au main ou nous
      (instruction { $code += $instruction.code; })* //avons les differentes instructions du main


      /*{ $code += "FREE " + mvapStackSize + "\n"; }*/ //Ne fonctionne pas dans tous les cas...

      { $code += "HALT \n"; }                        //Et enfin on finit le code mvap pour un HALT
    ;

/*==================================================
================BLOCKS INSTRUCTION==================
==================================================*/

instruction returns [ String code ] //Ensemble des types d'instructions seules que l'on peut rencontrer                                                   
    :                               
      expression finInstruction 
      { $code = $expression.code; }  

    | declaration finInstruction
      { $code = $declaration.code; }

    | assignation finInstruction
      { $code = $assignation.code; }

    | outputInstr finInstruction
      { $code = $outputInstr.code; }

    | inputInstr finInstruction
      { $code = $inputInstr.code; }

    | loopInstr
      { $code = $loopInstr.code; }

    | ifElseInstr
      { $code = $ifElseInstr.code; }

    | block finInstruction
      { $code = $block.code; }

    | returnInstr finInstruction
      { $code = $returnInstr.code; }

    | finInstruction 
      { $code= ""; }
    ;

block returns [ String code ] //Prise en charge des block d'instructions
@init{ $code = new String(); }                                                                   
    :
      '{'
      NEWLINE?
      (instruction { $code += $instruction.code; })*
      '}'
      NEWLINE*
    ;

/*==================================================
================DELARATION VARIABLES================
==================================================*/

declaration returns [ String code ] //Prise en charge des declarations typees 
    :
      ty = TYPE 
      id = IDENTIFIANT 
      finInstruction
      { $code = evalDeclaration($ty.text, $id.text); }

    | ty = TYPE                                                                                
      id = IDENTIFIANT
      EQUAL
      expr = expression
      finInstruction
      { $code = evalDeclarationExpr($ty.text, $id.text, $expr.type, $expr.code); }
    ; 

assignation returns [ String code ] //Assignation d'une valeur a une variable
    : 
      id = IDENTIFIANT
      EQUAL 
      expr = expression
      { $code = evalAssign($id.text, $expr.type, $expr.code); }

    | id = IDENTIFIANT
      incr = INCREMENTS
      { $code = evalIncrement($id.text, $incr.text); }
    ;


/*==================================================
====================EXPRESSIONS=====================
==================================================*/

expression returns [ String type, String code ]
    : 
      expr = expression                                                     //Addition et soustraction
      op = ( ADD | SUB ) 
      fac = factor
      { 
        StringBuilder codeRes = new StringBuilder(); 
        $type = tradTwoElements($expr.type, $expr.code, $fac.type, $fac.code, codeRes);
        $code = codeRes.toString() + evalOp($type, $op.text);
      } 

    | factor                                                               //Multiplication, division...
      { $type = $factor.type; $code = $factor.code; }

    | cast                                                                 //Changement de type
      { $type = $cast.type; $code = $cast.code; }

    | 'true' { $type = "bool"; $code = "PUSHI 1\n"; mvapStackSize += 1; }  //Differentes conditions dont true
    | 'false' { $type = "bool"; $code = "PUSHI 0\n"; mvapStackSize += 1; } //et false
    | expr1 = expression                                                   //et conditions en general
      cond = COND
      expr2 = expression
      { $type = "bool"; $code = evalCond($type, $expr1.code, $cond.text, $expr2.code); }

    | expr1 = expression                                                   //Prise en charge du && logique
      AND 
      expr2 = expression  
      { $type = "bool"; $code = evalAnd($expr1.type, $expr1.code, $expr2.type, $expr2.code); }

    | expr1 = expression                                                   //Prise en charge du || logique
      OR 
      expr2 = expression  
      { $type = "bool"; $code = evalOr($expr1.type, $expr1.code, $expr2.type, $expr2.code); }            
    ;

factor returns [ String type, String code ] //Un facteur est un element constitutif d'un produit
    :                                       //Ici nous avons l'exemple de la multiplication, la
      fac = factor                          //divison mais aussi les elements qui sont entre 
      op = ( MUL | DIV )                    //parentheses, le non logique...
      pp = preparenthesis
      {
        StringBuilder codeRes = new StringBuilder();      
        $type = tradTwoElements($fac.type, $fac.code, $pp.type, $pp.code, codeRes); 
        $code = codeRes.toString() + evalOp($type, $op.text);
      }

    | pp = preparenthesis
      { $type = $pp.type; $code = $pp.code; }
    ;

cast returns [ String type, String code ] //Le cast nous permet de reconnaitre un cast explicite dans
    :                                     //le code afin d'utiliser notre fonction trad
      '('
      ty = TYPE 
      ')' 
      expr = expression        
      { $type = $ty.text; $code = $expr.code + tradOneElement($expr.type, $ty.text); }
    ;

preparenthesis returns [ String type, String code ] //preparenthesis nous permet de reconnaitre les parentheses
    :                                               //ainsi que les operations precedent des parentheses
      '(' //Prise en charge des parentheses         //mais aussi les atomes de l'expression
      expr = expression 
      ')' 
      { $type = $expr.type; $code = $expr.code; }

    | SUB //Expressions negatives
      pp = preparenthesis
      { $type = $pp.type; $code = evalNegPP($type, $pp.code); }

    | ADD //Expressions positives
      pp = preparenthesis
      { $type = $pp.type; $code = $pp.code; }

    | NO //Prise en charge du non logique
      expr = expression
      { $type = "bool"; $code = "PUSHI 1\n" 
                              + $expr.code 
                              + tradOneElement($expr.type, $type) 
                              + "SUB\n"; }

    | atom //Expressions unitaires
      { $type = $atom.type; $code = $atom.code; }
    ;

atom returns [ String type, String code ] //Les atomes de l'expression sont les elements qui sont "seuls"
    :                                     //Il y a donc les entiers, float, booleens, id ainsi que les
      ent = ENTIER                        //appels de fonctions
      { $type = "int"; $code = "PUSHI " + $ent.text + "\n"; mvapStackSize += 1; }

    | flo = FLOAT
      { $type = "float"; $code = "PUSHF " + $flo.text + "\n"; mvapStackSize += 2; }

    | boo = BOOLEAN
      { $type = "bool"; $code = ($boo.text.equals("true") ? "PUSHI 1\n" : "PUSHI 0\n"); mvapStackSize += 1; }

    | id = IDENTIFIANT
      { 
        AdresseType at = tablesSymboles.getAdresseType($id.text); 
        $type = at.type;
        $code = pushGOrL($id.text);
      }

    | id = IDENTIFIANT //Call d'une fonction avec ses arguments
      '('
      args
      ')'
      {
        $type = tablesSymboles.getFunction($id.text);   //Recupere le type de la fonction appelee
        String pusher = "";
        if($type.equals("int")){                        //Push un nombre random pour memoire float ou int
          pusher = "PUSHI 667\n";
          mvapStackSize += 1;
        }else{
          pusher = "PUSHF 0.667\n";
          mvapStackSize += 2;
        }
        if($args.nbArgs > 0){                           //Si il y a des arguments
          $code = pusher 
                + $args.code 
                + "CALL " + $id.text + "\n";            //Ajout du code des arguments et du CALL mvap
          for (int i = 0; i < $args.nbArgs; i++){       //On pop tous les arguments lors du call
            $code += "POP\n";                           //pour les utiliser pendant l'appel de la fonction       
          }
          mvapStackSize -= $args.nbArgs;                //Chaque pop fait retrecir la taille de 1
        }else{                                          //Si pas d'arguments
          $code = pusher 
                + "CALL " + $id.text + "\n";            //Ajout du code et du CALL mvap
        }     
      }
    ;

/*==================================================
====================BRANCHEMENTS====================
==================================================*/

ifElseInstr returns [ String code ] //Prise en charge des if avec ou sans else
    :
      'if' //Attention a ne pas mettre 'if(' car cela genere un bug si on compile
      '('  //un if avec un espace avant la parenthese comme ceci : 'if ('
      expression
      ')'
      ifinstr = instruction                                                  //instruction contient les blocks, les branchements 
      { $code = evalIf($expression.type, $expression.code, $ifinstr.code); } //fonctionnent donc avec une seule instruction ou un block

    | 'if'
      '('
      expression
      ')'
      ifinstr = instruction
      'else'
      elseinstr = instruction
      { $code = evalIfElse($expression.type, $expression.code, $ifinstr.code, $elseinstr.code); }
    ;

/*==================================================
======================BOUCLES=======================
==================================================*/

loopInstr returns [ String code ] //Prise en charge des boucles en mvap
    :                                                                                
     'while'      //Boucle while  
      '('         //Attention a ne pas mettre 'if(' car cela genere un bug si on compile                                                                                
      expression  //un if avec un espace avant la parenthese comme ceci : 'if ('
      ')'
      instruction //instruction contient les blocks, la boucle fonctionne donc avec une seule instruction ou un block
      { $code = evalWhileLoop($expression.type, $expression.code, $instruction.code); }

    | 'for'       //Boucle for instr                                                                       
      '('
      init = assignation 
      SEMICOLON
      expression 
      SEMICOLON 
      iteration = assignation 
      ')' 
      instruction     
      { $code = evalForLoop($init.code, $expression.type, $expression.code, $iteration.code, $instruction.code); }

    | 'repeat'   //Boucle repeat until instruction                                                                    
      instruction 
      'until' 
      '('
      expression 
      ')'
      { $code = evalRepeatLoop($expression.type, $expression.code, $instruction.code); }
    ;

/*==================================================
===================INPUT & OUTPUT===================
==================================================*/

inputInstr returns [ String code ] //Fonction prenant les entrees avec read()
    :
      'read'
      '('
      id = IDENTIFIANT 
      ')' 
      { $code = evalInput($id.text); }
    ;

outputInstr returns [ String code ] //Fonction affichant les sorties avec write()
    :
      'write'
      '('
      expr = expression 
      ')' 
      { $code = $expr.code + evalOutput($expr.type); }
    ;

/*==================================================
================DECLARATION FONCTIONS===============
==================================================*/

fonction returns [ String code ]            //Prise en charge des fonctions
@init{ tablesSymboles.newTableLocale(); }   //On creer une nouvelle table locale pour stocker les variables locales
@after{ tablesSymboles.dropTableLocale(); } //On supprime la table locale
    : 
      ty = TYPE 
      { tablesSymboles.putVar("return", $ty.text); }
      id = IDENTIFIANT 
      '('
      params? //Il peut ne pas y avoir de parametre dans la fonction
      ')' 
      { tablesSymboles.newFunction( $id.text, $ty.text); }
      block   //On precise block car une instruction sans bracket n'est pas accepte comme avec les branchements et boucles
      {
        $code = "LABEL " + $id.text + "\n";
        $code += $block.code;
      }
    ;

params //Prise en charge des parametres de la fonction, pas de retour car simple reservation sans besoin de code a pile
    : 
      ty = TYPE 
      id = IDENTIFIANT
      { tablesSymboles.putVar($id.text, $ty.text); } //Reservation des parametres dans la table des symboles
      ( 
        COMMA 
        ty2 = TYPE 
        id2 = IDENTIFIANT
        { tablesSymboles.putVar($id2.text, $ty2.text); }
      )* //Il peut y avoir plusieurs parametres
    ;

args returns [ int nbArgs, String code ]    //Prise en charge des arguments lors de l'appel d'une fonction
@init{ $nbArgs = 0; $code = new String(); } //On a besoin d'un compteur d'arguments pour pouvoir depiler 
    : 
      ( expr = expression
        {
          $nbArgs++;           //Incrementation du nombre d'arguments
          $code += $expr.code; //On empile les arguments
          if($expr.type.equals("float")){
            $nbArgs++;
          }
        }

        ( 
          COMMA 
          expr2 = expression
          {
            $nbArgs++;
            if($expr.type.equals("float")){
              $nbArgs++;
            }
            $code += $expr2.code;    
          }
        )*
      )?
    ;

returnInstr returns [ String code ] //Prise en charge du return dans une fonction
    :
      'return' 
      expr = expression
      { $code = evalReturn($expr.type, $expr.code); }
    ;

/*==================================================
===================FIN INSTRUCTION==================
==================================================*/

finInstruction //Fin d'instruction classique par un retour chariot, un point virgule...
    :
      ( NEWLINE | SEMICOLON )+ 
    ;

/*==================================================
========================LEXER=======================
==================================================*/

KEYWORDS  : 'if' |'else' | 'break' | 'while' | 'for' | 'repeat' | 'until' | 'write' | 'read' | 'return'; 

ADD : '+';

SUB : '-';

MUL : '*';

DIV : '/';

INCREMENTS : '++' | '--';

EQUAL : '=';

COMMA : ',';

SEMICOLON : ';';

AND : '&&';

OR : '||';

NO : '!';

COND : '==' | '<' | '>' | '<=' | '>=' | '!=';

TYPE : 'int' | 'float' | 'bool';

ENTIER: ('0'..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')*;

BOOLEAN : 'true' | 'false';

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*; //IDENTIFIANT en dernier, cela empeche aux IDENTIFIANT d'etre d'etre des KEYWORDS, TYPE...

/****************ELEMENTS A IGNORER****************/

NEWLINE: '\r'? '\n'; //Retour a la ligne et espacement entre les lignes

WS: (' ' | '\t')+ -> skip; //Tabulation et espace inutiles

MULTILINECOMMENT : '/*'.*?'*/' -> skip;

SINGLELINECOMMENT : '//'~[\r\n]* -> skip;

HASHTAGCOMMENT : '#'~[\r\n]* -> skip;

UNMATCH: . -> skip; //Tous ce qui n'a pas ete cite avant est automatiquement ignore