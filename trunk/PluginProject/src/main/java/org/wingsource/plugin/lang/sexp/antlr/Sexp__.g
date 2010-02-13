lexer grammar Sexp;
@header {
package org.wingsource.plugin.sexp.antlr;
}

T14 : '(' ;
T15 : ')' ;

// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 50
WS		    	: (' ' | '\t' | '\n' | '\r')+;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 51
ALPHANUMERIC 		: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 52
SPECIAL_CHARACTERS	: '^' | '&' | '*' | '-' | '+' | '=' | '/' | '!' | '@' | '#' | '$' | '%';
//String definition
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 54
STRING			: '"' (ESC | ~('\\'|'"'))* '"' ;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 55
protected ESC		: '\\' ('t' | '"' | '0'..'9')* ;
//Number definition
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 57
INT			: ('-' | '+')? ('0'..'9')+;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 58
FLOAT			: ('-' | '+')? ('0'..'9')* '.' ('0'..'9')+ ;

