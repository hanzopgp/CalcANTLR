grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                                                   //liens var/type et les valeurs dans les adresses
    private String getNewLabel() { return "B" +(_cur_label++); }                                  //Generateur de nom d'etiquettes pour les boucles                                

    public String trad(String type, String expr, String targetType){
      String res = expr;
      //if (type.equals(targetType)){
      //    return 0;
      //}
      switch (targetType){
        case "int":
          if (type.equals("float"))
            res += "FTOI\n";
            break;  
        case "float":   
          res += "ITOF\n";
          break;                             
        case "bool":                               
          String pushType, equalType;
          if (type.equals("float"))  {
            pushType = "PUSHF 0\n";
            equalType = "FEQUAL\n";
          }else{
            pushType = "PUSHI 0.0\n";
            equalType = "EQUAL\n";
          }
          String trueLabel = getNewLabel("BoolExpr");
          String falseLabel = getNewLabel("BoolExpr");
          res += pushType + equalType + "JUMPF " + labelVrai + "PUSHI 0" 
              + "JUMP " + labelFaux) + "LABEL " + labelVrai + "PUSHI 1" 
              + "LABEL " + labelFaux ;
          break;
        }
        return res;
    }

    public String evalDeclaration(String type, String id){                                                     //Renvoie le code pour une declaration simple
      tablesSymboles.putVar(id, type);
      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n";
    }

    public String evalDeclarationExpr(String type, String id, String expression){                              //Renvoie le code pour une declaration assignation
      tablesSymboles.putVar(id, type);  
      String res = (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n"; 
      AdresseType at = tablesSymboles.getAdresseType(id);                                                                    
      res += trad($e.type, $e.code, at.type); 
      return res + tablesSymboles.getAdresseType($id.text).adresse;
    }

    public String evalCond(String exp1, String cond, String exp2){                                //Fonction renvoyant le code mvap pour chacune 
      String res = exp1 + exp2;                                                                   //des conditions possibles
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

    public String evalWhileLoop(String condition, String block){                                  //Fonction renvoyant le code mvap pour creer
      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
      String endLabel = getNewLabel();
      String res = "LABEL " + startLabel + "\n" + condition + "JUMPF " + endLabel + "\n"
          + block + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
      return res;
    }

    public String evalForLoop(String init, String condition, String iteration, String block){     //Fonction renvoyant le code mvap pour creer une
      String startLabel = getNewLabel();                                                          //boucle for
      String endLabel = getNewLabel();
      String res = init + "LABEL " + startLabel + "\n" + condition + "JUMPF " + endLabel + "\n"
            + block + iteration + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
      return res;
    }

    public String evalRepeatLoop(String condition, String block){                                 //Fonction renvoyant le code mvap pour creer une                  
      String startLabel = getNewLabel();                                                          //boucle repeat until
      String res = "LABEL " + startLabel + "\n" + block 
            + condition + "\n" + "JUMPF " + startLabel + "\n";
      return res;
    }

    public String evalCondAvecLog(String cond1, String exprlog, String cond2){                    //Fonction renvoyant le code apres avoir tester
      String res = "";                                                                            //en prenant en compte la logique booleene
      switch(exprlog){
        case "!" :
        case "||" :
        case "&&" :
        default :
          System.err.println("ERROR evalCondAvecLog");
          return "";
      }
    }

    public String evalIfElse(String condition, String ifBlock, String elseBlock){                 //Fonction renvoyant le code pour gerer les                                                                
      String elseStartLabel = getNewLabel();                                                      //branchement if else
      String ifEndLabel = getNewLabel();  
      String res = condition + "\n" + "JUMPF " + elseStartLabel +"\n" 
                 + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
                 + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    public String evalIf(String condition, String ifBlock){                                       //Fonction renvoyant le code pour gerer les
      String ifEndLabel = getNewLabel();                                                          //branchement if
      String res = condition + "\n" + "JUMPF " + ifEndLabel 
                 + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    public String evalReturn(String expr, String exprType){
      AdresseType at = tablesSymboles.getAdresseType("return");
      String res = trad(expr.type, exprType.code, at.type)
                 + "STOREG " + at.adresse + "\n";
                 + "RETURN\n";
    }
}                                                                                                 
  
calcul returns [ String code ]
@init{ $code = new String(); }                                                                    //Initialisation de $code qui contiendra le code
@after{ System.out.println($code); }                                                              //mvap et l'affichera a la fin
    : 
      (declaration { $code += $declaration.code; })*
      { $code += "JUMP " + "Main\n"; }

      NEWLINE*

      (fonction { $code += $fonction.code; })*
      
      NEWLINE*

      { $code += "LABEL " + "Main\n"; }
      (instruction { $code += $instruction.code; })*

      { $code += "\nHALT \n"; }
    ;

block returns [ String code ]                                                                     //Prise en charge des block d'instructions
@init{ $code = new String(); }                                                                   
    :
      '{'
      (instruction { $code += $instruction.code; })*
      '}'
      NEWLINE*
    ;

instruction returns [ String code ]                                                               //Ensemble des types d'instructions que l'on                                                      
    :                                                                                             //peut rencontrer
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

      | loopInstr
        { $code = $loopInstr.code; }

      | ifElseInstr
        { $code = $ifElseInstr.code; }

      | returnInstr finInstruction
        { $code = returnInstr.code; }
    ;

expression returns [ String type, String code ]
    : 
      '(' x = expression ')'                                                                       //Prise en charge de la priorite des parentheses
      { $code = $x.code; }

      | a = expression                                                                             //Priorite de la multiplication
        op1 = ('*' | '/')                                                                          //et de la divison grace
        b = expression                                                                             //a l'ordre de la grammaire
        { $code = $a.code + $b.code + ($op1.text.equals("*") ? "MUL" : "DIV") + "\n"; }

      | c = expression
        op2 = ('+' | '-')
        d = expression
        { $code = $c.code + $d.code + ($op2.text.equals("+") ? "ADD" : "SUB") + "\n"; }

      | op3 = ('-' | '+')                                                                          //Prise en charge d'expression commencant
        e = ENTIER                                                                                 //par le signe moins et plus
        { $code = "PUSHI 0\n" + "PUSHI " + $e.text + "\n" + ($op3.text.equals("+") ? "ADD" : "SUB") + "\n"; }

      | n = ENTIER                                            
        { $code = "PUSHI " + $n.text + "\n"; }

      | id = IDENTIFIANT                                                                           //Prise en charge des variables dans
        { $code = "PUSHG " + tablesSymboles.getAdresseType($id.text).adresse + "\n"; }             //les calculs
    ;

ifElseInstr returns [ String code ]                                                                //Prise en charge des if else
    :
      'if('
      condition
      ')'
      ifblock = block
      { $code = evalIf($condition.code, $ifblock.code); }

      | 'if('
        condition
        ')'
        ifblock = block
        'else'
        elseblock = block
        { $code = evalIfElse($condition.code, $ifblock.code, $elseblock.code); }
    ;

inputInstr returns [ String code ]                                                                 //Fonction prenant les input avec read()
    :
      'read(' 
      id = IDENTIFIANT 
      ')' 
      { $code = "PUSHI 0\nREAD\nSTOREG "+ tablesSymboles.getAdresseType($id.text).adresse + "\n"; }
    ;

outputInstr returns [ String code ]                                                                //Fonction prenant les output avec write()
    :
      'write('
      expression 
      ')' 
      { $code = $expression.code + "WRITE\n"; }
    ;

loopInstr returns [ String code ]                                                                  //Prise en charge des boucles en mvap
    :
      'while('                                                                                     //While loop
      condition
      ')'
      block
      { $code = evalWhileLoop($condition.code, $block.code); }

    | 'for('                                                                                       //For loop
      init = assignation 
      ';'
      condition 
      ';' 
      iteration = assignation 
      ')' 
      block     
    { $code = evalForLoop($init.code, $condition.code, $iteration.code, $block.code); }

    | 'repeat'                                                                                    //Repeat until loop
      block 
      'until(' 
      condition 
      ')'
    { $code = evalRepeatLoop($condition.code, $block.code); }
    ;

conditionAvecLogique returns [ String code ]                                                       //Prise en charge des expressions logiques
    :                                                                                              //dans les conditions
      cond1 = condition
      exprlog = EXPRLOG
      cond2 = condition
      { $code = evalCondAvecLog($cond1.code, $exprlog.text, $cond2.code); }
    ;

condition returns [ String code ]                                                                  //Condition inf sup eq true false ...
    : 
      'true'  { $code = "PUSHI 1\n"; }

      | 'false' { $code = "PUSHI 0\n"; }

      | exp1 = expression
        cond = COND
        exp2 = expression
        { $code = evalCond($exp1.code, $cond.text, $exp2.code); }
    ;

declaration returns [ String code ]                                                                 //Prise en charge des declarations typees 
    :
      type = TYPE 
      id = IDENTIFIANT 
      { $code = evalDeclaration($type.text, $id.text); }

      | type = TYPE                                                                                
        id = IDENTIFIANT
        '='
        expression
        { $code = evalDeclarationExpr($type.text, $id.text, $expression.code); }
    ; 

assignation returns [ String code ]                                                                //Assignation d'une valeur a une variable
    : 
      id = IDENTIFIANT
      '=' 
      expression
      { 
        int adresse = tablesSymboles.getAdresseType($id.text).adresse;
        $code = $expression.code + "STOREG " + adresse + "\n"; 
      }
    ;

fonction returns [ String code ]
@init{ tablesSymboles.newTableLocale(); }       
@after{ tablesSymboles.dropTableLocale(); }     
    : 
      TYPE 
      { tablesSymboles.putVar("return", $TYPE.text); }
      ID  
      '('
      params? 
      ')' 
      { tablesSymboles.newFunction($ID.text, $TYPE.text); }
      block
      {
        $code = "LABEL " + $ID.text;
        $code += $block.code;
      }
    ;

params
    : 
      type = TYPE 
      id = ID
      { tablesSymboles.putVar($id.text, $type.text); }
      ( ',' 
        type2 = TYPE 
        id2 = ID
        { tablesSymboles.putVar($id2.text, $type2.text); }
      )*
    ;

args returns [ String code, int size] 
@init{ $code = new String(); $size = 0; }
    : 
      ( expr = expression
        {
          $code += $expr.code;
          $size++;
          if($expr.type.equals("float")){
            $size++;
          }
        }

        ( ',' expr2 = expression
          {
            $code += $expr2.code; 
            $size++;
            if($expr.type.equals("float")){
              $size++;;
            }
          }
        )*

      )?
    ;

returnInstr returns [ String code ]
    :
      "return" 
      expr = expression
      { $code = evalReturn($expr.code, $expr.type); }
    ;

finInstruction                                                                                      //Reconnaissance des fins d'instructions
    :
      ( NEWLINE | ';' )+ 
    ;


KEYWORDS  : 'if' |'else' | 'break';

EXPRLOG : '&&' | '||' | '!';

COND : '==' | '<' | '>' | '<=' | '>=' | '!=';

TYPE : 'int' | 'float' ;

ENTIER: ('0' ..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')*;

BOOL : 'true' | 'false' ;

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

UNMATCH: . -> skip;