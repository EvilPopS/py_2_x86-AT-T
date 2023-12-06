// Generated from D:/Projects/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, ASSIGN=4, L_PAREN=5, R_PAREN=6, 
		PLUS=7, MINUS=8, MUL=9, DIV=10, EQ=11, GR=12, LS=13, GREQ=14, LSEQ=15, 
		BOOLEAN=16, ID=17, FLOAT=18, INTEGER=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "GR", "LS", "GREQ", "LSEQ", "BOOLEAN", 
			"ID", "FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'('", "')'", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "GR", "LS", "GREQ", "LSEQ", "BOOLEAN", 
			"ID", "FLOAT", "INTEGER"
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
		"\u0004\u0000\u0013\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0004\u0000)\b\u0000\u000b\u0000"+
		"\f\u0000*\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001"+
		"1\b\u0001\n\u0001\f\u00014\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f^\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0005\u0010b\b\u0010\n\u0010\f\u0010e\t\u0010\u0001\u0011"+
		"\u0003\u0011h\b\u0011\u0001\u0011\u0001\u0011\u0005\u0011l\b\u0011\n\u0011"+
		"\f\u0011o\t\u0011\u0003\u0011q\b\u0011\u0001\u0011\u0001\u0011\u0004\u0011"+
		"u\b\u0011\u000b\u0011\f\u0011v\u0001\u0011\u0003\u0011z\b\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011~\b\u0011\n\u0011\f\u0011\u0081\t\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u0085\b\u0011\n\u0011\f\u0011\u0088"+
		"\t\u0011\u0003\u0011\u008a\b\u0011\u0001\u0012\u0003\u0012\u008d\b\u0012"+
		"\u0001\u0012\u0004\u0012\u0090\b\u0012\u000b\u0012\f\u0012\u0091\u0000"+
		"\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000\u0006"+
		"\u0002\u0000\r\r  \u0001\u0000\n\n\u0003\u0000AZ__az\u0004\u000009AZ_"+
		"_az\u0001\u000019\u0001\u000009\u00a0\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001(\u0001\u0000\u0000\u0000"+
		"\u0003.\u0001\u0000\u0000\u0000\u00057\u0001\u0000\u0000\u0000\u00079"+
		"\u0001\u0000\u0000\u0000\t;\u0001\u0000\u0000\u0000\u000b=\u0001\u0000"+
		"\u0000\u0000\r?\u0001\u0000\u0000\u0000\u000fA\u0001\u0000\u0000\u0000"+
		"\u0011C\u0001\u0000\u0000\u0000\u0013E\u0001\u0000\u0000\u0000\u0015G"+
		"\u0001\u0000\u0000\u0000\u0017J\u0001\u0000\u0000\u0000\u0019L\u0001\u0000"+
		"\u0000\u0000\u001bN\u0001\u0000\u0000\u0000\u001dQ\u0001\u0000\u0000\u0000"+
		"\u001f]\u0001\u0000\u0000\u0000!_\u0001\u0000\u0000\u0000#\u0089\u0001"+
		"\u0000\u0000\u0000%\u008c\u0001\u0000\u0000\u0000\')\u0007\u0000\u0000"+
		"\u0000(\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000"+
		"\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0006"+
		"\u0000\u0000\u0000-\u0002\u0001\u0000\u0000\u0000.2\u0005#\u0000\u0000"+
		"/1\b\u0001\u0000\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000023\u0001\u0000\u0000\u000035\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000056\u0006\u0001\u0000\u00006\u0004\u0001"+
		"\u0000\u0000\u000078\u0005\n\u0000\u00008\u0006\u0001\u0000\u0000\u0000"+
		"9:\u0005=\u0000\u0000:\b\u0001\u0000\u0000\u0000;<\u0005(\u0000\u0000"+
		"<\n\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\f\u0001\u0000\u0000"+
		"\u0000?@\u0005+\u0000\u0000@\u000e\u0001\u0000\u0000\u0000AB\u0005-\u0000"+
		"\u0000B\u0010\u0001\u0000\u0000\u0000CD\u0005*\u0000\u0000D\u0012\u0001"+
		"\u0000\u0000\u0000EF\u0005/\u0000\u0000F\u0014\u0001\u0000\u0000\u0000"+
		"GH\u0005=\u0000\u0000HI\u0005=\u0000\u0000I\u0016\u0001\u0000\u0000\u0000"+
		"JK\u0005>\u0000\u0000K\u0018\u0001\u0000\u0000\u0000LM\u0005<\u0000\u0000"+
		"M\u001a\u0001\u0000\u0000\u0000NO\u0005>\u0000\u0000OP\u0005=\u0000\u0000"+
		"P\u001c\u0001\u0000\u0000\u0000QR\u0005<\u0000\u0000RS\u0005=\u0000\u0000"+
		"S\u001e\u0001\u0000\u0000\u0000TU\u0005T\u0000\u0000UV\u0005r\u0000\u0000"+
		"VW\u0005u\u0000\u0000W^\u0005e\u0000\u0000XY\u0005F\u0000\u0000YZ\u0005"+
		"a\u0000\u0000Z[\u0005l\u0000\u0000[\\\u0005s\u0000\u0000\\^\u0005e\u0000"+
		"\u0000]T\u0001\u0000\u0000\u0000]X\u0001\u0000\u0000\u0000^ \u0001\u0000"+
		"\u0000\u0000_c\u0007\u0002\u0000\u0000`b\u0007\u0003\u0000\u0000a`\u0001"+
		"\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000d\"\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000"+
		"\u0000fh\u0005-\u0000\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000hp\u0001\u0000\u0000\u0000im\u0007\u0004\u0000\u0000jl\u0007\u0005"+
		"\u0000\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000"+
		"om\u0001\u0000\u0000\u0000pi\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rt\u0005.\u0000\u0000su\u0007\u0005\u0000"+
		"\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000w\u008a\u0001\u0000\u0000\u0000"+
		"xz\u0005-\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z{\u0001\u0000\u0000\u0000{\u007f\u0007\u0004\u0000\u0000|~\u0007\u0005"+
		"\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0086\u0005.\u0000\u0000\u0083\u0085\u0007\u0005\u0000\u0000\u0084\u0083"+
		"\u0001\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u008a"+
		"\u0001\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089g\u0001"+
		"\u0000\u0000\u0000\u0089y\u0001\u0000\u0000\u0000\u008a$\u0001\u0000\u0000"+
		"\u0000\u008b\u008d\u0005-\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0007\u0005\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092&\u0001\u0000\u0000\u0000\u000f"+
		"\u0000*2]cgmpvy\u007f\u0086\u0089\u008c\u0091\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}