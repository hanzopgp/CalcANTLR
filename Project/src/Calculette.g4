grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                                                   //liens var/type et les valeurs dans les adresses
    private String getNewLabel() { return "B" +(_cur_label++); }                                  //Generateur de nom d'etiquettes pour les boucles                                

    private String trad(String currentType, String expr, String targetType){
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

    private void tradTwo(String type, String expr, String type2, String expr2, String typeRes, String exprRes){
      if(type.equals(type2)){
        typeRes = type;
        exprRes = expr + expr2;
      }else if(type.equals("float")){
        typeRes = "float";
        exprRes = expr + expr2 + "ITOF\n";
      }else if(type2.equals("float")){
        typeRes = "float";
        exprRes = expr + "ITOF\n" + expr2;
      }
    }

    private String evalDeclaration(String type, String id){                                       //Renvoie le code pour une declaration simple
      tablesSymboles.putVar(id, type);
      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n";
    }

    private String evalDeclarationExpr(String type, String id, String expr, String exprType){     //Renvoie le code pour une declaration assignation
      tablesSymboles.putVar(id, type);  
      AdresseType at = tablesSymboles.getAdresseType(id); 
      return (type.equals("bool") || type.equals("int")) ? "PUSHI 0\n" : "PUSHF 0.0\n"
             + trad(exprType, expr, at.type) + "STOREG "  + at.adresse + "\n";
    }

    private String evalAssign(String id, String expr, String exprType){
      AdresseType at = tablesSymboles.getAdresseType(id);
      return trad(exprType, expr, at.type) + "STOREG " + at.adresse + "\n";
    }

    private String evalCond(String exp1, String cond, String exp2){                               //Fonction renvoyant le code mvap pour chacune 
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

    private String evalWhileLoop(String expr, String exprType, String block){                                  //Fonction renvoyant le code mvap pour creer
      String startLabelW = getNewLabel();                                                                       //les boucles avec leurs conditions et instr
      String endLabelW = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return "LABEL " + startLabelW + "\n" + tradExpr + "JUMPF " + endLabelW + "\n"
             + block + "JUMP " + startLabelW + "\n" + "LABEL " + endLabelW + "\n";
    }

    private String evalForLoop(String init, String expr, String exprType, String iteration, String block){     //Fonction renvoyant le code mvap pour creer une
      String startLabelF = getNewLabel();                                                                       //boucle for
      String endLabelF = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool");
      return init + "LABEL " + startLabelF + "\n" + tradExpr + "JUMPF " + endLabelF + "\n"
             + block + iteration + "JUMP " + startLabelF + "\n" + "LABEL " + endLabelF + "\n";
    }

    private String evalRepeatLoop(String expr, String exprType, String block){                                 //Fonction renvoyant le code mvap pour creer une                  
      String startLabelR = getNewLabel();
      String tradExpr = trad(exprType, expr, "bool"); 
      return "LABEL " + startLabelR + "\n" + block 
             + tradExpr + "\n" + "JUMPF " + startLabelR + "\n";
    }

    private String evalAnd(String expr1Type, String expr1, String expr2Type, String expr2){                    //Fonction renvoyant le code apres avoir tester
      String falseLabel1And = getNewLabel();
      String trueLabel2And = getNewLabel();
      expr1 = trad(expr1Type, expr1, "bool");
      expr2 = trad(expr2Type, expr2, "bool"); 
      return expr1 + "JUMPF " + falseLabel1And + "\n" + expr2 + "JUMP " + trueLabel2And + "\n"                    
              + "LABEL " + falseLabel1And + "\n" + "PUSHI 0\n" + "LABEL " + trueLabel2And + "\n";
    }

    private String evalOr(String expr1Type, String expr1, String expr2Type, String expr2){                    //Fonction renvoyant le code apres avoir tester
      String falseLabel1Or = getNewLabel();
      String trueLabel1Or = getNewLabel();
      expr1 = trad(expr1Type, expr1, "bool");
      expr2 = trad(expr2Type, expr2, "bool"); 
      return expr1 + "JUMPF " + falseLabel1Or + "\n" + "PUSHI 1\n" + "JUMP " + trueLabel1Or + "\n"
             + "LABEL " + falseLabel1Or + expr2 + "LABEL " + trueLabel1Or + "\n";
    }

    private String evalIfElse(String expr, String exprType, String ifBlock, String elseBlock){                 //Fonction renvoyant le code pour gerer les                                                                
      String elseStartLabel = getNewLabel();                                                                   //branchement if else
      String ifEndLabel = getNewLabel(); 
      String tradExpr = trad(exprType, expr, "bool"); 
      String res = tradExpr + "\n" + "JUMPF " + elseStartLabel +"\n" 
                 + ifBlock + "\n" + "JUMP " + ifEndLabel + "\n" + "LABEL " 
                 + elseStartLabel + "\n" + elseBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    private String evalIf(String expr, String exprType, String ifBlock){                                       //Fonction renvoyant le code pour gerer les
      String ifEndLabel = getNewLabel();   
      String tradExpr = trad(exprType, expr, "bool");                                                       //branchement if
      String res = tradExpr + "\n" + "JUMPF " + ifEndLabel 
                 + "\n" + ifBlock + "LABEL " + ifEndLabel + "\n";
      return res;
    }

    private String evalReturn(String expr, String exprType){
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
      addsub
      { $type = $addsub.type; $code = $addsub.code; }

      | muldiv
      { $type = $muldiv.type; $code = $muldiv.code; }

      | cast
      { $type = $cast.type; $code = $cast.code; }

      | condition
      { $type = $condition.type; $code = $condition.code; }

      | andLogic
      { $type = $andLogic.type; $code = $andLogic.code; }

      | orLogic 
      { $type = $orLogic.type; $code = $orLogic.code; }            
    ;

addsub returns [ String type, String code ]
    :
      expr = expression 
      op = ('+'|'-') 
      md = muldiv
      { 
        String typeRes = new String();
        String codeRes = new String();
        tradTwo($expr.type, $expr.code, $md.typef, $md.code, typeRes, codeRes);     
        $type = typeRes;
        $code = codeRes + ($op1.text.equals("+") ? "ADD" : "SUB") + "\n";
      } 
    ;

muldiv returns [ String type, String code ]
    :
      md = muldiv 
      op = ('*'|'/') 
      pp = preparenthesis
      {
        String typeRes = new String();
        String codeRes = new String();
        tradTwo($muldiv.type, $muldiv.code, $pp.typef, $pp.code, typeRes, codeRes);     
        $type = typeRes;
        $code = codeRes + ($op1.text.equals("*") ? "MUL" : "DIV") + "\n";
      }

    | pp = preparenthesis
      { 
        $type = $pp.type;
        $code = $pp.code; 
      }
    ;

cast returns [ String type, String code ]
    :
      '('
      type = TYPE 
      ')' 
      expr = expression        
      {
        $type = $type.text;  
        return trad($expr.type, $expr.code, $type.text);
      }
    ;

condition returns [ String type, String code ]                                                                
    : 
      'true' { $type = "bool"; $code = "PUSHI 1\n"; }

      | 'false' { $type = "bool"; $code = "PUSHI 0\n"; }

      | expr1 = expression
        cond = COND
        expr2 = expression
        { $type = "bool"; $code = evalCond($expr1.code, $cond.text, $expr2.code); }
    ;

andLogic returns [ String type, String code ]
    :
      expr1 = expression 
      '&&' 
      expr2 = expression  
      {
        $type = "bool";
        $code = evalAnd($expr1.type, $expr1.code, $expr2.type, $expr2.code);
      }
    ;

orLogic returns [ String type, String code ]
    :
      expr1 = expression 
      '||' 
      expr2 = expression  
      {
        $type = "bool";
        $code = evalOr($expr1.type, $expr1.code, $expr2.type, $expr2.code);
      }
    ;

preparenthesis returns [ String type, String code ]
    :
      '(' 
      expr = expression 
      ')' 
      { $type = $expr.type; $code = $expr.code; }

    | '-' 
      pp = preparenthesis
      { 
        $type = $pp.type;
        $code = $type.equals("int") ? "PUSHI 0\n SUB" : "PUSHI 0.0\n FSUB";
      }

    | '+' 
      pp = preparenthesis
      { $type = $pp.type; $code = $pp.code; }

    | '!'
      expr = expression
      {
        $type = "bool";
        $code = "PUSHI 1\n" + trad($expr.type, $expr.code, $type) + "SUB\n");
      }

    | atom
      { $type = $atom.type; $code = $atom.code; }
    ;

atom returns [ String type, String code ]
    :
      x = ENTIER
      { $type = "int"; $code = "PUSHI " + x.text + "\n"; }

    | x = FLOAT
      { $type = "float"; $code = "PUSHI " + x.text + "\n"; }

    | x = BOOLEAN
      { $type = "bool"; $code = ($x.text.equals("true") ? "PUSHI 1\n" : "PUSHI 0\n") }

    | id = IDENTIFIANT
      { 
        AdresseType at = tablesSymboles.getAdresseType($id.text); 
        $type = at.type,
        $code = "PUSHG " + at.adresse + "\n";
      }

    | id = IDENTIFIANT
      '('
      args
      ')'
      { 
        $type = tablesSymboles.getFunction($id.text); 
        String pusher = $type.equals("int") ? "PUSHI 666\n" : "PUSHF 0.666\n");
        $code = pusher + $args.code + "CALL " + $id.text + "\n";
        for (int i = 0; i < $args.size; i++){
          $code += "POP\n";       
        }
      }
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

    | 'repeat'                                                                                     //Repeat until loop
      block 
      'until(' 
      expression 
      ')'
      { $code = evalRepeatLoop($expression.code, $expression.type, $block.code); }
    ;

declaration returns [ String code ]                                                                //Prise en charge des declarations typees 
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

assignation returns [ String code ]                                                               //Assignation d'une valeur a une variable
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

COND : '==' | '<' | '>' | '<=' | '>=' | '!=';

TYPE : 'int' | 'float' ;

ENTIER: ('0' ..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')*;

BOOL : 'true' | 'false' ;

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

UNMATCH: . -> skip;