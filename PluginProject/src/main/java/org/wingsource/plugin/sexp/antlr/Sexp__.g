lexer grammar Sexp;
@header {
package org.wingsource.plugin.sexp.antlr;
}

T8 : '(' ;
T9 : ')' ;

// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 49
WS		    	: (' ' | '\t' | '\n' | '\r')+;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 50
ALPHANUMERIC 	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*;

