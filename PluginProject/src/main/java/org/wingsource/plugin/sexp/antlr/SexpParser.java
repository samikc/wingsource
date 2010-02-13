// $ANTLR 3.0.1 D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g 2010-01-20 22:50:35

package org.wingsource.plugin.sexp.antlr;


import org.antlr.runtime.*;

import org.antlr.runtime.tree.*;

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
public class SexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OPERATION", "OPERATOR", "OPERAND", "WS", "ALPHANUMERIC", "SPECIAL_CHARACTERS", "STRING", "FLOAT", "INT", "ESC", "'('", "')'"
    };
    public static final int SPECIAL_CHARACTERS=9;
    public static final int WS=7;
    public static final int ESC=13;
    public static final int OPERATOR=5;
    public static final int ALPHANUMERIC=8;
    public static final int OPERAND=6;
    public static final int INT=12;
    public static final int FLOAT=11;
    public static final int OPERATION=4;
    public static final int EOF=-1;
    public static final int STRING=10;

        public SexpParser(TokenStream input) {
            super(input);
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g"; }


    public static class sexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start sexpr
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:1: sexpr : ( expression | operation )* EOF ;
    public final sexpr_return sexpr() throws RecognitionException {
        sexpr_return retval = new sexpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF3=null;
        expression_return expression1 = null;

        operation_return operation2 = null;


        CommonTree EOF3_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:9: ( ( expression | operation )* EOF )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:11: ( expression | operation )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:11: ( expression | operation )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }
                else if ( ((LA1_0>=ALPHANUMERIC && LA1_0<=SPECIAL_CHARACTERS)) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:12: expression
            	    {
            	    pushFollow(FOLLOW_expression_in_sexpr70);
            	    expression1=expression();
            	    _fsp--;

            	    adaptor.addChild(root_0, expression1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:43:24: operation
            	    {
            	    pushFollow(FOLLOW_operation_in_sexpr73);
            	    operation2=operation();
            	    _fsp--;

            	    adaptor.addChild(root_0, operation2.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF3=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_sexpr77); 
            EOF3_tree = (CommonTree)adaptor.create(EOF3);
            adaptor.addChild(root_0, EOF3_tree);


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end sexpr

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expression
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:44:1: expression : '(' operation ')' ;
    public final expression_return expression() throws RecognitionException {
        expression_return retval = new expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal4=null;
        Token char_literal6=null;
        operation_return operation5 = null;


        CommonTree char_literal4_tree=null;
        CommonTree char_literal6_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:44:14: ( '(' operation ')' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:44:16: '(' operation ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal4=(Token)input.LT(1);
            match(input,14,FOLLOW_14_in_expression86); 
            pushFollow(FOLLOW_operation_in_expression89);
            operation5=operation();
            _fsp--;

            adaptor.addChild(root_0, operation5.getTree());
            char_literal6=(Token)input.LT(1);
            match(input,15,FOLLOW_15_in_expression91); 

            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expression

    public static class operation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operation
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:1: operation : operator ( WS operand )* -> ^( OPERATION ^( OPERATOR operator ) ( operand )* ) ;
    public final operation_return operation() throws RecognitionException {
        operation_return retval = new operation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS8=null;
        operator_return operator7 = null;

        operand_return operand9 = null;


        CommonTree WS8_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleSubtreeStream stream_operand=new RewriteRuleSubtreeStream(adaptor,"rule operand");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:13: ( operator ( WS operand )* -> ^( OPERATION ^( OPERATOR operator ) ( operand )* ) )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:15: operator ( WS operand )*
            {
            pushFollow(FOLLOW_operator_in_operation101);
            operator7=operator();
            _fsp--;

            stream_operator.add(operator7.getTree());
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:24: ( WS operand )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==WS) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:25: WS operand
            	    {
            	    WS8=(Token)input.LT(1);
            	    match(input,WS,FOLLOW_WS_in_operation104); 
            	    stream_WS.add(WS8);

            	    pushFollow(FOLLOW_operand_in_operation106);
            	    operand9=operand();
            	    _fsp--;

            	    stream_operand.add(operand9.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            // AST REWRITE
            // elements: operator, operand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 45:38: -> ^( OPERATION ^( OPERATOR operator ) ( operand )* )
            {
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:41: ^( OPERATION ^( OPERATOR operator ) ( operand )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(OPERATION, "OPERATION"), root_1);

                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:53: ^( OPERATOR operator )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(adaptor.create(OPERATOR, "OPERATOR"), root_2);

                adaptor.addChild(root_2, stream_operator.next());

                adaptor.addChild(root_1, root_2);
                }
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:45:74: ( operand )*
                while ( stream_operand.hasNext() ) {
                    adaptor.addChild(root_1, stream_operand.next());

                }
                stream_operand.reset();

                adaptor.addChild(root_0, root_1);
                }

            }



            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operation

    public static class operand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operand
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:46:1: operand : ( atom -> ^( OPERAND atom ) | expression -> ^( OPERAND expression ) );
    public final operand_return operand() throws RecognitionException {
        operand_return retval = new operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        atom_return atom10 = null;

        expression_return expression11 = null;


        RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:46:11: ( atom -> ^( OPERAND atom ) | expression -> ^( OPERAND expression ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ALPHANUMERIC||(LA3_0>=STRING && LA3_0<=INT)) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("46:1: operand : ( atom -> ^( OPERAND atom ) | expression -> ^( OPERAND expression ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:46:13: atom
                    {
                    pushFollow(FOLLOW_atom_in_operand132);
                    atom10=atom();
                    _fsp--;

                    stream_atom.add(atom10.getTree());

                    // AST REWRITE
                    // elements: atom
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 46:18: -> ^( OPERAND atom )
                    {
                        // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:46:21: ^( OPERAND atom )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(OPERAND, "OPERAND"), root_1);

                        adaptor.addChild(root_1, stream_atom.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;
                case 2 :
                    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:47:7: expression
                    {
                    pushFollow(FOLLOW_expression_in_operand148);
                    expression11=expression();
                    _fsp--;

                    stream_expression.add(expression11.getTree());

                    // AST REWRITE
                    // elements: expression
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 47:18: -> ^( OPERAND expression )
                    {
                        // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:47:21: ^( OPERAND expression )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(adaptor.create(OPERAND, "OPERAND"), root_1);

                        adaptor.addChild(root_1, stream_expression.next());

                        adaptor.addChild(root_0, root_1);
                        }

                    }



                    }
                    break;

            }
            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operand

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operator
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:48:1: operator : ( ALPHANUMERIC | SPECIAL_CHARACTERS );
    public final operator_return operator() throws RecognitionException {
        operator_return retval = new operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set12=null;

        CommonTree set12_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:48:11: ( ALPHANUMERIC | SPECIAL_CHARACTERS )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set12=(Token)input.LT(1);
            if ( (input.LA(1)>=ALPHANUMERIC && input.LA(1)<=SPECIAL_CHARACTERS) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set12));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_operator0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end operator

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start atom
    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:49:1: atom : ( ALPHANUMERIC | STRING | FLOAT | INT );
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set13=null;

        CommonTree set13_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:49:8: ( ALPHANUMERIC | STRING | FLOAT | INT )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set13=(Token)input.LT(1);
            if ( input.LA(1)==ALPHANUMERIC||(input.LA(1)>=STRING && input.LA(1)<=INT) ) {
                input.consume();
                adaptor.addChild(root_0, adaptor.create(set13));
                errorRecovery=false;
            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recoverFromMismatchedSet(input,mse,FOLLOW_set_in_atom0);    throw mse;
            }


            }

            retval.stop = input.LT(-1);

                retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end atom


 

    public static final BitSet FOLLOW_expression_in_sexpr70 = new BitSet(new long[]{0x0000000000004300L});
    public static final BitSet FOLLOW_operation_in_sexpr73 = new BitSet(new long[]{0x0000000000004300L});
    public static final BitSet FOLLOW_EOF_in_sexpr77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_expression86 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_operation_in_expression89 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_expression91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_operation101 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_WS_in_operation104 = new BitSet(new long[]{0x0000000000005D00L});
    public static final BitSet FOLLOW_operand_in_operation106 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_atom_in_operand132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_operand148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_atom0 = new BitSet(new long[]{0x0000000000000002L});

}