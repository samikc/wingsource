// $ANTLR 3.0.1 D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g 2010-01-09 15:30:31

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "ALPHANUMERIC", "'('", "')'"
    };
    public static final int WS=4;
    public static final int EOF=-1;
    public static final int ALPHANUMERIC=5;

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
    public String getGrammarFileName() { return "D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g"; }


    public static class sexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start sexpr
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:37:1: sexpr : ( list )* EOF ;
    public final sexpr_return sexpr() throws RecognitionException {
        sexpr_return retval = new sexpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EOF2=null;
        list_return list1 = null;


        CommonTree EOF2_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:37:9: ( ( list )* EOF )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:37:11: ( list )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:37:11: ( list )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=ALPHANUMERIC && LA1_0<=6)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:37:11: list
            	    {
            	    pushFollow(FOLLOW_list_in_sexpr55);
            	    list1=list();
            	    _fsp--;

            	    adaptor.addChild(root_0, list1.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            EOF2=(Token)input.LT(1);
            match(input,EOF,FOLLOW_EOF_in_sexpr58); 
            EOF2_tree = (CommonTree)adaptor.create(EOF2);
            adaptor.addChild(root_0, EOF2_tree);


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

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start list
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:38:1: list : ( '(' items ')' | items );
    public final list_return list() throws RecognitionException {
        list_return retval = new list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal3=null;
        Token char_literal5=null;
        items_return items4 = null;

        items_return items6 = null;


        CommonTree char_literal3_tree=null;
        CommonTree char_literal5_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:38:8: ( '(' items ')' | items )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==6) ) {
                alt2=1;
            }
            else if ( (LA2_0==ALPHANUMERIC) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("38:1: list : ( '(' items ')' | items );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:38:10: '(' items ')'
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    char_literal3=(Token)input.LT(1);
                    match(input,6,FOLLOW_6_in_list67); 
                    char_literal3_tree = (CommonTree)adaptor.create(char_literal3);
                    adaptor.addChild(root_0, char_literal3_tree);

                    pushFollow(FOLLOW_items_in_list69);
                    items4=items();
                    _fsp--;

                    adaptor.addChild(root_0, items4.getTree());
                    char_literal5=(Token)input.LT(1);
                    match(input,7,FOLLOW_7_in_list71); 
                    char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
                    adaptor.addChild(root_0, char_literal5_tree);


                    }
                    break;
                case 2 :
                    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:38:26: items
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_items_in_list75);
                    items6=items();
                    _fsp--;

                    adaptor.addChild(root_0, items6.getTree());

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
    // $ANTLR end list

    public static class items_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start items
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:39:1: items : operator ( WS operand )* ;
    public final items_return items() throws RecognitionException {
        items_return retval = new items_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS8=null;
        operator_return operator7 = null;

        operand_return operand9 = null;


        CommonTree WS8_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:39:10: ( operator ( WS operand )* )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:39:12: operator ( WS operand )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_operator_in_items85);
            operator7=operator();
            _fsp--;

            adaptor.addChild(root_0, operator7.getTree());
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:39:21: ( WS operand )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:39:22: WS operand
            	    {
            	    WS8=(Token)input.LT(1);
            	    match(input,WS,FOLLOW_WS_in_items88); 
            	    WS8_tree = (CommonTree)adaptor.create(WS8);
            	    adaptor.addChild(root_0, WS8_tree);

            	    pushFollow(FOLLOW_operand_in_items90);
            	    operand9=operand();
            	    _fsp--;

            	    adaptor.addChild(root_0, operand9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


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
    // $ANTLR end items

    public static class operand_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start operand
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:40:1: operand : ( atom | list );
    public final operand_return operand() throws RecognitionException {
        operand_return retval = new operand_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        atom_return atom10 = null;

        list_return list11 = null;



        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:40:11: ( atom | list )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==ALPHANUMERIC) ) {
                alt4=1;
            }
            else if ( (LA4_0==6) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("40:1: operand : ( atom | list );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:40:13: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_operand101);
                    atom10=atom();
                    _fsp--;

                    adaptor.addChild(root_0, atom10.getTree());

                    }
                    break;
                case 2 :
                    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:40:20: list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_in_operand105);
                    list11=list();
                    _fsp--;

                    adaptor.addChild(root_0, list11.getTree());

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
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:41:1: operator : ALPHANUMERIC ;
    public final operator_return operator() throws RecognitionException {
        operator_return retval = new operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALPHANUMERIC12=null;

        CommonTree ALPHANUMERIC12_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:41:11: ( ALPHANUMERIC )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:41:13: ALPHANUMERIC
            {
            root_0 = (CommonTree)adaptor.nil();

            ALPHANUMERIC12=(Token)input.LT(1);
            match(input,ALPHANUMERIC,FOLLOW_ALPHANUMERIC_in_operator113); 
            ALPHANUMERIC12_tree = (CommonTree)adaptor.create(ALPHANUMERIC12);
            adaptor.addChild(root_0, ALPHANUMERIC12_tree);


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
    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:42:1: atom : ALPHANUMERIC ;
    public final atom_return atom() throws RecognitionException {
        atom_return retval = new atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALPHANUMERIC13=null;

        CommonTree ALPHANUMERIC13_tree=null;

        try {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:42:8: ( ALPHANUMERIC )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:42:10: ALPHANUMERIC
            {
            root_0 = (CommonTree)adaptor.nil();

            ALPHANUMERIC13=(Token)input.LT(1);
            match(input,ALPHANUMERIC,FOLLOW_ALPHANUMERIC_in_atom122); 
            ALPHANUMERIC13_tree = (CommonTree)adaptor.create(ALPHANUMERIC13);
            adaptor.addChild(root_0, ALPHANUMERIC13_tree);


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


 

    public static final BitSet FOLLOW_list_in_sexpr55 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_EOF_in_sexpr58 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_6_in_list67 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_items_in_list69 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7_in_list71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_items_in_list75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_operator_in_items85 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_items88 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_operand_in_items90 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_atom_in_operand101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_operand105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUMERIC_in_operator113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUMERIC_in_atom122 = new BitSet(new long[]{0x0000000000000002L});

}