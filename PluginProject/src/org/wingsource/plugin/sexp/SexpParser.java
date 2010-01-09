package org.wingsource.plugin.sexp;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 \\samikc\\grammar\\Sexp.g 2010-01-09 12:07:39

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class SexpParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "LIST", "ATOM", "ITEMS", "ALPHANUMERIC", "WSPACE", "'('", "')'"
    };
    public static final int ALPHANUMERIC=7;
    public static final int T__10=10;
    public static final int ITEMS=6;
    public static final int WSPACE=8;
    public static final int ATOM=5;
    public static final int EOF=-1;
    public static final int LIST=4;
    public static final int T__9=9;

    // delegates
    // delegators


        public SexpParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SexpParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return SexpParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\samikc\\grammar\\Sexp.g"; }


    public static class sexp_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sexp"
    // C:\\Users\\samikc\\grammar\\Sexp.g:17:1: sexp : ( atom | list );
    public final SexpParser.sexp_return sexp() throws RecognitionException {
        SexpParser.sexp_return retval = new SexpParser.sexp_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        SexpParser.atom_return atom1 = null;

        SexpParser.list_return list2 = null;



        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:17:6: ( atom | list )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==ALPHANUMERIC) ) {
                alt1=1;
            }
            else if ( (LA1_0==9) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\samikc\\grammar\\Sexp.g:17:8: atom
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_atom_in_sexp57);
                    atom1=atom();

                    state._fsp--;

                    adaptor.addChild(root_0, atom1.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\samikc\\grammar\\Sexp.g:17:15: list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_in_sexp61);
                    list2=list();

                    state._fsp--;

                    adaptor.addChild(root_0, list2.getTree());

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
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sexp"

    public static class atom_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "atom"
    // C:\\Users\\samikc\\grammar\\Sexp.g:19:1: atom : ALPHANUMERIC ;
    public final SexpParser.atom_return atom() throws RecognitionException {
        SexpParser.atom_return retval = new SexpParser.atom_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALPHANUMERIC3=null;

        CommonTree ALPHANUMERIC3_tree=null;

        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:19:6: ( ALPHANUMERIC )
            // C:\\Users\\samikc\\grammar\\Sexp.g:19:8: ALPHANUMERIC
            {
            root_0 = (CommonTree)adaptor.nil();

            ALPHANUMERIC3=(Token)match(input,ALPHANUMERIC,FOLLOW_ALPHANUMERIC_in_atom69); 
            ALPHANUMERIC3_tree = (CommonTree)adaptor.create(ALPHANUMERIC3);
            adaptor.addChild(root_0, ALPHANUMERIC3_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class list_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "list"
    // C:\\Users\\samikc\\grammar\\Sexp.g:21:1: list : '(' items ')' ;
    public final SexpParser.list_return list() throws RecognitionException {
        SexpParser.list_return retval = new SexpParser.list_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal4=null;
        Token char_literal6=null;
        SexpParser.items_return items5 = null;


        CommonTree char_literal4_tree=null;
        CommonTree char_literal6_tree=null;

        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:21:6: ( '(' items ')' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:21:8: '(' items ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            char_literal4=(Token)match(input,9,FOLLOW_9_in_list77); 
            char_literal4_tree = (CommonTree)adaptor.create(char_literal4);
            adaptor.addChild(root_0, char_literal4_tree);

            pushFollow(FOLLOW_items_in_list79);
            items5=items();

            state._fsp--;

            adaptor.addChild(root_0, items5.getTree());
            char_literal6=(Token)match(input,10,FOLLOW_10_in_list81); 
            char_literal6_tree = (CommonTree)adaptor.create(char_literal6);
            adaptor.addChild(root_0, char_literal6_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list"

    public static class items_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "items"
    // C:\\Users\\samikc\\grammar\\Sexp.g:23:1: items : symbol ( WSPACE item )* ;
    public final SexpParser.items_return items() throws RecognitionException {
        SexpParser.items_return retval = new SexpParser.items_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WSPACE8=null;
        SexpParser.symbol_return symbol7 = null;

        SexpParser.item_return item9 = null;


        CommonTree WSPACE8_tree=null;

        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:23:8: ( symbol ( WSPACE item )* )
            // C:\\Users\\samikc\\grammar\\Sexp.g:23:10: symbol ( WSPACE item )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_symbol_in_items90);
            symbol7=symbol();

            state._fsp--;

            adaptor.addChild(root_0, symbol7.getTree());
            // C:\\Users\\samikc\\grammar\\Sexp.g:23:17: ( WSPACE item )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==WSPACE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:23:18: WSPACE item
            	    {
            	    WSPACE8=(Token)match(input,WSPACE,FOLLOW_WSPACE_in_items93); 
            	    WSPACE8_tree = (CommonTree)adaptor.create(WSPACE8);
            	    adaptor.addChild(root_0, WSPACE8_tree);

            	    pushFollow(FOLLOW_item_in_items95);
            	    item9=item();

            	    state._fsp--;

            	    adaptor.addChild(root_0, item9.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
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
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "items"

    public static class item_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "item"
    // C:\\Users\\samikc\\grammar\\Sexp.g:25:1: item : ( ALPHANUMERIC | list );
    public final SexpParser.item_return item() throws RecognitionException {
        SexpParser.item_return retval = new SexpParser.item_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALPHANUMERIC10=null;
        SexpParser.list_return list11 = null;


        CommonTree ALPHANUMERIC10_tree=null;

        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:25:6: ( ALPHANUMERIC | list )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==ALPHANUMERIC) ) {
                alt3=1;
            }
            else if ( (LA3_0==9) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\samikc\\grammar\\Sexp.g:25:8: ALPHANUMERIC
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    ALPHANUMERIC10=(Token)match(input,ALPHANUMERIC,FOLLOW_ALPHANUMERIC_in_item105); 
                    ALPHANUMERIC10_tree = (CommonTree)adaptor.create(ALPHANUMERIC10);
                    adaptor.addChild(root_0, ALPHANUMERIC10_tree);


                    }
                    break;
                case 2 :
                    // C:\\Users\\samikc\\grammar\\Sexp.g:25:24: list
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_list_in_item110);
                    list11=list();

                    state._fsp--;

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
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "item"

    public static class symbol_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "symbol"
    // C:\\Users\\samikc\\grammar\\Sexp.g:27:1: symbol : ALPHANUMERIC ;
    public final SexpParser.symbol_return symbol() throws RecognitionException {
        SexpParser.symbol_return retval = new SexpParser.symbol_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ALPHANUMERIC12=null;

        CommonTree ALPHANUMERIC12_tree=null;

        try {
            // C:\\Users\\samikc\\grammar\\Sexp.g:27:8: ( ALPHANUMERIC )
            // C:\\Users\\samikc\\grammar\\Sexp.g:27:10: ALPHANUMERIC
            {
            root_0 = (CommonTree)adaptor.nil();

            ALPHANUMERIC12=(Token)match(input,ALPHANUMERIC,FOLLOW_ALPHANUMERIC_in_symbol118); 
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
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "symbol"

    // Delegated rules


 

    public static final BitSet FOLLOW_atom_in_sexp57 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_sexp61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUMERIC_in_atom69 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_list77 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_items_in_list79 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_list81 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_symbol_in_items90 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_WSPACE_in_items93 = new BitSet(new long[]{0x0000000000000280L});
    public static final BitSet FOLLOW_item_in_items95 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ALPHANUMERIC_in_item105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_item110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALPHANUMERIC_in_symbol118 = new BitSet(new long[]{0x0000000000000002L});

}