grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
    private int _cur_label = 1;                                                                   //liens var/type et les valeurs dans les adresses
    private String getNewLabel() { return "B" +(_cur_label++); }                                  //Generateur de nom d'etiquettes pour les boucles                                

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

    public String evalLoop(String condition, String block){                                       //Fonction renvoyant le code mvap pour creer
      String startLabel = getNewLabel();                                                          //les boucles avec leurs conditions et instr
      String endLabel = getNewLabel();
      String res = "";
      res += "LABEL " + startLabel + "\n";
      res += condition;
      res += "JUMPF " + endLabel + "\n";
      res += block;
      res += "JUMP " + startLabel + "\n";
      res += "LABEL " + endLabel + "\n";
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
      String startLabel = getNewLabel();                                                          //if else avec condition
      String endLabel = getNewLabel();
      String res = "";
      res += "LABEL " + startLabel + "\n";
      res += condition;
      res += "JUMPF " + endLabel + "\n";
      res += ifBlock;
      res += "JUMP " + startLabel + "\n";
      res += "LABEL " + endLabel + "\n";
      if(elseBlock!=null){
        res += elseBlock;
        res += "JUMP " + startLabel + "\n";
        res += "LABEL " + endLabel + "\n";
      } 
      return res;
    }

}                                                                                                 
  
calcul returns [ String code ]
@init{ $code = new String(); }                                                                    //Initialisation de $code qui contiendra le code
@after{ System.out.println($code); }                                                              //mvap et l'affichera a la fin
    : 
      (declaration { $code += $declaration.code; })*

      NEWLINE*

      (instruction { $code += $instruction.code; })*

      { $code += "\nHALT \n"; }
    ;

block returns [ String code ]                                                                     //Prise en charge des block d'instructions
    :
      { $code = ""; }
      '{'
      (instruction { $code += $instruction.code; })*
      '}'
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

      | branchement
        { $code = $branchement.code; }
    ;

expression returns [ String code ]
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

branchement returns [ String code ]                                                                //Prise en charge des if else
    :
      'if('
      condition
      ')'
      ifblock = block
      ('else'
      elseblock = block)?
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
      'while('
      condition
      ')'
      block
      { $code = evalLoop($condition.code, $block.code); }
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
      {
        if($type.text.equals("int")){
          tablesSymboles.putVar($id.text, "int");
          int adresse = tablesSymboles.getAdresseType($id.text).adresse;
          $code = "PUSHI 0" + "\nSTOREG " + adresse + "\n"; 
        }else if($type.text.equals("float")){
          tablesSymboles.putVar($id.text, "float");
          int adresse = tablesSymboles.getAdresseType($id.text).adresse;
          $code = "PUSHI 0.0" + "\nSTOREG " + adresse + "\n";
        }
      }

      | type = TYPE                                                                                //Et des declarations typees plus assignation
        id = IDENTIFIANT
        '='
        expression
        {
          if($type.text.equals("int")){
            tablesSymboles.putVar($id.text, "int");                                                //On ajoute notre id avec son type pour
            int adresse = tablesSymboles.getAdresseType($id.text).adresse;                         //reserver une adresse
            $code = "PUSHI 0\n" + $expression.code + "STOREG " + adresse + "\n";                   //Puis on la recupere pour le mvap
          }else if($type.text.equals("float")){
            tablesSymboles.putVar($id.text, "float");
            int adresse = tablesSymboles.getAdresseType($id.text).adresse;
            $code = "PUSHI 0.0\n" + $expression.code + "STOREG " + adresse + "\n";
          }
        }
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

finInstruction                                                                                      //Reconnaissance des fins d'instructions
    :
      ( NEWLINE | ';' )+ 
    ;


EXPRLOG : '&&' | '||' | '!';

COND : '==' | '<' | '>' | '<=' | '>=' | '!=';

TYPE : 'int' | 'float' ;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')+;

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*;

UNMATCH: . -> skip;
