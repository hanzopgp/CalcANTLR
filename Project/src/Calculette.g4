grammar Calculette;

@members {
    private TablesSymboles tablesSymboles = new TablesSymboles();                                 //On utilise la table de symboles pour garder les
}                                                                                                 //liens var/type et les valeurs dans les adresses
  
calcul returns [ String code ]
@init{ $code = new String(); }                                                                    //Initialisation de $code qui contiendra le code
@after{ System.out.println($code); }                                                              //mvap et l'affichera a la fin
    : 
      (declaration { $code += $declaration.code; })*

      NEWLINE*

      (instruction { $code += $instruction.code; })*

      { $code += "\nHALT \n"; }
    ;

instruction returns [ String code ] 
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
      { $code = $expression.code + "WRITE\nPOP\n"; }
    ;

declaration returns [ String code ] 
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

      | type = TYPE
        id = IDENTIFIANT
        '='
        expression
        {
          if($type.text.equals("int")){
            tablesSymboles.putVar($id.text, "int");                                                //On ajoute notre id avec son type pour
            int adresse = tablesSymboles.getAdresseType($id.text).adresse;                         //reserver une adresse
            $code = "PUSHI 0\n" + $expression.code + "\nSTOREG " + adresse + "\n";                 //Puis on la recupere pour le mvap
          }else if($type.text.equals("float")){
            tablesSymboles.putVar($id.text, "float");
            int adresse = tablesSymboles.getAdresseType($id.text).adresse;
            $code = "PUSHI 0\n" + $expression.code + "\nSTOREG " + adresse + "\n";
          }
        }
    ; 

assignation returns [ String code ]                                                                //Assignation a une variable
    : 
      id = IDENTIFIANT
      '=' 
      expression
      { 
        int adresse = tablesSymboles.getAdresseType($id.text).adresse;
        $code = $expression.code + "STOREG " + adresse + "\n"; 
      }
    ;

finInstruction 
    :
      ( NEWLINE | ';' )+ 
    ;




TYPE : 'int' | 'float' ;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

FLOAT: ('0'..'9')+'.'('0'..'9')+;

IDENTIFIANT: ('a'..'z' | 'A'..'Z')+('0'..'9')*;

UNMATCH: . -> skip;
