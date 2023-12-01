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
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, ASSIGN=4, PLUS=5, MINUS=6, MUL=7, 
		DIV=8, BOOLEAN=9, ID=10, FLOAT=11, INTEGER=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "PLUS", "MINUS", "MUL", 
			"DIV", "BOOLEAN", "ID", "FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "PLUS", "MINUS", 
			"MUL", "DIV", "BOOLEAN", "ID", "FLOAT", "INTEGER"
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
		"\u0004\u0000\ft\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001#\b"+
		"\u0001\n\u0001\f\u0001&\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b?\b\b"+
		"\u0001\t\u0001\t\u0005\tC\b\t\n\t\f\tF\t\t\u0001\n\u0003\nI\b\n\u0001"+
		"\n\u0001\n\u0005\nM\b\n\n\n\f\nP\t\n\u0003\nR\b\n\u0001\n\u0001\n\u0004"+
		"\nV\b\n\u000b\n\f\nW\u0001\n\u0003\n[\b\n\u0001\n\u0001\n\u0005\n_\b\n"+
		"\n\n\f\nb\t\n\u0001\n\u0001\n\u0005\nf\b\n\n\n\f\ni\t\n\u0003\nk\b\n\u0001"+
		"\u000b\u0003\u000bn\b\u000b\u0001\u000b\u0004\u000bq\b\u000b\u000b\u000b"+
		"\f\u000br\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0001\u0000\u0006\u0002\u0000\r\r  \u0001\u0000\n\n\u0003\u0000AZ_"+
		"_az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0081\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0001\u001a\u0001\u0000"+
		"\u0000\u0000\u0003 \u0001\u0000\u0000\u0000\u0005)\u0001\u0000\u0000\u0000"+
		"\u0007+\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000\u000b/\u0001"+
		"\u0000\u0000\u0000\r1\u0001\u0000\u0000\u0000\u000f3\u0001\u0000\u0000"+
		"\u0000\u0011>\u0001\u0000\u0000\u0000\u0013@\u0001\u0000\u0000\u0000\u0015"+
		"j\u0001\u0000\u0000\u0000\u0017m\u0001\u0000\u0000\u0000\u0019\u001b\u0007"+
		"\u0000\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0006"+
		"\u0000\u0000\u0000\u001f\u0002\u0001\u0000\u0000\u0000 $\u0005#\u0000"+
		"\u0000!#\b\u0001\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000"+
		"\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%\'\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000\'(\u0006\u0001\u0000\u0000"+
		"(\u0004\u0001\u0000\u0000\u0000)*\u0005\n\u0000\u0000*\u0006\u0001\u0000"+
		"\u0000\u0000+,\u0005=\u0000\u0000,\b\u0001\u0000\u0000\u0000-.\u0005+"+
		"\u0000\u0000.\n\u0001\u0000\u0000\u0000/0\u0005-\u0000\u00000\f\u0001"+
		"\u0000\u0000\u000012\u0005*\u0000\u00002\u000e\u0001\u0000\u0000\u0000"+
		"34\u0005/\u0000\u00004\u0010\u0001\u0000\u0000\u000056\u0005T\u0000\u0000"+
		"67\u0005r\u0000\u000078\u0005u\u0000\u00008?\u0005e\u0000\u00009:\u0005"+
		"F\u0000\u0000:;\u0005a\u0000\u0000;<\u0005l\u0000\u0000<=\u0005s\u0000"+
		"\u0000=?\u0005e\u0000\u0000>5\u0001\u0000\u0000\u0000>9\u0001\u0000\u0000"+
		"\u0000?\u0012\u0001\u0000\u0000\u0000@D\u0007\u0002\u0000\u0000AC\u0007"+
		"\u0003\u0000\u0000BA\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000"+
		"DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0014\u0001\u0000"+
		"\u0000\u0000FD\u0001\u0000\u0000\u0000GI\u0005-\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IQ\u0001\u0000\u0000\u0000JN\u0007"+
		"\u0004\u0000\u0000KM\u0007\u0005\u0000\u0000LK\u0001\u0000\u0000\u0000"+
		"MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000"+
		"\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000QJ\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0005"+
		".\u0000\u0000TV\u0007\u0005\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"Xk\u0001\u0000\u0000\u0000Y[\u0005-\u0000\u0000ZY\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\`\u0007\u0004\u0000"+
		"\u0000]_\u0007\u0005\u0000\u0000^]\u0001\u0000\u0000\u0000_b\u0001\u0000"+
		"\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cg\u0005.\u0000\u0000df\u0007"+
		"\u0005\u0000\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000"+
		"ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000jH\u0001\u0000\u0000\u0000jZ\u0001\u0000"+
		"\u0000\u0000k\u0016\u0001\u0000\u0000\u0000ln\u0005-\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0001\u0000\u0000\u0000"+
		"oq\u0007\u0005\u0000\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000"+
		"\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0018\u0001"+
		"\u0000\u0000\u0000\u000f\u0000\u001c$>DHNQWZ`gjmr\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}