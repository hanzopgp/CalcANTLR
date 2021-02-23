grammar Calculette;

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

start: a = expr EOF {System.out.println($a.val);};

expr
	returns[ int val ]:
	'(' a = expr ')'
	{$val = $a.val;}

	| b = expr
	op = ('/' | '*')
	c = expr
	{$val = evalexpr($b.val, $op.text, $c.val);}

	| d = expr
	op2 = ('+' | '-')
	e = expr
	{$val = evalexpr($d.val, $op2.text, $e.val);}

	| op3 = ('-' | '+')
	f = expr
	{$val = evalexpr(0, $op3.text, $f.val);}

	| g = ENTIER
	{$val = Integer.parseInt($g.text);};

NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;