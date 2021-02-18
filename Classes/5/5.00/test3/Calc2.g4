grammar Calc2 ; 

@members {
	int store = 0;
}

// Parser ...

calcul 
  : expr calcul { System.out.println($expr.val); }
  | ST ID NUMBER calcul { store = $NUMBER.int;}
  ;

expr returns [int val]
  : NUMBER { $val = $NUMBER.int ;}
  | ID { $val = store;}
  | PLUS a=expr b=expr { $val = $a.val + $b.val;}  
  | MOINS a=expr b=expr { $val = $a.val - $b.val;}
  ;


// Lexer


NUMBER: ('0'..'9')+;

ST: 'STORE';

ID: ('a'..'z'|'A'..'Z')('a'..'z'|'0'..'9')*;

PLUS: '+';

MOINS: '-';

COMMENT: '/*' .*? '*/' -> skip ;

UNMATCH: . -> skip;
