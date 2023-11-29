// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
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
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, ASSIGN=4, PLUS=5, BOOLEAN=6, ID=7, 
		FLOAT=8, INTEGER=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "PLUS", "BOOLEAN", "ID", 
			"FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "PLUS", "BOOLEAN", 
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
		"\u0004\u0000\t_\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0004\u0000\u0015\b\u0000\u000b"+
		"\u0000\f\u0000\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u001d\b\u0001\n\u0001\f\u0001 \t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u00053\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0005\u00067\b\u0006\n\u0006\f\u0006:\t\u0006\u0001\u0007"+
		"\u0001\u0007\u0005\u0007>\b\u0007\n\u0007\f\u0007A\t\u0007\u0003\u0007"+
		"C\b\u0007\u0001\u0007\u0001\u0007\u0004\u0007G\b\u0007\u000b\u0007\f\u0007"+
		"H\u0001\u0007\u0001\u0007\u0005\u0007M\b\u0007\n\u0007\f\u0007P\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007T\b\u0007\n\u0007\f\u0007W\t\u0007"+
		"\u0003\u0007Y\b\u0007\u0001\b\u0004\b\\\b\b\u000b\b\f\b]\u0000\u0000\t"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0001\u0000\u0006\u0002\u0000\r\r  \u0001\u0000"+
		"\n\n\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u00000"+
		"9i\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0003\u001a"+
		"\u0001\u0000\u0000\u0000\u0005#\u0001\u0000\u0000\u0000\u0007%\u0001\u0000"+
		"\u0000\u0000\t\'\u0001\u0000\u0000\u0000\u000b2\u0001\u0000\u0000\u0000"+
		"\r4\u0001\u0000\u0000\u0000\u000fX\u0001\u0000\u0000\u0000\u0011[\u0001"+
		"\u0000\u0000\u0000\u0013\u0015\u0007\u0000\u0000\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0006\u0000\u0000\u0000\u0019\u0002\u0001"+
		"\u0000\u0000\u0000\u001a\u001e\u0005#\u0000\u0000\u001b\u001d\b\u0001"+
		"\u0000\u0000\u001c\u001b\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000"+
		"\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000"+
		"\u0000\u001f!\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000!"+
		"\"\u0006\u0001\u0000\u0000\"\u0004\u0001\u0000\u0000\u0000#$\u0005\n\u0000"+
		"\u0000$\u0006\u0001\u0000\u0000\u0000%&\u0005=\u0000\u0000&\b\u0001\u0000"+
		"\u0000\u0000\'(\u0005+\u0000\u0000(\n\u0001\u0000\u0000\u0000)*\u0005"+
		"T\u0000\u0000*+\u0005r\u0000\u0000+,\u0005u\u0000\u0000,3\u0005e\u0000"+
		"\u0000-.\u0005F\u0000\u0000./\u0005a\u0000\u0000/0\u0005l\u0000\u0000"+
		"01\u0005s\u0000\u000013\u0005e\u0000\u00002)\u0001\u0000\u0000\u00002"+
		"-\u0001\u0000\u0000\u00003\f\u0001\u0000\u0000\u000048\u0007\u0002\u0000"+
		"\u000057\u0007\u0003\u0000\u000065\u0001\u0000\u0000\u00007:\u0001\u0000"+
		"\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u000e"+
		"\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000;?\u0007\u0004\u0000"+
		"\u0000<>\u0007\u0005\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@C\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000B;\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0005.\u0000\u0000"+
		"EG\u0007\u0005\u0000\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IY\u0001\u0000"+
		"\u0000\u0000JN\u0007\u0004\u0000\u0000KM\u0007\u0005\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000"+
		"\u0000QU\u0005.\u0000\u0000RT\u0007\u0005\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000XB\u0001"+
		"\u0000\u0000\u0000XJ\u0001\u0000\u0000\u0000Y\u0010\u0001\u0000\u0000"+
		"\u0000Z\\\u0007\u0005\u0000\u0000[Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^\u0012"+
		"\u0001\u0000\u0000\u0000\f\u0000\u0016\u001e28?BHNUX]\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}