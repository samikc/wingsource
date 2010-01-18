lexer grammar Sexp;
@header {
package org.wingsource.plugin.sexp.antlr;
}

T14 : '(' ;
T15 : ')' ;

// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 50
WS		    	: (' ' | '\t' | '\n' | '\r')+;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 51
ALPHANUMERIC 		: ('a'..'z'|'A'..'Z'|'0'..'9')*;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 52
SPECIAL_CHARACTERS	: '^' | '&' | '*' | '-' | '+' | '=' | '/' | '!' | '@' | '#' | '$' | '%';



//String definition
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 57
STRING			: '"' (ESC | ~('\\'|'"'))* '"' ;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 58
protected ESC		: '\\' ('t' | '"' | INT)* ;

//Number definition
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 61
FLOAT: INT '.' INT ;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 62
INT    			: ('0'..'9')+ ;


