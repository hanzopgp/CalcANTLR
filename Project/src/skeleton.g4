calcul returns [ String code ]
@init{ $code = new String(); }   
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;




instruction returns [ String code ] 
    : expression finInstruction 
        { 
            $code += $expression.code + "\n";
        }
   | finInstruction
        {
            $code="";
        }
    ;




expression returns [ String code ]
    : 
        PUSHI ENTIER*
        | ADD
        | SUB
        | MUL
        | DIV
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;




NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
