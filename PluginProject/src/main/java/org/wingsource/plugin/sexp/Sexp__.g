lexer grammar Sexp;
@header {
package org.wingsource.plugin.sexp;
}

T6 : '(' ;
T7 : ')' ;

// $ANTLR src "D:\dev\PluginProject\src\org\wingsource\plugin\sexp\Sexp.g" 43
WS		    	: (' ' | '\t' | '\n' | '\r')+ ;
// $ANTLR src "D:\dev\PluginProject\src\org\wingsource\plugin\sexp\Sexp.g" 44
ALPHANUMERIC 	: ('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9')*;
