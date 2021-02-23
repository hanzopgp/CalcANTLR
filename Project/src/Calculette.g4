grammar Calculette;




@parser::members {
    private String buildString (String x, String op, String y) {
        if ( op.equals("*") ){
          System.out.println("X="+x+"Y="+y);
          return "\nPUSHI " + x + "\nPUSHI " + y + "\nMUL";
        } else if ( op.equals("/") ){
          return "\nPUSHI " + x + "\nPUSHI " + y + "\nDIV";
        }  else if ( op.equals("+") ){
          System.out.println("X="+x+"Y="+y);
          return "\nPUSHI " + x + "\nPUSHI " + y + "\nADD";
        }  else if ( op.equals("-") ){
          return "\nPUSHI " + x + "\nPUSHI " + y + "\nSUB";
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
          '(' x = expression ')'
          { $code = $x.code; }

        | a = expression
          op1 = ('*' | '/')
          b = expression
          { $code = buildString($a.code, $op1.text, $b.code); }

        | c = expression
          op2 = ('+' | '-')
          d = expression
          { $code = buildString($c.code, $op2.text, $d.code); }

        | op3 = ('-' | '+')
          e = expression
          { $code = buildString("0", $op3.text, $e.code); }

        | n = ENTIER
          { $code = $n.text; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;


NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
