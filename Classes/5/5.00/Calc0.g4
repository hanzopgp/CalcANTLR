lexer grammar Calc0 ; 

// Lexer


NUMBER: ('0'..'9')+ ;

ST: 'S';

ID: ('a'..'z'|'A'..'Z')('a'..'z'|'0'..'9')*;

PLUS: '+';

MOINS: '-';

COMMENT : '/*' .*? '*/' -> skip ;

UNMATCH: . -> skip;
