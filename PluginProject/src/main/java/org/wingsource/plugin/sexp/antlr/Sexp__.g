lexer grammar Sexp;
@header {
package org.wingsource.plugin.sexp.antlr;
}

T9 : '(' ;
T10 : ')' ;

// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 50
WS		    	: (' ' | '\t' | '\n' | '\r')+;
// $ANTLR src "D:\dev\PluginProject\src\main\java\org\wingsource\plugin\sexp\antlr\Sexp.g" 51
ALPHANUMERIC 	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*;

