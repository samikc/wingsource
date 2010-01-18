// $ANTLR 3.0.1 D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g 2010-01-18 21:39:49

package org.wingsource.plugin.sexp.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SexpLexer extends Lexer {
    public static final int SPECIAL_CHARACTERS=9;
    public static final int WS=7;
    public static final int ESC=12;
    public static final int OPERATOR=5;
    public static final int ALPHANUMERIC=8;
    public static final int OPERAND=6;
    public static final int FLOAT=11;
    public static final int INT=13;
    public static final int T14=14;
    public static final int T15=15;
    public static final int OPERATION=4;
    public static final int Tokens=16;
    public static final int EOF=-1;
    public static final int STRING=10;
    public SexpLexer() {;} 
    public SexpLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g"; }

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:6:5: ( '(' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:6:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:7:5: ( ')' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:7:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:50:10: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:50:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:50:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


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

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start ALPHANUMERIC
    public final void mALPHANUMERIC() throws RecognitionException {
        try {
            int _type = ALPHANUMERIC;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:16: ( ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:18: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:18: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ALPHANUMERIC

    // $ANTLR start SPECIAL_CHARACTERS
    public final void mSPECIAL_CHARACTERS() throws RecognitionException {
        try {
            int _type = SPECIAL_CHARACTERS;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:52:20: ( '^' | '&' | '*' | '-' | '+' | '=' | '/' | '!' | '@' | '#' | '$' | '%' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            {
            if ( input.LA(1)=='!'||(input.LA(1)>='#' && input.LA(1)<='&')||(input.LA(1)>='*' && input.LA(1)<='+')||input.LA(1)=='-'||input.LA(1)=='/'||input.LA(1)=='='||input.LA(1)=='@'||input.LA(1)=='^' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SPECIAL_CHARACTERS

    // $ANTLR start STRING
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:10: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:12: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:16: ( ESC | ~ ( '\\\\' | '\"' ) )*
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\\') ) {
                    alt3=1;
                }
                else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFE')) ) {
                    alt3=2;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:17: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:23: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\"'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STRING

    // $ANTLR start ESC
    public final void mESC() throws RecognitionException {
        try {
            int _type = ESC;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:16: ( '\\\\' ( 't' | '\"' | INT )* )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:18: '\\\\' ( 't' | '\"' | INT )*
            {
            match('\\'); 
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:23: ( 't' | '\"' | INT )*
            loop4:
            do {
                int alt4=4;
                switch ( input.LA(1) ) {
                case 't':
                    {
                    alt4=1;
                    }
                    break;
                case '\"':
                    {
                    alt4=2;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt4=3;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:24: 't'
            	    {
            	    match('t'); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:30: '\"'
            	    {
            	    match('\"'); 

            	    }
            	    break;
            	case 3 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:36: INT
            	    {
            	    mINT(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end ESC

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:61:6: ( INT '.' INT )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:61:8: INT '.' INT
            {
            mINT(); 
            match('.'); 
            mINT(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:62:11: ( ( '0' .. '9' )+ )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:62:13: ( '0' .. '9' )+
            {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:62:13: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:62:14: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    public void mTokens() throws RecognitionException {
        // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:8: ( T14 | T15 | WS | ALPHANUMERIC | SPECIAL_CHARACTERS | STRING | ESC | FLOAT | INT )
        int alt6=9;
        alt6 = dfa6.predict(input);
        switch (alt6) {
            case 1 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:10: T14
                {
                mT14(); 

                }
                break;
            case 2 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:14: T15
                {
                mT15(); 

                }
                break;
            case 3 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:18: WS
                {
                mWS(); 

                }
                break;
            case 4 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:21: ALPHANUMERIC
                {
                mALPHANUMERIC(); 

                }
                break;
            case 5 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:34: SPECIAL_CHARACTERS
                {
                mSPECIAL_CHARACTERS(); 

                }
                break;
            case 6 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:53: STRING
                {
                mSTRING(); 

                }
                break;
            case 7 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:60: ESC
                {
                mESC(); 

                }
                break;
            case 8 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:64: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 9 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:70: INT
                {
                mINT(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\1\5\3\uffff\1\5\5\uffff";
    static final String DFA6_eofS =
        "\12\uffff";
    static final String DFA6_minS =
        "\1\11\3\uffff\1\56\5\uffff";
    static final String DFA6_maxS =
        "\1\136\3\uffff\1\71\5\uffff";
    static final String DFA6_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\4\1\5\1\6\1\7\1\10";
    static final String DFA6_specialS =
        "\12\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\3\2\uffff\1\3\22\uffff\1\3\1\6\1\7\4\6\1\uffff\1\1\1\2\2"+
            "\6\1\uffff\1\6\1\uffff\1\6\12\4\3\uffff\1\6\2\uffff\1\6\33\uffff"+
            "\1\10\1\uffff\1\6",
            "",
            "",
            "",
            "\1\11\1\uffff\12\4",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T14 | T15 | WS | ALPHANUMERIC | SPECIAL_CHARACTERS | STRING | ESC | FLOAT | INT );";
        }
    }
 

}