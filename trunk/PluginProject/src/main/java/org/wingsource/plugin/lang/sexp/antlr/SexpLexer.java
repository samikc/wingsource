// $ANTLR 3.0.1 D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g 2010-01-20 22:50:35

package org.wingsource.plugin.lang.sexp.antlr;


import org.antlr.runtime.*;

public class SexpLexer extends Lexer {
    public static final int SPECIAL_CHARACTERS=9;
    public static final int WS=7;
    public static final int ESC=13;
    public static final int OPERATOR=5;
    public static final int ALPHANUMERIC=8;
    public static final int OPERAND=6;
    public static final int FLOAT=11;
    public static final int INT=12;
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
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:16: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:18: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:51:37: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
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
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:54:10: ( '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"' )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:54:12: '\"' ( ESC | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); 
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:54:16: ( ESC | ~ ( '\\\\' | '\"' ) )*
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
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:54:17: ESC
            	    {
            	    mESC(); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:54:23: ~ ( '\\\\' | '\"' )
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
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:55:16: ( '\\\\' ( 't' | '\"' | '0' .. '9' )* )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:55:18: '\\\\' ( 't' | '\"' | '0' .. '9' )*
            {
            match('\\'); 
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:55:23: ( 't' | '\"' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\"'||(LA4_0>='0' && LA4_0<='9')||LA4_0=='t') ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
            	    {
            	    if ( input.LA(1)=='\"'||(input.LA(1)>='0' && input.LA(1)<='9')||input.LA(1)=='t' ) {
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

    // $ANTLR start INT
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:7: ( ( '-' | '+' )? ( '0' .. '9' )+ )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:9: ( '-' | '+' )? ( '0' .. '9' )+
            {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:9: ( '-' | '+' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='+'||LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:22: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:57:23: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INT

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:9: ( ( '-' | '+' )? ( '0' .. '9' )* '.' ( '0' .. '9' )+ )
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:11: ( '-' | '+' )? ( '0' .. '9' )* '.' ( '0' .. '9' )+
            {
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:11: ( '-' | '+' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='+'||LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse =
                            new MismatchedSetException(null,input);
                        recover(mse);    throw mse;
                    }


                    }
                    break;

            }

            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:24: ( '0' .. '9' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:25: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match('.'); 
            // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:40: ( '0' .. '9' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:58:41: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    public void mTokens() throws RecognitionException {
        // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:8: ( T14 | T15 | WS | ALPHANUMERIC | SPECIAL_CHARACTERS | STRING | ESC | INT | FLOAT )
        int alt10=9;
        alt10 = dfa10.predict(input);
        switch (alt10) {
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
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:64: INT
                {
                mINT(); 

                }
                break;
            case 9 :
                // D:\\dev\\PluginProject\\src\\main\\java\\org\\wingsource\\plugin\\sexp\\antlr\\Sexp.g:1:68: FLOAT
                {
                mFLOAT(); 

                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\5\uffff\1\10\3\uffff\1\13\2\uffff";
    static final String DFA10_eofS =
        "\14\uffff";
    static final String DFA10_minS =
        "\1\11\4\uffff\1\56\3\uffff\1\56\2\uffff";
    static final String DFA10_maxS =
        "\1\172\4\uffff\1\71\3\uffff\1\71\2\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\uffff\1\6\1\7\1\5\1\uffff\1\11\1\10";
    static final String DFA10_specialS =
        "\14\uffff}>";
    static final String[] DFA10_transitionS = {
            "\2\3\2\uffff\1\3\22\uffff\1\3\1\10\1\6\4\10\1\uffff\1\1\1\2"+
            "\1\10\1\5\1\uffff\1\5\1\12\1\10\12\11\3\uffff\1\10\2\uffff\1"+
            "\10\32\4\1\uffff\1\7\1\uffff\1\10\2\uffff\32\4",
            "",
            "",
            "",
            "",
            "\1\12\1\uffff\12\11",
            "",
            "",
            "",
            "\1\12\1\uffff\12\11",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T14 | T15 | WS | ALPHANUMERIC | SPECIAL_CHARACTERS | STRING | ESC | INT | FLOAT );";
        }
    }
 

}