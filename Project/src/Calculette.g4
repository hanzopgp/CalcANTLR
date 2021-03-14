grammar Calculette;

/*==================================================
==================FONCTIONS UTILES==================
==================================================*/

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles(); //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                   //liens var/type et les valeurs dans les adresses
    private String getNewLabel() { return "B" +(_cur_label++); }  //Generateur de nom d'etiquettes pour les boucles                                

    //Renvoie le code pour un cast simple d'un type a un autre
    private String trad(String currentType, String currentExpr, String targetType){ 
      String res = currentExpr;
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
          String trueLabel = getNewLabel();
          String falseLabel = getNewLabel();                           
          String pushType;
          String equalType;
          if(currentType.equals("float")){    //Passage de float ===> bool
            pushType = "PUSHF 0\n";
            equalType = "FEQUAL\n";
          }else{                              //Passage de int ===> bool
            pushType = "PUSHI 0.0\n";
            equalType = "EQUAL\n";
          }   
          res += pushType + equalType + "JUMPF " + trueLabel + "\nPUSHI 0\n" 
              + "JUMP " + falseLabel + "\nLABEL " + trueLabel + "\nPUSHI 1\n" 
              + "LABEL " + falseLabel + "\n";
          break;
        }
        return res;
    }

    //Met au meme type 2 expressions en renvoyant le type et en modifier l'object StringBuilder
    private String tradTwo(String type, String expr, String type2, String expr2, String typeRes, StringBuilder exprRes){
      if(type.equals(type2)){               //Operation sur deux expressions de meme type
        typeRes = type;
        exprRes.append(expr + expr2);
      }else if(type.equals("float")){       //Passage de float + int ===> float
        typeRes = "float";
        exprRes.append(expr + expr2 + "ITOF\n");
      }else if(type2.equals("float")){      //Passage de int + float ===> float
        typeRes = "float";
        exprRes.append(expr + "ITOF\n" + expr2);
      }
      return typeRes;
    }

    private String storeGOrL(String id){
      AdresseType at = tablesSymboles.getAdresseType(id); 
      String str1 = (at.adresse < 0) ? "STOREL\n" : "STOREG\n";
      String str2 = at.getSize(at.type) == 1 
                    ? tablesSymboles.getAdresseType(id).adresse + "\n" 
                    : (tablesSymboles.getAdresseType(id).adresse + 1) + "\n"; 
      return str1 + str2;
    }

    private String pushIOrF(String type){
      return ((type.equals("int") || type.equals("bool")) ? "PUSHI 0\n" : "PUSHF 0.0\n"); 
    }

    //Renvoie le code pour une declaration simple
    private String evalDeclaration(String type, String id){  
      tablesSymboles.putVar(id, type);
      return pushIOrF(type); 
    }

    //Renvoie le code pour une declaration assignation
    private String evalDeclarationExpr(String type, String id, String exprType, String expr){
      tablesSymboles.putVar(id, type);  
      AdresseType at = tablesSymboles.getAdresseType(id); 
      return pushIOrF(type) + trad(exprType, expr, at.type) + storeGOrL(id);
    }

    //Renvoie le code pour une assignation
    private String evalAssign(String id, String exprType, String expr){ 
      AdresseType at = tablesSymboles.getAdresseType(id);
      return trad(exprType, expr, at.type) + storeGOrL(id);
    }

    //Renvoie le code mvap pour chacune des conditions possibles
    private String evalCond(String exp1, String cond, String exp2){  
      String res = exp1 + exp2;                                     
      switch(cond){
        case "==" :
          return res + "EQUAL\n";
        case "<=" :
          return res + "INFEQ\n";
        case ">=" :
          return res + "SUPEQ\n";
        case "<" :
          return res + "INF\n";
        case ">" :
          return res + "SUP\n";
        case "!=" :
          return res + "NEQ\n";
        default :
          System.err.println("ERROR evalCond");
          return "";
      }
    }

    //Fonction renvoyant le code mvap pour creer une boucle while
    private String evalWhileLoop(String expr, String exprType, String block){ 
      String startLabelW = getNewLabel();                                     
      String endLabelW = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return "LABEL " + startLabelW + "\n" + tradExpr + "JUMPF " + endLabelW + "\n"
             + block + "JUMP " + startLabelW + "\n" + "LABEL " + endLabelW + "\n";
    }

    //Fonction renvoyant le code mvap pour creer une boucle for
    private String evalForLoop(String init, String exprType, String expr, String iteration, String block){  
      String startLabelF = getNewLabel();                                                                    
      String endLabelF = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return init + "LABEL " + startLabelF + "\n" + tradExpr + "JUMPF " + endLabelF + "\n"
             + block + iteration + "JUMP " + startLabelF + "\n" + "LABEL " + endLabelF + "\n";
    }

    //Fonction renvoyant le code mvap pour creer une boucle repeat until
    private String evalRepeatLoop(String exprType, String expr, String block){                                                  
      String startLabelR = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool"); 
      return "LABEL " + startLabelR + "\n" + block 
             + tradExpr + "\n" + "JUMPF " + startLabelR + "\n";
    }

    //Fonction renvoyant le code mvap pour utiliser read
    private String evalInput(String id){
      AdresseType at = tablesSymboles.getAdresseType(id);
      String str1 = at.type.equals("int") ? "READ\n" : "READF\n";
      String str2 = storeGOrL(id);
      return str1 + str2;
    }

    //Fonction renvoyant le code mvap pour utiliser write
    private String evalOutput(String type, String expr){
      String str = (type.equals("int")) || (type.equals("bool")) 
                   ? "WRITE\n POP\n"
                   : "WRITEF\n POP\n POP\n";
      return expr + str;
    }

     //Fonction renvoyant le code apres avoir tester
    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                  
      String falseLabel1And = getNewLabel();
      String trueLabel2And = getNewLabel();
      expr1 = trad(expr1Type, expr1, "bool");
      expr2 = trad(expr2Type, expr2, "bool"); 
      return expr1 + "JUMPF " + falseLabel1And + "\n" + expr2 + "JUMP " + trueLabel2And + "\n"                    
              + "LABEL " + falseLabel1And + "\n" + "PUSHI 0\n" + "LABEL " + trueLabel2And + "\n";
    }

    //Fonction renvoyant le code apres avoir tester
    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    
      String falseLabel1Or = getNewLabel();
      String trueLabel1Or = getNewLabel();
      expr1 = trad(expr1Type, expr1, "bool");
      expr2 = trad(expr2Type, expr2, "bool"); 
      return expr1 + "JUMPF " + falseLabel1Or + "\n" + "PUSHI 1\n" + "JUMP " + trueLabel1Or + "\n"
             + "LABEL " + falseLabel1Or + expr2 + "LABEL " + trueLabel1Or + "\n";
    }

    //Fonction renvoyant le code mvap lors d'un branchement if else
    private String evalIfElse(String exprType, String expr, String ifBlock, String elseBlock){                                                                                 
      String elseStartLabel = getNewLabel();                                                                   
      String ifEndLabel = getNewLabel(); 
      String tradExpr = trad(exprType, expr, "bool"); 
      return tradExpr + "\n" + "JUMPF " + elseStartLabel +"\n" 
             + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
             + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
    }

    //Fonction renvoyant le code mvap pour un branchement compose d'un seul if
    private String evalIf(String exprType, String expr, String ifBlock){      
      String ifEndLabel = getNewLabel();                                           
      String tradExpr = trad(exprType, expr, "bool");                                                      
      return tradExpr + "\n" + "JUMPF " + ifEndLabel 
             + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
    }

    //Fonction renvoyant le code mvap pour les return
    private String evalReturn(String exprType, String expr){
      AdresseType at = tablesSymboles.getAdresseType("return");
      return trad(expr, exprType, at.type)
             + storeGOrL(expr) + "RETURN\n";
    }                                                                                               
}

