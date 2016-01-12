grammar G0;

@header{package question3;}

e : e (PLUS | MINUS) f | f;
f : LPAR ID RPAR f | g;
g : g (LBRACKET e RBRACKET | POINT ID) | a;
a : LPAR e RPAR | NUM | ID;

NUM : [0-9]+;
ID : [a-zA-Z0-9]+;

PLUS : '+';
MINUS : '-';
LPAR : '(';
RPAR : ')';

LBRACKET : '[';
RBRACKET : ']';

POINT : '.';
