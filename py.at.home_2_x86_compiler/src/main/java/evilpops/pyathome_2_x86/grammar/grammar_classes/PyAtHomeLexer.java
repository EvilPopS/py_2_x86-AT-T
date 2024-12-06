// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.2
package main.java.evilpops.pyathome_2_x86.grammar.grammar_classes;
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
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, DEF=4, RETURN=5, PASS=6, CONTINUE=7, 
		BREAK=8, INBUILT_PRINT_FUNC=9, WHILE=10, IF=11, ELIF=12, ELSE=13, T_INT=14, 
		T_FLOAT=15, T_BOOLEAN=16, T_STRING=17, T_NONE=18, ARROW=19, COMMA=20, 
		COLON=21, ASSIGN=22, L_PAREN=23, R_PAREN=24, PLUS=25, MINUS=26, MUL=27, 
		DIV=28, EQ=29, NEQ=30, GR=31, LS=32, GREQ=33, LSEQ=34, AND=35, OR=36, 
		NONE=37, BOOLEAN=38, ID=39, FLOAT=40, INTEGER=41, STRING=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "DEF", "RETURN", "PASS", "CONTINUE", 
			"BREAK", "INBUILT_PRINT_FUNC", "WHILE", "IF", "ELIF", "ELSE", "T_INT", 
			"T_FLOAT", "T_BOOLEAN", "T_STRING", "T_NONE", "ARROW", "COMMA", "COLON", 
			"ASSIGN", "L_PAREN", "R_PAREN", "PLUS", "MINUS", "MUL", "DIV", "EQ", 
			"NEQ", "GR", "LS", "GREQ", "LSEQ", "AND", "OR", "NONE", "BOOLEAN", "ID", 
			"FLOAT", "INTEGER", "STRING"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'def'", "'return'", "'pass'", "'continue'", 
			"'break'", "'print'", "'while'", "'if'", "'elif'", "'else'", "'int'", 
			"'float'", "'bool'", "'str'", "'none'", "'->'", "','", "':'", "'='", 
			"'('", "')'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'>'", "'<'", 
			"'>='", "'<='", "'and'", "'or'", "'None'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "DEF", "RETURN", "PASS", 
			"CONTINUE", "BREAK", "INBUILT_PRINT_FUNC", "WHILE", "IF", "ELIF", "ELSE", 
			"T_INT", "T_FLOAT", "T_BOOLEAN", "T_STRING", "T_NONE", "ARROW", "COMMA", 
			"COLON", "ASSIGN", "L_PAREN", "R_PAREN", "PLUS", "MINUS", "MUL", "DIV", 
			"EQ", "NEQ", "GR", "LS", "GREQ", "LSEQ", "AND", "OR", "NONE", "BOOLEAN", 
			"ID", "FLOAT", "INTEGER", "STRING"
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
	    if (tk != null)
	        return tk;

	    tk = super.nextToken();
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
		"\u0004\u0000*\u015c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
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
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0001\u0000\u0004\u0000"+
		"W\b\u0000\u000b\u0000\f\u0000X\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0005\u0001_\b\u0001\n\u0001\f\u0001b\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0005\u0002h\b\u0002\n\u0002\f\u0002k\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0004\u0002o\b\u0002\u000b\u0002\f\u0002"+
		"p\u0001\u0002\u0001\u0002\u0005\u0002u\b\u0002\n\u0002\f\u0002x\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0004\u0002}\b\u0002\u000b\u0002"+
		"\f\u0002~\u0001\u0002\u0003\u0002\u0082\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001"+
		"#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u010e\b%\u0001&\u0001&\u0005"+
		"&\u0112\b&\n&\f&\u0115\t&\u0001\'\u0001\'\u0005\'\u0119\b\'\n\'\f\'\u011c"+
		"\t\'\u0003\'\u011e\b\'\u0001\'\u0001\'\u0004\'\u0122\b\'\u000b\'\f\'\u0123"+
		"\u0001\'\u0001\'\u0005\'\u0128\b\'\n\'\f\'\u012b\t\'\u0001\'\u0001\'\u0005"+
		"\'\u012f\b\'\n\'\f\'\u0132\t\'\u0001\'\u0001\'\u0001\'\u0005\'\u0137\b"+
		"\'\n\'\f\'\u013a\t\'\u0003\'\u013c\b\'\u0001(\u0001(\u0004(\u0140\b(\u000b"+
		"(\f(\u0141\u0001(\u0003(\u0145\b(\u0001)\u0001)\u0001)\u0001)\u0005)\u014b"+
		"\b)\n)\f)\u014e\t)\u0001)\u0001)\u0001)\u0001)\u0001)\u0005)\u0155\b)"+
		"\n)\f)\u0158\t)\u0001)\u0003)\u015b\b)\u0000\u0000*\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$I%K&M\'O(Q)S*\u0001\u0000"+
		"\n\u0003\u0000\t\t\r\r  \u0001\u0000\n\n\u0003\u0000\t\n\r\r  \u0002\u0000"+
		"\t\t  \u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u0000"+
		"09\u0003\u0000\n\n\"\"\\\\\u0003\u0000\n\n\'\'\\\\\u0175\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C"+
		"\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000"+
		"\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000"+
		"\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q"+
		"\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000\u0001V\u0001\u0000"+
		"\u0000\u0000\u0003\\\u0001\u0000\u0000\u0000\u0005\u0081\u0001\u0000\u0000"+
		"\u0000\u0007\u0083\u0001\u0000\u0000\u0000\t\u0087\u0001\u0000\u0000\u0000"+
		"\u000b\u008e\u0001\u0000\u0000\u0000\r\u0093\u0001\u0000\u0000\u0000\u000f"+
		"\u009c\u0001\u0000\u0000\u0000\u0011\u00a2\u0001\u0000\u0000\u0000\u0013"+
		"\u00a8\u0001\u0000\u0000\u0000\u0015\u00ae\u0001\u0000\u0000\u0000\u0017"+
		"\u00b1\u0001\u0000\u0000\u0000\u0019\u00b6\u0001\u0000\u0000\u0000\u001b"+
		"\u00bb\u0001\u0000\u0000\u0000\u001d\u00bf\u0001\u0000\u0000\u0000\u001f"+
		"\u00c5\u0001\u0000\u0000\u0000!\u00ca\u0001\u0000\u0000\u0000#\u00ce\u0001"+
		"\u0000\u0000\u0000%\u00d3\u0001\u0000\u0000\u0000\'\u00d6\u0001\u0000"+
		"\u0000\u0000)\u00d8\u0001\u0000\u0000\u0000+\u00da\u0001\u0000\u0000\u0000"+
		"-\u00dc\u0001\u0000\u0000\u0000/\u00de\u0001\u0000\u0000\u00001\u00e0"+
		"\u0001\u0000\u0000\u00003\u00e2\u0001\u0000\u0000\u00005\u00e4\u0001\u0000"+
		"\u0000\u00007\u00e6\u0001\u0000\u0000\u00009\u00e8\u0001\u0000\u0000\u0000"+
		";\u00eb\u0001\u0000\u0000\u0000=\u00ee\u0001\u0000\u0000\u0000?\u00f0"+
		"\u0001\u0000\u0000\u0000A\u00f2\u0001\u0000\u0000\u0000C\u00f5\u0001\u0000"+
		"\u0000\u0000E\u00f8\u0001\u0000\u0000\u0000G\u00fc\u0001\u0000\u0000\u0000"+
		"I\u00ff\u0001\u0000\u0000\u0000K\u010d\u0001\u0000\u0000\u0000M\u010f"+
		"\u0001\u0000\u0000\u0000O\u013b\u0001\u0000\u0000\u0000Q\u0144\u0001\u0000"+
		"\u0000\u0000S\u015a\u0001\u0000\u0000\u0000UW\u0007\u0000\u0000\u0000"+
		"VU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0006\u0000"+
		"\u0000\u0000[\u0002\u0001\u0000\u0000\u0000\\`\u0005#\u0000\u0000]_\b"+
		"\u0001\u0000\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000cd\u0006\u0001\u0000\u0000d\u0004\u0001"+
		"\u0000\u0000\u0000ei\u0005\n\u0000\u0000fh\u0007\u0002\u0000\u0000gf\u0001"+
		"\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000"+
		"\u0000ln\u0005\n\u0000\u0000mo\u0007\u0003\u0000\u0000nm\u0001\u0000\u0000"+
		"\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000q\u0082\u0001\u0000\u0000\u0000rv\u0005\n\u0000\u0000su\u0007"+
		"\u0002\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000"+
		"vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000"+
		"\u0000xv\u0001\u0000\u0000\u0000y\u0082\u0005\n\u0000\u0000z|\u0005\n"+
		"\u0000\u0000{}\u0007\u0003\u0000\u0000|{\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u0082\u0001\u0000\u0000\u0000\u0080\u0082\u0005\n\u0000\u0000"+
		"\u0081e\u0001\u0000\u0000\u0000\u0081r\u0001\u0000\u0000\u0000\u0081z"+
		"\u0001\u0000\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0006"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0005d\u0000\u0000\u0084\u0085\u0005"+
		"e\u0000\u0000\u0085\u0086\u0005f\u0000\u0000\u0086\b\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0005r\u0000\u0000\u0088\u0089\u0005e\u0000\u0000\u0089"+
		"\u008a\u0005t\u0000\u0000\u008a\u008b\u0005u\u0000\u0000\u008b\u008c\u0005"+
		"r\u0000\u0000\u008c\u008d\u0005n\u0000\u0000\u008d\n\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0005p\u0000\u0000\u008f\u0090\u0005a\u0000\u0000\u0090"+
		"\u0091\u0005s\u0000\u0000\u0091\u0092\u0005s\u0000\u0000\u0092\f\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005c\u0000\u0000\u0094\u0095\u0005o\u0000"+
		"\u0000\u0095\u0096\u0005n\u0000\u0000\u0096\u0097\u0005t\u0000\u0000\u0097"+
		"\u0098\u0005i\u0000\u0000\u0098\u0099\u0005n\u0000\u0000\u0099\u009a\u0005"+
		"u\u0000\u0000\u009a\u009b\u0005e\u0000\u0000\u009b\u000e\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0005b\u0000\u0000\u009d\u009e\u0005r\u0000\u0000\u009e"+
		"\u009f\u0005e\u0000\u0000\u009f\u00a0\u0005a\u0000\u0000\u00a0\u00a1\u0005"+
		"k\u0000\u0000\u00a1\u0010\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005p\u0000"+
		"\u0000\u00a3\u00a4\u0005r\u0000\u0000\u00a4\u00a5\u0005i\u0000\u0000\u00a5"+
		"\u00a6\u0005n\u0000\u0000\u00a6\u00a7\u0005t\u0000\u0000\u00a7\u0012\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0005w\u0000\u0000\u00a9\u00aa\u0005h\u0000"+
		"\u0000\u00aa\u00ab\u0005i\u0000\u0000\u00ab\u00ac\u0005l\u0000\u0000\u00ac"+
		"\u00ad\u0005e\u0000\u0000\u00ad\u0014\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0005i\u0000\u0000\u00af\u00b0\u0005f\u0000\u0000\u00b0\u0016\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0005e\u0000\u0000\u00b2\u00b3\u0005l\u0000\u0000"+
		"\u00b3\u00b4\u0005i\u0000\u0000\u00b4\u00b5\u0005f\u0000\u0000\u00b5\u0018"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005e\u0000\u0000\u00b7\u00b8\u0005"+
		"l\u0000\u0000\u00b8\u00b9\u0005s\u0000\u0000\u00b9\u00ba\u0005e\u0000"+
		"\u0000\u00ba\u001a\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005i\u0000\u0000"+
		"\u00bc\u00bd\u0005n\u0000\u0000\u00bd\u00be\u0005t\u0000\u0000\u00be\u001c"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005f\u0000\u0000\u00c0\u00c1\u0005"+
		"l\u0000\u0000\u00c1\u00c2\u0005o\u0000\u0000\u00c2\u00c3\u0005a\u0000"+
		"\u0000\u00c3\u00c4\u0005t\u0000\u0000\u00c4\u001e\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0005b\u0000\u0000\u00c6\u00c7\u0005o\u0000\u0000\u00c7\u00c8"+
		"\u0005o\u0000\u0000\u00c8\u00c9\u0005l\u0000\u0000\u00c9 \u0001\u0000"+
		"\u0000\u0000\u00ca\u00cb\u0005s\u0000\u0000\u00cb\u00cc\u0005t\u0000\u0000"+
		"\u00cc\u00cd\u0005r\u0000\u0000\u00cd\"\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0005n\u0000\u0000\u00cf\u00d0\u0005o\u0000\u0000\u00d0\u00d1\u0005"+
		"n\u0000\u0000\u00d1\u00d2\u0005e\u0000\u0000\u00d2$\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0005-\u0000\u0000\u00d4\u00d5\u0005>\u0000\u0000\u00d5"+
		"&\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005,\u0000\u0000\u00d7(\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005:\u0000\u0000\u00d9*\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0005=\u0000\u0000\u00db,\u0001\u0000\u0000\u0000\u00dc"+
		"\u00dd\u0005(\u0000\u0000\u00dd.\u0001\u0000\u0000\u0000\u00de\u00df\u0005"+
		")\u0000\u0000\u00df0\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005+\u0000"+
		"\u0000\u00e12\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005-\u0000\u0000\u00e3"+
		"4\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005*\u0000\u0000\u00e56\u0001"+
		"\u0000\u0000\u0000\u00e6\u00e7\u0005/\u0000\u0000\u00e78\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0005=\u0000\u0000\u00e9\u00ea\u0005=\u0000\u0000\u00ea"+
		":\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005!\u0000\u0000\u00ec\u00ed\u0005"+
		"=\u0000\u0000\u00ed<\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005>\u0000"+
		"\u0000\u00ef>\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005<\u0000\u0000\u00f1"+
		"@\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005>\u0000\u0000\u00f3\u00f4\u0005"+
		"=\u0000\u0000\u00f4B\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005<\u0000"+
		"\u0000\u00f6\u00f7\u0005=\u0000\u0000\u00f7D\u0001\u0000\u0000\u0000\u00f8"+
		"\u00f9\u0005a\u0000\u0000\u00f9\u00fa\u0005n\u0000\u0000\u00fa\u00fb\u0005"+
		"d\u0000\u0000\u00fbF\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005o\u0000"+
		"\u0000\u00fd\u00fe\u0005r\u0000\u0000\u00feH\u0001\u0000\u0000\u0000\u00ff"+
		"\u0100\u0005N\u0000\u0000\u0100\u0101\u0005o\u0000\u0000\u0101\u0102\u0005"+
		"n\u0000\u0000\u0102\u0103\u0005e\u0000\u0000\u0103J\u0001\u0000\u0000"+
		"\u0000\u0104\u0105\u0005T\u0000\u0000\u0105\u0106\u0005r\u0000\u0000\u0106"+
		"\u0107\u0005u\u0000\u0000\u0107\u010e\u0005e\u0000\u0000\u0108\u0109\u0005"+
		"F\u0000\u0000\u0109\u010a\u0005a\u0000\u0000\u010a\u010b\u0005l\u0000"+
		"\u0000\u010b\u010c\u0005s\u0000\u0000\u010c\u010e\u0005e\u0000\u0000\u010d"+
		"\u0104\u0001\u0000\u0000\u0000\u010d\u0108\u0001\u0000\u0000\u0000\u010e"+
		"L\u0001\u0000\u0000\u0000\u010f\u0113\u0007\u0004\u0000\u0000\u0110\u0112"+
		"\u0007\u0005\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u0115"+
		"\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0001\u0000\u0000\u0000\u0114N\u0001\u0000\u0000\u0000\u0115\u0113\u0001"+
		"\u0000\u0000\u0000\u0116\u011a\u0007\u0006\u0000\u0000\u0117\u0119\u0007"+
		"\u0007\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119\u011c\u0001"+
		"\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u011e\u0001\u0000\u0000\u0000\u011c\u011a\u0001"+
		"\u0000\u0000\u0000\u011d\u0116\u0001\u0000\u0000\u0000\u011d\u011e\u0001"+
		"\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0121\u0005"+
		".\u0000\u0000\u0120\u0122\u0007\u0007\u0000\u0000\u0121\u0120\u0001\u0000"+
		"\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000"+
		"\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u013c\u0001\u0000"+
		"\u0000\u0000\u0125\u0129\u0007\u0006\u0000\u0000\u0126\u0128\u0007\u0007"+
		"\u0000\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u0128\u012b\u0001\u0000"+
		"\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000"+
		"\u0000\u0000\u012a\u012c\u0001\u0000\u0000\u0000\u012b\u0129\u0001\u0000"+
		"\u0000\u0000\u012c\u0130\u0005.\u0000\u0000\u012d\u012f\u0007\u0007\u0000"+
		"\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012f\u0132\u0001\u0000\u0000"+
		"\u0000\u0130\u012e\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000"+
		"\u0000\u0131\u013c\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0007\u0007\u0000\u0000\u0134\u0138\u0005.\u0000\u0000"+
		"\u0135\u0137\u0007\u0007\u0000\u0000\u0136\u0135\u0001\u0000\u0000\u0000"+
		"\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000"+
		"\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000\u0000\u0000"+
		"\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u011d\u0001\u0000\u0000\u0000"+
		"\u013b\u0125\u0001\u0000\u0000\u0000\u013b\u0133\u0001\u0000\u0000\u0000"+
		"\u013cP\u0001\u0000\u0000\u0000\u013d\u013f\u0007\u0006\u0000\u0000\u013e"+
		"\u0140\u0007\u0007\u0000\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0001\u0000\u0000\u0000\u0141\u013f\u0001\u0000\u0000\u0000\u0141"+
		"\u0142\u0001\u0000\u0000\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143"+
		"\u0145\u0007\u0007\u0000\u0000\u0144\u013d\u0001\u0000\u0000\u0000\u0144"+
		"\u0143\u0001\u0000\u0000\u0000\u0145R\u0001\u0000\u0000\u0000\u0146\u014c"+
		"\u0005\"\u0000\u0000\u0147\u014b\b\b\u0000\u0000\u0148\u0149\u0005\\\u0000"+
		"\u0000\u0149\u014b\t\u0000\u0000\u0000\u014a\u0147\u0001\u0000\u0000\u0000"+
		"\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u014e\u0001\u0000\u0000\u0000"+
		"\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000"+
		"\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000"+
		"\u014f\u015b\u0005\"\u0000\u0000\u0150\u0156\u0005\'\u0000\u0000\u0151"+
		"\u0155\b\t\u0000\u0000\u0152\u0153\u0005\\\u0000\u0000\u0153\u0155\t\u0000"+
		"\u0000\u0000\u0154\u0151\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000"+
		"\u0000\u0000\u0155\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000"+
		"\u0000\u0000\u0156\u0157\u0001\u0000\u0000\u0000\u0157\u0159\u0001\u0000"+
		"\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u015b\u0005\'\u0000"+
		"\u0000\u015a\u0146\u0001\u0000\u0000\u0000\u015a\u0150\u0001\u0000\u0000"+
		"\u0000\u015bT\u0001\u0000\u0000\u0000\u0018\u0000X`ipv~\u0081\u010d\u0113"+
		"\u011a\u011d\u0123\u0129\u0130\u0138\u013b\u0141\u0144\u014a\u014c\u0154"+
		"\u0156\u015a\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}