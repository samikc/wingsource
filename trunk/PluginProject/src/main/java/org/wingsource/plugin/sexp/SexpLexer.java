// $ANTLR 3.0.1 D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g 2010-01-09 15:30:31

package org.wingsource.plugin.sexp;


import org.antlr.runtime.*;

public class SexpLexer extends Lexer {
    public static final int WS=4;
    public static final int ALPHANUMERIC=5;
    public static final int T6=6;
    public static final int T7=7;
    public static final int Tokens=8;
    public static final int EOF=-1;
    public SexpLexer() {;} 
    public SexpLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g"; }

    // $ANTLR start T6
    public final void mT6() throws RecognitionException {
        try {
            int _type = T6;
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:6:4: ( '(' )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:6:6: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T6

    // $ANTLR start T7
    public final void mT7() throws RecognitionException {
        try {
            int _type = T7;
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:7:4: ( ')' )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:7:6: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T7

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:43:10: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:43:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:43:12: ( ' ' | '\\t' | '\\n' | '\\r' )+
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
            	    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:
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
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:44:15: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:44:17: ( 'a' .. 'z' | 'A' .. 'Z' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:44:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:
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

    public void mTokens() throws RecognitionException {
        // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:1:8: ( T6 | T7 | WS | ALPHANUMERIC )
        int alt3=4;
        switch ( input.LA(1) ) {
        case '(':
            {
            alt3=1;
            }
            break;
        case ')':
            {
            alt3=2;
            }
            break;
        case '\t':
        case '\n':
        case '\r':
        case ' ':
            {
            alt3=3;
            }
            break;
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T6 | T7 | WS | ALPHANUMERIC );", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:1:10: T6
                {
                mT6(); 

                }
                break;
            case 2 :
                // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:1:13: T7
                {
                mT7(); 

                }
                break;
            case 3 :
                // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:1:16: WS
                {
                mWS(); 

                }
                break;
            case 4 :
                // D:\\dev\\PluginProject\\src\\org\\wingsource\\plugin\\sexp\\Sexp.g:1:19: ALPHANUMERIC
                {
                mALPHANUMERIC(); 

                }
                break;

        }

    }


 

}