/*==================================================
================AXIOME DE DEPART====================
==================================================*/

calcul returns [ String code ]
@init{ $code = new String(); }       //Initialisation de $code qui contiendra le code mvap
@after{ System.out.println($code); } //et l'affichera a la fin
    : 
      (declaration { $code += $declaration.code; })*  //On commence un fichier de code par les declaration
      { $code += "JUMP " + "Main\n"; }

      NEWLINE*

      (fonction { $code += $fonction.code; })*        //Puis par les fonctions
      
      NEWLINE*

      { $code += "LABEL " + "Main\n"; }               //Et les instructions
      (instruction { $code += $instruction.code; })*

      { $code += "HALT \n"; }                         //Puis par un HALT
    ;

/*==================================================
================BLOCKS INSTRUCTION==================
==================================================*/

instruction returns [ String code ] //Ensemble des types d'instructions seules que l'on peut rencontrer                                                   
    :                               
      expression finInstruction 
      { $code = $expression.code; }
 
      | finInstruction 
        { $code= ""; }

      | declaration finInstruction
        { $code = $declaration.code; }

      | assignation finInstruction
        { $code = $assignation.code; }

      | outputInstr finInstruction
        { $code = $outputInstr.code; }

      | inputInstr finInstruction
        { $code = $inputInstr.code; }

      | loopInstr finInstruction
        { $code = $loopInstr.code; }

      | ifElseInstr finInstruction
        { $code = $ifElseInstr.code; }

      | block finInstruction
        { $code = $block.code; }

      | returnInstr finInstruction
        { $code = $returnInstr.code; }
    ;

