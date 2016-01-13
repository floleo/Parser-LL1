/**
 * Define a grammar called Hello
 */
grammar Hello;

options {k=1; filter=true;}
s : ID+ NUM EOF {System.out.println("This is a Context-Free Grammar");};  
ID : [a-z|A-Z]+ ;  
NUM: [0-9]+ | EPS ;
EPS: '?';

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines

