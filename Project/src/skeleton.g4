grammar skeleton;




calcul returns [ String code ]
@init{ $code = new String(); }   
@after{ System.out.println($code); }
    : 
        NEWLINE*

        (instruction { $code += $instruction.code; })*

        { $code += "\nHALT \n"; }
    ;




instruction returns [ String code ] 
    : 
        expression finInstruction { $code = $expression.code; }
        | finInstruction { $code=""; }
    ;




expression returns [ String code ]
    : 
          '(' x = expression ')'
          {$code = $x.code;}

        | '+'
          { $code = "\nADD \n"; }

        | '-'
          { $code = "\nSUB \n"; }

        | '*'
          { $code = "\nMUL \n"; }

        | '/'
          { $code = "\nDIV \n"; }

        | n = ENTIER
          { $code = "PUSHI" + $n.text; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;




NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
