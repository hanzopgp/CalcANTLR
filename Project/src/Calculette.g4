grammar Calculette;




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
          { $code = $x.code; }

        | '+'
          a = ENTIER
          { $code = "\nPUSHI " + $a.text + "\nADD"; }

        | '-'
          b = ENTIER
          { $code = "\nPUSHI " + $b.text + "\nSUB"; }

        | '*'
          c = ENTIER
          { $code = "\nPUSHI " + $c.text + "\nMUL"; }

        | '/'
          d = ENTIER
          { $code = "\nPUSHI " + $d.text + "\nDIV"; }

        | n = ENTIER
          { $code = "\nPUSHI " + $n.text; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;


OPERATOR: ('+' | '-' | '*' | '/');

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
