grammar Sexp;

options {
    output=AST;
    ASTLabelType=CommonTree; // type of $stat.tree ref etc...
}

tokens {

LIST='LIST';
ATOM='ATOM';
ITEMS='ITEMS';
}



sexp	:	atom | list;

atom	:	ALPHANUMERIC;

list	:	'(' items ')';

items 	:	symbol (WSPACE item)*;

item	:	ALPHANUMERIC |  list;

symbol	:	ALPHANUMERIC;

WSPACE	:	(' ' | '\t' | '\n' | '\r' | '\u0000C')+ ;

ALPHANUMERIC
	: (('a'..'z'|'A'..'Z'))* ('0'..'9')*;