block returns [ String code ] //Prise en charge des block d'instructions
@init{ $code = new String(); }                                                                   
    :
      '{'
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
      { $code = evalDeclaration($ty.text, $id.text); }

      | ty = TYPE                                                                                
        id = IDENTIFIANT
        '='
        expr = expression
        { $code = evalDeclarationExpr($ty.text, $id.text, $expr.type, $expr.code); }
    ; 

assignation returns [ String code ] //Assignation d'une valeur a une variable
    : 
      id = IDENTIFIANT
      '=' 
      expr = expression
      { $code = evalAssign($id.text, $expr.type, $expr.code); }
    ;


/*==================================================
====================EXPRESSIONS=====================
==================================================*/

expression returns [ String type, String code ]
    : 
      expr = expression                                  //Addition et soustraction
      op = ('+'|'-') 
      fac = factor
      { 
        String typeRes = "";
        StringBuilder codeRes = new StringBuilder(); 
        $type = tradTwo($expr.type, $expr.code, $fac.type, $fac.code, typeRes, codeRes);;
        $code = codeRes.toString() + ($op.text.equals("+") ? "ADD" : "SUB") + "\n";
      } 

      | factor                                           //Multiplication, division...
        { $type = $factor.type; $code = $factor.code; }

      | cast                                             //Changement de type
        { $type = $cast.type; $code = $cast.code; }

      | 'true' { $type = "bool"; $code = "PUSHI 1\n"; }  //Differentes conditions dont true
      | 'false' { $type = "bool"; $code = "PUSHI 0\n"; } //et false
      | expr1 = expression                               //et conditions en general
        cond = COND
        expr2 = expression
        { $type = "bool"; $code = evalCond($expr1.code, $cond.text, $expr2.code); }

      | expr1 = expression                               //Prise en charge du && logique
        '&&' 
        expr2 = expression  
        { $type = "bool"; $code = evalAnd($expr1.type, $expr1.code, $expr2.type, $expr2.code); }

      | expr1 = expression                               //Prise en charge du || logique
        '||' 
        expr2 = expression  
        { $type = "bool"; $code = evalOr($expr1.type, $expr1.code, $expr2.type, $expr2.code); }            
    ;

factor returns [ String type, String code ]
    :
      fac = factor 
      op = ('*'|'/') 
      pp = preparenthesis
      {
        String typeRes = "";
        StringBuilder codeRes = new StringBuilder();      
        $type = tradTwo($fac.type, $fac.code, $pp.type, $pp.code, typeRes, codeRes); 
        $code = codeRes.toString() + ($op.text.equals("*") ? "MUL" : "DIV") + "\n";
      }

    | pp = preparenthesis
      { $type = $pp.type; $code = $pp.code; }
    ;

cast returns [ String type, String code ]
    :
      '('
      ty = TYPE 
      ')' 
      expr = expression        
      { $type = $ty.text; $code = trad($expr.type, $expr.code, $ty.text); }
    ;

preparenthesis returns [ String type, String code ]
    :
      '(' //Prise en charge des parentheses
      expr = expression 
      ')' 
      { $type = $expr.type; $code = $expr.code; }

    | '-' //Expressions negatives
      pp = preparenthesis
      { $type = $pp.type; $code = ($type.equals("int") ? "PUSHI 0\n SUB" : "PUSHI 0.0\n FSUB"); }

    | '+' //Expressions positives
      pp = preparenthesis
      { $type = $pp.type; $code = $pp.code; }

    | '!' //Prise en charge du non logique
      expr = expression
      { $type = "bool"; $code = "PUSHI 1\n" + trad($expr.type, $expr.code, $type) + "SUB\n"; }

    | atom //Expressions unitaires
      { $type = $atom.type; $code = $atom.code; }
    ;

