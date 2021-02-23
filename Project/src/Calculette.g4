grammar Calculette;

calcul returns [ String code ]
@init{ $code = new String(); }   
@after{ System.out.println($code); }
    : 
        (decl { $code += $decl.code; })*

        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "\nHALT \n"; }
    ;

instruction returns [ String code ] 
    : 
          expression finInstruction 
          { $code = $expression.code; }

        | finInstruction 
          { $code=""; }
    ;

expression returns [ String code ]
    : 
          '(' x = expression ')'                                                                     //Prise en charge de la priorite des parentheses
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

        | ID                                                                                          //Prise en charge des identifiants permettant
          '='                                                                                         //de stocker un element dans une variable
          f = expression
          { $code = "STORE " + $f.text + "\n"; }
    ;

finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;

decl returns [ String code ] 
    :
        TYPE IDENTIFIANT finInstruction
        {
            // à compléter
        }
    ; 

assignation returns [ String code ] 
    : IDENTIFIANT '=' expression
        {  
            // à compléter
        }
    ;




TYPE : 'int' | 'float' ;

ID: ('a'..'z' | 'A'..'Z')+;

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
