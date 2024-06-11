// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/_migration/grammar/PyAtHome.g4 by ANTLR 4.13.1
package main.java.evilpops.pyathome_2_x86.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PyAtHomeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, DEF=4, RETURN=5, T_INT=6, T_FLOAT=7, 
		T_BOOLEAN=8, T_STRING=9, T_NONE=10, ARROW=11, COMMA=12, COLON=13, ASSIGN=14, 
		L_PAREN=15, R_PAREN=16, PLUS=17, MINUS=18, MUL=19, DIV=20, EQ=21, NEQ=22, 
		GR=23, LS=24, GREQ=25, LSEQ=26, AND=27, OR=28, NONE=29, BOOLEAN=30, ID=31, 
		FLOAT=32, INTEGER=33, STRING=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "DEF", "RETURN", "T_INT", "T_FLOAT", 
			"T_BOOLEAN", "T_STRING", "T_NONE", "ARROW", "COMMA", "COLON", "ASSIGN", 
			"L_PAREN", "R_PAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", "GR", 
			"LS", "GREQ", "LSEQ", "AND", "OR", "NONE", "BOOLEAN", "ID", "FLOAT", 
			"INTEGER", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'def'", "'return'", "'int'", "'float'", "'bool'", 
			"'str'", "'none'", "'->'", "','", "':'", "'='", "'('", "')'", "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'and'", 
			"'or'", "'None'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "DEF", "RETURN", "T_INT", 
			"T_FLOAT", "T_BOOLEAN", "T_STRING", "T_NONE", "ARROW", "COMMA", "COLON", 
			"ASSIGN", "L_PAREN", "R_PAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", 
			"NEQ", "GR", "LS", "GREQ", "LSEQ", "AND", "OR", "NONE", "BOOLEAN", "ID", 
			"FLOAT", "INTEGER", "STRING"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	private final IndentationTracker indentTracker = new IndentationTracker();

	@Override
	public Token nextToken() {
		Token tk = indentTracker.sendDentTokenIfNeeded(this.getLine());
	    if (tk != null) {
	        System.out.println(tk);
	        return tk;
	    }

	    tk = super.nextToken();
	    System.out.println(tk);
	    indentTracker.processToken(tk);
	    return tk;
	}


	public PyAtHomeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PyAtHome.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\"\u011c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0001\u0000\u0004\u0000G\b\u0000\u000b\u0000\f\u0000H\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0005\u0001O\b\u0001\n\u0001\f\u0001R\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002X\b"+
		"\u0002\n\u0002\f\u0002[\t\u0002\u0001\u0002\u0001\u0002\u0004\u0002_\b"+
		"\u0002\u000b\u0002\f\u0002`\u0001\u0002\u0001\u0002\u0005\u0002e\b\u0002"+
		"\n\u0002\f\u0002h\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002"+
		"m\b\u0002\u000b\u0002\f\u0002n\u0001\u0002\u0003\u0002r\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u00d1\b\u001d\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u00d5\b\u001e\n\u001e\f\u001e\u00d8\t\u001e\u0001"+
		"\u001f\u0003\u001f\u00db\b\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u00df"+
		"\b\u001f\n\u001f\f\u001f\u00e2\t\u001f\u0003\u001f\u00e4\b\u001f\u0001"+
		"\u001f\u0001\u001f\u0004\u001f\u00e8\b\u001f\u000b\u001f\f\u001f\u00e9"+
		"\u0001\u001f\u0003\u001f\u00ed\b\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u00f1\b\u001f\n\u001f\f\u001f\u00f4\t\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u00f8\b\u001f\n\u001f\f\u001f\u00fb\t\u001f\u0003\u001f\u00fd\b"+
		"\u001f\u0001 \u0003 \u0100\b \u0001 \u0004 \u0103\b \u000b \f \u0104\u0001"+
		"!\u0001!\u0001!\u0001!\u0005!\u010b\b!\n!\f!\u010e\t!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0005!\u0115\b!\n!\f!\u0118\t!\u0001!\u0003!\u011b\b!"+
		"\u0000\u0000\"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"? A!C\"\u0001\u0000\n\u0003\u0000\t\t\r\r  \u0001\u0000\n\n\u0003\u0000"+
		"\t\n\r\r  \u0002\u0000\t\t  \u0003\u0000AZ__az\u0004\u000009AZ__az\u0001"+
		"\u000019\u0001\u000009\u0003\u0000\n\n\"\"\\\\\u0003\u0000\n\n\'\'\\\\"+
		"\u0135\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000"+
		"\u0000=\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A"+
		"\u0001\u0000\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0001F\u0001\u0000"+
		"\u0000\u0000\u0003L\u0001\u0000\u0000\u0000\u0005q\u0001\u0000\u0000\u0000"+
		"\u0007s\u0001\u0000\u0000\u0000\tw\u0001\u0000\u0000\u0000\u000b~\u0001"+
		"\u0000\u0000\u0000\r\u0082\u0001\u0000\u0000\u0000\u000f\u0088\u0001\u0000"+
		"\u0000\u0000\u0011\u008d\u0001\u0000\u0000\u0000\u0013\u0091\u0001\u0000"+
		"\u0000\u0000\u0015\u0096\u0001\u0000\u0000\u0000\u0017\u0099\u0001\u0000"+
		"\u0000\u0000\u0019\u009b\u0001\u0000\u0000\u0000\u001b\u009d\u0001\u0000"+
		"\u0000\u0000\u001d\u009f\u0001\u0000\u0000\u0000\u001f\u00a1\u0001\u0000"+
		"\u0000\u0000!\u00a3\u0001\u0000\u0000\u0000#\u00a5\u0001\u0000\u0000\u0000"+
		"%\u00a7\u0001\u0000\u0000\u0000\'\u00a9\u0001\u0000\u0000\u0000)\u00ab"+
		"\u0001\u0000\u0000\u0000+\u00ae\u0001\u0000\u0000\u0000-\u00b1\u0001\u0000"+
		"\u0000\u0000/\u00b3\u0001\u0000\u0000\u00001\u00b5\u0001\u0000\u0000\u0000"+
		"3\u00b8\u0001\u0000\u0000\u00005\u00bb\u0001\u0000\u0000\u00007\u00bf"+
		"\u0001\u0000\u0000\u00009\u00c2\u0001\u0000\u0000\u0000;\u00d0\u0001\u0000"+
		"\u0000\u0000=\u00d2\u0001\u0000\u0000\u0000?\u00fc\u0001\u0000\u0000\u0000"+
		"A\u00ff\u0001\u0000\u0000\u0000C\u011a\u0001\u0000\u0000\u0000EG\u0007"+
		"\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000JK\u0006\u0000\u0000\u0000K\u0002\u0001\u0000\u0000\u0000LP\u0005"+
		"#\u0000\u0000MO\b\u0001\u0000\u0000NM\u0001\u0000\u0000\u0000OR\u0001"+
		"\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000\u0000"+
		"QS\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000ST\u0006\u0001\u0000"+
		"\u0000T\u0004\u0001\u0000\u0000\u0000UY\u0005\n\u0000\u0000VX\u0007\u0002"+
		"\u0000\u0000WV\u0001\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000"+
		"[Y\u0001\u0000\u0000\u0000\\^\u0005\n\u0000\u0000]_\u0007\u0003\u0000"+
		"\u0000^]\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000"+
		"\u0000\u0000`a\u0001\u0000\u0000\u0000ar\u0001\u0000\u0000\u0000bf\u0005"+
		"\n\u0000\u0000ce\u0007\u0002\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000ir\u0005\n\u0000\u0000"+
		"jl\u0005\n\u0000\u0000km\u0007\u0003\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000or\u0001\u0000\u0000\u0000pr\u0005\n\u0000\u0000qU\u0001\u0000\u0000"+
		"\u0000qb\u0001\u0000\u0000\u0000qj\u0001\u0000\u0000\u0000qp\u0001\u0000"+
		"\u0000\u0000r\u0006\u0001\u0000\u0000\u0000st\u0005d\u0000\u0000tu\u0005"+
		"e\u0000\u0000uv\u0005f\u0000\u0000v\b\u0001\u0000\u0000\u0000wx\u0005"+
		"r\u0000\u0000xy\u0005e\u0000\u0000yz\u0005t\u0000\u0000z{\u0005u\u0000"+
		"\u0000{|\u0005r\u0000\u0000|}\u0005n\u0000\u0000}\n\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005i\u0000\u0000\u007f\u0080\u0005n\u0000\u0000\u0080"+
		"\u0081\u0005t\u0000\u0000\u0081\f\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005f\u0000\u0000\u0083\u0084\u0005l\u0000\u0000\u0084\u0085\u0005o"+
		"\u0000\u0000\u0085\u0086\u0005a\u0000\u0000\u0086\u0087\u0005t\u0000\u0000"+
		"\u0087\u000e\u0001\u0000\u0000\u0000\u0088\u0089\u0005b\u0000\u0000\u0089"+
		"\u008a\u0005o\u0000\u0000\u008a\u008b\u0005o\u0000\u0000\u008b\u008c\u0005"+
		"l\u0000\u0000\u008c\u0010\u0001\u0000\u0000\u0000\u008d\u008e\u0005s\u0000"+
		"\u0000\u008e\u008f\u0005t\u0000\u0000\u008f\u0090\u0005r\u0000\u0000\u0090"+
		"\u0012\u0001\u0000\u0000\u0000\u0091\u0092\u0005n\u0000\u0000\u0092\u0093"+
		"\u0005o\u0000\u0000\u0093\u0094\u0005n\u0000\u0000\u0094\u0095\u0005e"+
		"\u0000\u0000\u0095\u0014\u0001\u0000\u0000\u0000\u0096\u0097\u0005-\u0000"+
		"\u0000\u0097\u0098\u0005>\u0000\u0000\u0098\u0016\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0005,\u0000\u0000\u009a\u0018\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0005:\u0000\u0000\u009c\u001a\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0005=\u0000\u0000\u009e\u001c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005"+
		"(\u0000\u0000\u00a0\u001e\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005)\u0000"+
		"\u0000\u00a2 \u0001\u0000\u0000\u0000\u00a3\u00a4\u0005+\u0000\u0000\u00a4"+
		"\"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005-\u0000\u0000\u00a6$\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a8\u0005*\u0000\u0000\u00a8&\u0001\u0000\u0000"+
		"\u0000\u00a9\u00aa\u0005/\u0000\u0000\u00aa(\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0005=\u0000\u0000\u00ac\u00ad\u0005=\u0000\u0000\u00ad*\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0005!\u0000\u0000\u00af\u00b0\u0005=\u0000"+
		"\u0000\u00b0,\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005>\u0000\u0000\u00b2"+
		".\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005<\u0000\u0000\u00b40\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b6\u0005>\u0000\u0000\u00b6\u00b7\u0005=\u0000"+
		"\u0000\u00b72\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005<\u0000\u0000\u00b9"+
		"\u00ba\u0005=\u0000\u0000\u00ba4\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005"+
		"a\u0000\u0000\u00bc\u00bd\u0005n\u0000\u0000\u00bd\u00be\u0005d\u0000"+
		"\u0000\u00be6\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005o\u0000\u0000\u00c0"+
		"\u00c1\u0005r\u0000\u0000\u00c18\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"+
		"N\u0000\u0000\u00c3\u00c4\u0005o\u0000\u0000\u00c4\u00c5\u0005n\u0000"+
		"\u0000\u00c5\u00c6\u0005e\u0000\u0000\u00c6:\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005T\u0000\u0000\u00c8\u00c9\u0005r\u0000\u0000\u00c9\u00ca\u0005"+
		"u\u0000\u0000\u00ca\u00d1\u0005e\u0000\u0000\u00cb\u00cc\u0005F\u0000"+
		"\u0000\u00cc\u00cd\u0005a\u0000\u0000\u00cd\u00ce\u0005l\u0000\u0000\u00ce"+
		"\u00cf\u0005s\u0000\u0000\u00cf\u00d1\u0005e\u0000\u0000\u00d0\u00c7\u0001"+
		"\u0000\u0000\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000\u00d1<\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d6\u0007\u0004\u0000\u0000\u00d3\u00d5\u0007\u0005"+
		"\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7>\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d9\u00db\u0005-\u0000\u0000\u00da\u00d9\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00e3\u0001\u0000\u0000\u0000"+
		"\u00dc\u00e0\u0007\u0006\u0000\u0000\u00dd\u00df\u0007\u0007\u0000\u0000"+
		"\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000"+
		"\u00e3\u00dc\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e7\u0005.\u0000\u0000\u00e6"+
		"\u00e8\u0007\u0007\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ea\u00fd\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ed\u0005-\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f2"+
		"\u0007\u0006\u0000\u0000\u00ef\u00f1\u0007\u0007\u0000\u0000\u00f0\u00ef"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000\u00f2\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f5"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f5\u00f9"+
		"\u0005.\u0000\u0000\u00f6\u00f8\u0007\u0007\u0000\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00da\u0001"+
		"\u0000\u0000\u0000\u00fc\u00ec\u0001\u0000\u0000\u0000\u00fd@\u0001\u0000"+
		"\u0000\u0000\u00fe\u0100\u0005-\u0000\u0000\u00ff\u00fe\u0001\u0000\u0000"+
		"\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0102\u0001\u0000\u0000"+
		"\u0000\u0101\u0103\u0007\u0007\u0000\u0000\u0102\u0101\u0001\u0000\u0000"+
		"\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105B\u0001\u0000\u0000\u0000"+
		"\u0106\u010c\u0005\"\u0000\u0000\u0107\u010b\b\b\u0000\u0000\u0108\u0109"+
		"\u0005\\\u0000\u0000\u0109\u010b\t\u0000\u0000\u0000\u010a\u0107\u0001"+
		"\u0000\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010e\u0001"+
		"\u0000\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001"+
		"\u0000\u0000\u0000\u010d\u010f\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010f\u011b\u0005\"\u0000\u0000\u0110\u0116\u0005\'"+
		"\u0000\u0000\u0111\u0115\b\t\u0000\u0000\u0112\u0113\u0005\\\u0000\u0000"+
		"\u0113\u0115\t\u0000\u0000\u0000\u0114\u0111\u0001\u0000\u0000\u0000\u0114"+
		"\u0112\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000\u0116"+
		"\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000\u0117"+
		"\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000\u0119"+
		"\u011b\u0005\'\u0000\u0000\u011a\u0106\u0001\u0000\u0000\u0000\u011a\u0110"+
		"\u0001\u0000\u0000\u0000\u011bD\u0001\u0000\u0000\u0000\u0019\u0000HP"+
		"Y`fnq\u00d0\u00d6\u00da\u00e0\u00e3\u00e9\u00ec\u00f2\u00f9\u00fc\u00ff"+
		"\u0104\u010a\u010c\u0114\u0116\u011a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}