grammar skeleton;

@parser::members {
    private int evalexpr (int x, String op, int y) {
        if ( op.equals("*") ){
            return x * y;
        } else if ( op.equals("/") ){
            return x / y;
        }  else if ( op.equals("+") ){
            return x + y;
        }  else if ( op.equals("-") ){
            return x - y;
        } else {
           System.err.println("Opérateur arithmétique incorrect : '" + op + "'");
           throw new IllegalArgumentException("Opérateur arithmétique incorrect : '" + op + "'");
        }
    }
}




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
        | a = ENTIER
          +
          b = ENTIER
          { $code = "PUSHI $a.text \nPUSHI $b.text \nADD \n"; }

        | c = ENTIER
          '-'
          d = ENTIER
          { $code = "PUSHI $c.text \nPUSHI $d.text \nSUB \n"; }

        | e = ENTIER
          '*'
          f = ENTIER
          { $code = "PUSHI $e.text \nPUSHI $f.text \nMUL \n"; }

        | g = ENTIER
          '/'
          h = ENTIER
          { $code = "PUSHI $g.text \nPUSHI $h.text \nDIV \n"; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;




NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
