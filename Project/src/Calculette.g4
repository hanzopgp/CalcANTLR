grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                                                   //liens var/type et les valeurs dans les adresses
    private String getNewLabel() { return "B" +(_cur_label++); }                                  //Generateur de nom d'etiquettes pour les boucles                                

    public String trad(String currentType, String expr, String targetType){
      String res = expr;
      switch(targetType){
        case "int":
          if(currentType.equals("float")){
            res += "FTOI\n";   
          }
          break;  
        case "float":   
          res += "ITOF\n";
          break;                             
        case "bool":    
          String trueLabel = getNewLabel();
          String falseLabel = getNewLabel();                           
          String pushType;
          String equalType;
          if(currentType.equals("float")){
            pushType = "PUSHF 0\n";
            equalType = "FEQUAL\n";
          }else{
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

    public String evalDeclaration(String type, String id){                                                     //Renvoie le code pour une declaration simple
      tablesSymboles.putVar(id, type);
      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n";
    }

    public String evalDeclarationExpr(String type, String id, String expr, String exprType){                              //Renvoie le code pour une declaration assignation
      tablesSymboles.putVar(id, type);  
      AdresseType at = tablesSymboles.getAdresseType(id); 
      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n"
             + trad(exprType, expr, at.type) + "STOREG "  + at.adresse + "\n";
    }

    public String evalAssign(String id, String expr, String exprType){
      AdresseType at = tablesSymboles.getAdresseType(id);
      return trad(exprType, expr, at.type) + "STOREG " + at.adresse + "\n";
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

    public String evalWhileLoop(String expr, String exprType, String block){                                  //Fonction renvoyant le code mvap pour creer
      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
      String endLabel = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return "LABEL " + startLabel + "\n" + tradExpr + "JUMPF " + endLabel + "\n"
             + block + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
    }

    public String evalForLoop(String init, String expr, String exprType, String iteration, String block){     //Fonction renvoyant le code mvap pour creer une
      String startLabel = getNewLabel();                                                          //boucle for
      String endLabel = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return init + "LABEL " + startLabel + "\n" + tradExpr + "JUMPF " + endLabel + "\n"
             + block + iteration + "JUMP " + startLabel + "\n" + "LABEL " + endLabel + "\n";
    }

    public String evalRepeatLoop(String expr, String exprType, String block){                                 //Fonction renvoyant le code mvap pour creer une                  
      String startLabel = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool"); 
      return "LABEL " + startLabel + "\n" + block 
             + tradExpr + "\n" + "JUMPF " + startLabel + "\n";
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

    public String evalIfElse(String expr, String exprType, String ifBlock, String elseBlock){                 //Fonction renvoyant le code pour gerer les                                                                
      String elseStartLabel = getNewLabel();                                                      //branchement if else
      String ifEndLabel = getNewLabel(); 
      String tradExpr = trad(exprType, expr, "bool"); 
      String res = tradExpr + "\n" + "JUMPF " + elseStartLabel +"\n" 
                 + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
                 + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    public String evalIf(String expr, String exprType, String ifBlock){                                       //Fonction renvoyant le code pour gerer les
      String ifEndLabel = getNewLabel();   
      String tradExpr = trad(exprType, expr, "bool");                                                       //branchement if
      String res = tradExpr + "\n" + "JUMPF " + ifEndLabel 
                 + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    public String evalReturn(String expr, String exprType){
      AdresseType at = tablesSymboles.getAdresseType("return");
      String res = trad(expr, exprType, at.type)
                 + "STOREG " + at.adresse + "\n" + "RETURN\n";
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
        { $code = $returnInstr.code; }
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
      expression
      ')'
      ifblock = block
      { $code = evalIf($expression.code, $expression.type, $ifblock.code); }

      | 'if('
        expression
        ')'
        ifblock = block
        'else'
        elseblock = block
        { $code = evalIfElse($expression.code, $expression.type, $ifblock.code, $elseblock.code); }
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
      expression
      ')'
      block
      { $code = evalWhileLoop($expression.code, $expression.type, $block.code); }

    | 'for('                                                                                       //For loop
      init = assignation 
      ';'
      expression 
      ';' 
      iteration = assignation 
      ')' 
      block     
    { $code = evalForLoop($init.code, $expression.code, $expression.type, $iteration.code, $block.code); }

    | 'repeat'                                                                                    //Repeat until loop
      block 
      'until(' 
      expression 
      ')'
    { $code = evalRepeatLoop($expression.code, $expression.type, $block.code); }
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
        expr = expression
        { $code = evalDeclarationExpr($type.text, $id.text, $expr.code, $expr.type); }
    ; 

assignation returns [ String code ]                                                                //Assignation d'une valeur a une variable
    : 
      id = IDENTIFIANT
      '=' 
      expr = expression
      { $code = evalAssign($id.text, $expr.code, $expr.type); }
    ;

fonction returns [ String code ]
@init{ tablesSymboles.newTableLocale(); }       
@after{ tablesSymboles.dropTableLocale(); }     
    : 
      type = TYPE 
      { tablesSymboles.putVar("return", $type.text); }
      id = IDENTIFIANT 
      '('
      params? 
      ')' 
      { tablesSymboles.newFunction($id.text, $type.text); }
      block
      {
        $code = "LABEL " + $id.text;
        $code += $block.code;
      }
    ;

params
    : 
      type = TYPE 
      id = IDENTIFIANT
      { tablesSymboles.putVar($id.text, $type.text); }
      ( ',' 
        type2 = TYPE 
        id2 = IDENTIFIANT
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
      'return' 
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