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
		PLUS=7, MINUS=8, MUL=9, DIV=10, EQ=11, NEQ=12, GR=13, LS=14, GREQ=15, 
		LSEQ=16, AND=17, OR=18, BOOLEAN=19, ID=20, FLOAT=21, INTEGER=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", "GR", "LS", "GREQ", "LSEQ", 
			"AND", "OR", "BOOLEAN", "ID", "FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'('", "')'", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", "'and'", "'or'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", "GR", "LS", "GREQ", "LSEQ", 
			"AND", "OR", "BOOLEAN", "ID", "FLOAT", "INTEGER"
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
		"\u0004\u0000\u0016\u00a3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0004\u0000/\b\u0000\u000b\u0000"+
		"\f\u00000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001"+
		"7\b\u0001\n\u0001\f\u0001:\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012n\b\u0012\u0001\u0013\u0001\u0013\u0005\u0013"+
		"r\b\u0013\n\u0013\f\u0013u\t\u0013\u0001\u0014\u0003\u0014x\b\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014|\b\u0014\n\u0014\f\u0014\u007f\t\u0014"+
		"\u0003\u0014\u0081\b\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0085\b"+
		"\u0014\u000b\u0014\f\u0014\u0086\u0001\u0014\u0003\u0014\u008a\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0005\u0014\u008e\b\u0014\n\u0014\f\u0014\u0091"+
		"\t\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0095\b\u0014\n\u0014\f\u0014"+
		"\u0098\t\u0014\u0003\u0014\u009a\b\u0014\u0001\u0015\u0003\u0015\u009d"+
		"\b\u0015\u0001\u0015\u0004\u0015\u00a0\b\u0015\u000b\u0015\f\u0015\u00a1"+
		"\u0000\u0000\u0016\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016\u0001\u0000\u0006\u0002\u0000\r\r  \u0001\u0000\n\n\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u00b0\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0001.\u0001\u0000\u0000\u0000\u00034\u0001\u0000\u0000"+
		"\u0000\u0005=\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\t"+
		"A\u0001\u0000\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000"+
		"\u0000\u0000\u000fG\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000"+
		"\u0013K\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000\u0000\u0017P"+
		"\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001bU\u0001\u0000"+
		"\u0000\u0000\u001dW\u0001\u0000\u0000\u0000\u001fZ\u0001\u0000\u0000\u0000"+
		"!]\u0001\u0000\u0000\u0000#a\u0001\u0000\u0000\u0000%m\u0001\u0000\u0000"+
		"\u0000\'o\u0001\u0000\u0000\u0000)\u0099\u0001\u0000\u0000\u0000+\u009c"+
		"\u0001\u0000\u0000\u0000-/\u0007\u0000\u0000\u0000.-\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u000023\u0006\u0000\u0000\u00003\u0002"+
		"\u0001\u0000\u0000\u000048\u0005#\u0000\u000057\b\u0001\u0000\u000065"+
		"\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:8\u0001\u0000"+
		"\u0000\u0000;<\u0006\u0001\u0000\u0000<\u0004\u0001\u0000\u0000\u0000"+
		"=>\u0005\n\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005=\u0000\u0000"+
		"@\b\u0001\u0000\u0000\u0000AB\u0005(\u0000\u0000B\n\u0001\u0000\u0000"+
		"\u0000CD\u0005)\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005+\u0000"+
		"\u0000F\u000e\u0001\u0000\u0000\u0000GH\u0005-\u0000\u0000H\u0010\u0001"+
		"\u0000\u0000\u0000IJ\u0005*\u0000\u0000J\u0012\u0001\u0000\u0000\u0000"+
		"KL\u0005/\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005=\u0000\u0000"+
		"NO\u0005=\u0000\u0000O\u0016\u0001\u0000\u0000\u0000PQ\u0005!\u0000\u0000"+
		"QR\u0005=\u0000\u0000R\u0018\u0001\u0000\u0000\u0000ST\u0005>\u0000\u0000"+
		"T\u001a\u0001\u0000\u0000\u0000UV\u0005<\u0000\u0000V\u001c\u0001\u0000"+
		"\u0000\u0000WX\u0005>\u0000\u0000XY\u0005=\u0000\u0000Y\u001e\u0001\u0000"+
		"\u0000\u0000Z[\u0005<\u0000\u0000[\\\u0005=\u0000\u0000\\ \u0001\u0000"+
		"\u0000\u0000]^\u0005a\u0000\u0000^_\u0005n\u0000\u0000_`\u0005d\u0000"+
		"\u0000`\"\u0001\u0000\u0000\u0000ab\u0005o\u0000\u0000bc\u0005r\u0000"+
		"\u0000c$\u0001\u0000\u0000\u0000de\u0005T\u0000\u0000ef\u0005r\u0000\u0000"+
		"fg\u0005u\u0000\u0000gn\u0005e\u0000\u0000hi\u0005F\u0000\u0000ij\u0005"+
		"a\u0000\u0000jk\u0005l\u0000\u0000kl\u0005s\u0000\u0000ln\u0005e\u0000"+
		"\u0000md\u0001\u0000\u0000\u0000mh\u0001\u0000\u0000\u0000n&\u0001\u0000"+
		"\u0000\u0000os\u0007\u0002\u0000\u0000pr\u0007\u0003\u0000\u0000qp\u0001"+
		"\u0000\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000t(\u0001\u0000\u0000\u0000us\u0001\u0000\u0000"+
		"\u0000vx\u0005-\u0000\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000"+
		"\u0000x\u0080\u0001\u0000\u0000\u0000y}\u0007\u0004\u0000\u0000z|\u0007"+
		"\u0005\u0000\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0081\u0001"+
		"\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080y\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0084\u0005.\u0000\u0000\u0083\u0085\u0007\u0005\u0000\u0000"+
		"\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u009a\u0001\u0000\u0000\u0000\u0088\u008a\u0005-\u0000\u0000\u0089"+
		"\u0088\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u008f\u0007\u0004\u0000\u0000\u008c"+
		"\u008e\u0007\u0005\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0092\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0096\u0005.\u0000\u0000\u0093\u0095"+
		"\u0007\u0005\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098"+
		"\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096"+
		"\u0001\u0000\u0000\u0000\u0099w\u0001\u0000\u0000\u0000\u0099\u0089\u0001"+
		"\u0000\u0000\u0000\u009a*\u0001\u0000\u0000\u0000\u009b\u009d\u0005-\u0000"+
		"\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u00a0\u0007\u0005\u0000"+
		"\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a2,\u0001\u0000\u0000\u0000\u000f\u000008msw}\u0080\u0086\u0089"+
		"\u008f\u0096\u0099\u009c\u00a1\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}