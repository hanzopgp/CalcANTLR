grammar Calc1 ; 

// Parser ...

calcul 
  : expr calcul 
  | ST ID expr calcul 
  ;

expr
  : NUMBER 
  | ID 
  | PLUS expr expr 
  | MOINS expr expr 
  ;


// Lexer


NUMBER: ('0'..'9')+;

ST: 'S';

ID: ('a'..'z'|'A'..'Z')('a'..'z'|'0'..'9')*;

PLUS: '+';

MOINS: '-';

COMMENT : '/*' .*? '*/' -> skip ;

UNMATCH:. -> skip;
