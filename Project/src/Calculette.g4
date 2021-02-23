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

        | a = expression
          op1 = ('*' | '/')
          b = expression
          { 
            if($op1.text.equals("*")){
              $code = $a.code + $b.code + "MUL\n";
            }else{
              $code = $a.code + $b.code + "DIV\n"; 
            }
          }

        | c = expression
          op2 = ('+' | '-')
          d = expression
          { 
            if($op2.text.equals("+")){
              $code = $c.code + $d.code + "ADD\n";
            }else{
              $code = $c.code + $d.code + "SUB\n"; 
            }
          }

        | op3 = ('-' | '+')
          e = expression
          { 
            if($op3.text.equals("-")){
              $code = $c.code + $d.code + "ADD\n";
            }else{
              $code = $c.code + $d.code + "SUB\n"; 
            }
          }

        | n = ENTIER
          { $code = "PUSHI " + $n.text + "\n"; }
    ;




finInstruction 
    :
        ( NEWLINE | ';' )+ 
    ;


NEWLINE: '\r'? '\n' -> skip;

WS: (' ' | '\t')+ -> skip;

ENTIER: ('0' ..'9')+;

UNMATCH: . -> skip;