atom returns [ String type, String code ]
    :
      ent = ENTIER
      { $type = "int"; $code = "PUSHI " + $ent.text + "\n"; }

    | flo = FLOAT
      { $type = "float"; $code = "PUSHI " + $flo.text + "\n"; }

    | boo = BOOLEAN
      { $type = "bool"; $code = ($boo.text.equals("true") ? "PUSHI 1\n" : "PUSHI 0\n"); }

    | id = IDENTIFIANT
      { 
        AdresseType at = tablesSymboles.getAdresseType($id.text); 
        $type = at.type;
        $code = "PUSHG " + at.adresse + "\n";
      }

    | id = IDENTIFIANT //Call d'une fonction
      '('
      args
      ')'
      { 
        $type = tablesSymboles.getFunction($id.text); 
        String pusher = ($type.equals("int") ? "PUSHI 666\n" : "PUSHF 0.666\n"); //Push un nombre random pour memoire float ou int
        $code = pusher + $args.code + "CALL " + $id.text + "\n";
        for (int i = 0; i < $args.nbArgs; i++){
          $code += "POP\n"; //On pop tous les arguments lors du call pour executer la fonction       
        }
      }
    ;

/*==================================================
====================BRANCHEMENTS====================
==================================================*/

ifElseInstr returns [ String code ] //Prise en charge des if avec ou sans else
    :
      'if('
      expression
      ')'
      ifblock = block
      { $code = evalIf($expression.type, $expression.code, $ifblock.code); }

      | 'if('
        expression
        ')'
        ifblock = block
        'else'
        elseblock = block
        { $code = evalIfElse($expression.type, $expression.code, $ifblock.code, $elseblock.code); }
    ;

/*==================================================
======================BOUCLES=======================
==================================================*/

loopInstr returns [ String code ] //Prise en charge des boucles en mvap
    :                                                                                
      'while(' //While loop                                                                                     
      expression
      ')'
      block
      { $code = evalWhileLoop($expression.type, $expression.code, $block.code); }

    | 'for(' //For loop                                                                         
      init = assignation 
      ';'
      expression 
      ';' 
      iteration = assignation 
      ')' 
      block     
      { $code = evalForLoop($init.code, $expression.type, $expression.code, $iteration.code, $block.code); }

    | 'repeat' //Repeat until loop                                                                        
      block 
      'until(' 
      expression 
      ')'
      { $code = evalRepeatLoop($expression.type, $expression.code, $block.code); }
    ;

/*==================================================
===================INPUT & OUTPUT===================
==================================================*/

inputInstr returns [ String code ] //Fonction prenant les input avec read()
    :
      'read('
      id = IDENTIFIANT 
      ')' 
      { $code = evalInput($id.text); }
    ;

outputInstr returns [ String code ] //Fonction prenant les output avec write()
    :
      'write('
      expr = expression 
      ')' 
      { $code = evalOutput($expr.type, $expr.code); }
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
      { tablesSymboles.newFunction($id.text, $ty.text); }
      block
      {
        $code = "LABEL " + $id.text;
        $code += $block.code;
      }
    ;

params //Prise en charge des parametres de la fonction, pas de retour car simple reservation sans besoin de code a pile
    : 
      ty = TYPE 
      id = IDENTIFIANT
      { tablesSymboles.putVar($id.text, $ty.text); } //Reservation des parametres dans la table des symboles
      ( ',' 
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

        ( ',' expr2 = expression
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
      ( NEWLINE | ';' )+ 
    ;

/*==================================================
========================LEXER=======================
==================================================*/

//On declare ces mots pour empecher l'utilisateur de les utiliser comme IDENTIFIANT
KEYWORDS  : 'if' |'else' | 'break' | 'while' | 'for' | 'do' | 'repeat' | 'until' | 'function' | 'return' | 'write' | 'read'; 

COND : '==' | '<' | '>' | '<=' | '>=' | '!=';

TYPE : 'int' | 'float' | 'bool';

ENTIER: ('0' ..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')*;

BOOLEAN : 'true' | 'false' ;

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

STARCOMMENT : ('/*'.?'*/') -> skip;

HASHTAGCOMMENT : '#'~('\r' | '\n')* -> skip;

SINGLELINECOMMENT : '//'~('\r' | '\n')* -> skip;

UNMATCH: . -> skip;