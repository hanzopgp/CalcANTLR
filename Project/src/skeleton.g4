grammar skeleton;

calcul returns [ String code ]
@init{ $code = new String(); }   
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "  HALT\n"; }
    ;




instruction returns [ String code ] 
    : 
        expression finInstruction { $code = $expression.code; }
        | finInstruction { $code=""; }
    ;




expression returns [ String code ]
    : 
        OP ENTIER* { $code = $OP.text + $ENTIER.text; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;


NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

OP : ('PUSHI' | 'ADD' | 'SUB' | 'MUL' | 'DIV');

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
