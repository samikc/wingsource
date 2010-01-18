/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
/*
 * @author <a href="mailto:samikc@gmail.com">Samik Chakraborty</a>
 * @author <a href="mailto:pillvin@gmail.com">Vinod Pillai</a>
 */ 
grammar Sexp;

options {
    output=AST;
    ASTLabelType=CommonTree;
}

tokens {
OPERATION;
OPERATOR;
OPERAND;
}

@header {
package org.wingsource.plugin.sexp.antlr;
}

@lexer::header {
package org.wingsource.plugin.sexp.antlr;
}

sexpr			: (expression| operation)* EOF;
expression 		: '('! operation ')'!;
operation 		: operator (WS operand)* -> ^(OPERATION ^(OPERATOR operator) operand*);
operand			: atom -> ^(OPERAND atom)
			 | expression -> ^(OPERAND expression);
operator		: ALPHANUMERIC | SPECIAL_CHARACTERS;
atom			: ALPHANUMERIC | STRING | FLOAT;
WS		    	: (' ' | '\t' | '\n' | '\r')+;
ALPHANUMERIC 		: ('a'..'z'|'A'..'Z'|'0'..'9')*;
SPECIAL_CHARACTERS	: '^' | '&' | '*' | '-' | '+' | '=' | '/' | '!' | '@' | '#' | '$' | '%';



//String definition
STRING			: '"' (ESC | ~('\\'|'"'))* '"' ;
protected ESC		: '\\' ('t' | '"' | INT)* ;

//Number definition
FLOAT: INT '.' INT ;
INT    			: ('0'..'9')+ ;


