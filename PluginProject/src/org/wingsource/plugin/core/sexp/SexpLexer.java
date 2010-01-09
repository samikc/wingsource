package org.wingsource.plugin.core.sexp;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 \\samikc\\grammar\\Sexp.g 2010-01-09 12:07:39

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SexpLexer extends Lexer {
    public static final int ALPHANUMERIC=7;
    public static final int T__10=10;
    public static final int ITEMS=6;
    public static final int WSPACE=8;
    public static final int ATOM=5;
    public static final int LIST=4;
    public static final int EOF=-1;
    public static final int T__9=9;

    // delegates
    // delegators

    public SexpLexer() {;} 
    public SexpLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SexpLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\samikc\\grammar\\Sexp.g"; }

    // $ANTLR start "LIST"
    public final void mLIST() throws RecognitionException {
        try {
            int _type = LIST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:3:6: ( 'LIST' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:3:8: 'LIST'
            {
            match("LIST"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIST"

    // $ANTLR start "ATOM"
    public final void mATOM() throws RecognitionException {
        try {
            int _type = ATOM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:4:6: ( 'ATOM' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:4:8: 'ATOM'
            {
            match("ATOM"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ATOM"

    // $ANTLR start "ITEMS"
    public final void mITEMS() throws RecognitionException {
        try {
            int _type = ITEMS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:5:7: ( 'ITEMS' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:5:9: 'ITEMS'
            {
            match("ITEMS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ITEMS"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:6:6: ( '(' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:6:8: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:7:7: ( ')' )
            // C:\\Users\\samikc\\grammar\\Sexp.g:7:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "WSPACE"
    public final void mWSPACE() throws RecognitionException {
        try {
            int _type = WSPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:29:8: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\u0000C' )+ )
            // C:\\Users\\samikc\\grammar\\Sexp.g:29:10: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u0000C' )+
            {
            // C:\\Users\\samikc\\grammar\\Sexp.g:29:10: ( ' ' | '\\t' | '\\n' | '\\r' | '\\u0000C' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=6;
                switch ( input.LA(1) ) {
                case ' ':
                    {
                    alt1=1;
                    }
                    break;
                case '\t':
                    {
                    alt1=2;
                    }
                    break;
                case '\n':
                    {
                    alt1=3;
                    }
                    break;
                case '\r':
                    {
                    alt1=4;
                    }
                    break;
                case '\u0000':
                    {
                    alt1=5;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:29:11: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:29:17: '\\t'
            	    {
            	    match('\t'); 

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:29:24: '\\n'
            	    {
            	    match('\n'); 

            	    }
            	    break;
            	case 4 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:29:31: '\\r'
            	    {
            	    match('\r'); 

            	    }
            	    break;
            	case 5 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:29:38: '\\u0000C'
            	    {
            	    match("\u0000C"); 


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WSPACE"

    // $ANTLR start "ALPHANUMERIC"
    public final void mALPHANUMERIC() throws RecognitionException {
        try {
            int _type = ALPHANUMERIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\samikc\\grammar\\Sexp.g:32:2: ( ( ( 'a' .. 'z' | 'A' .. 'Z' ) )* ( '0' .. '9' )* )
            // C:\\Users\\samikc\\grammar\\Sexp.g:32:4: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )* ( '0' .. '9' )*
            {
            // C:\\Users\\samikc\\grammar\\Sexp.g:32:4: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:32:5: ( 'a' .. 'z' | 'A' .. 'Z' )
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // C:\\Users\\samikc\\grammar\\Sexp.g:32:27: ( '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\samikc\\grammar\\Sexp.g:32:28: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALPHANUMERIC"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\samikc\\grammar\\Sexp.g:1:8: ( LIST | ATOM | ITEMS | T__9 | T__10 | WSPACE | ALPHANUMERIC )
        int alt4=7;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:10: LIST
                {
                mLIST(); 

                }
                break;
            case 2 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:15: ATOM
                {
                mATOM(); 

                }
                break;
            case 3 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:20: ITEMS
                {
                mITEMS(); 

                }
                break;
            case 4 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:26: T__9
                {
                mT__9(); 

                }
                break;
            case 5 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:31: T__10
                {
                mT__10(); 

                }
                break;
            case 6 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:37: WSPACE
                {
                mWSPACE(); 

                }
                break;
            case 7 :
                // C:\\Users\\samikc\\grammar\\Sexp.g:1:44: ALPHANUMERIC
                {
                mALPHANUMERIC(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\4\7\4\uffff\6\7\1\21\1\22\1\7\2\uffff\1\24\1\uffff";
    static final String DFA4_eofS =
        "\25\uffff";
    static final String DFA4_minS =
        "\1\0\1\111\2\124\4\uffff\1\123\1\117\1\105\1\124\2\115\2\60\1\123"+
        "\2\uffff\1\60\1\uffff";
    static final String DFA4_maxS =
        "\1\114\1\111\2\124\4\uffff\1\123\1\117\1\105\1\124\2\115\2\172"+
        "\1\123\2\uffff\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\7\11\uffff\1\1\1\2\1\uffff\1\3";
    static final String DFA4_specialS =
        "\25\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\6\10\uffff\2\6\2\uffff\1\6\22\uffff\1\6\7\uffff\1\4\1\5"+
            "\27\uffff\1\2\7\uffff\1\3\2\uffff\1\1",
            "\1\10",
            "\1\11",
            "\1\12",
            "",
            "",
            "",
            "",
            "\1\13",
            "\1\14",
            "\1\15",
            "\1\16",
            "\1\17",
            "\1\20",
            "\12\7\7\uffff\32\7\6\uffff\32\7",
            "\12\7\7\uffff\32\7\6\uffff\32\7",
            "\1\23",
            "",
            "",
            "\12\7\7\uffff\32\7\6\uffff\32\7",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( LIST | ATOM | ITEMS | T__9 | T__10 | WSPACE | ALPHANUMERIC );";
        }
    }
 

}