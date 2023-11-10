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
		NUMBER=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "PLUS", "BOOLEAN", "ID", 
			"NUMBER"
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
			"ID", "NUMBER"
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


		 static class ContextExtention extends ParserRuleContext {
			protected int refToSymTab;
			public ContextExtention(ParserRuleContext parent, int invokingState) {
				 super(parent, invokingState);
				 refToSymTab = -1;
		 	}
			public void setRefToSymTab(int ref) {
				this.refToSymTab = ref;
			}
			public int getRefToSymTab() {
				return this.refToSymTab;
			}
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
		"\u0004\u0000\b]\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0001\u0000\u0004\u0000\u0013\b\u0000\u000b\u0000\f\u0000"+
		"\u0014\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001\u001b"+
		"\b\u0001\n\u0001\f\u0001\u001e\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u00051\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u00065\b\u0006\n\u0006\f\u00068\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0005\u0007<\b\u0007\n\u0007\f\u0007?\t\u0007\u0003\u0007A\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0004\u0007E\b\u0007\u000b\u0007\f\u0007F\u0001\u0007"+
		"\u0001\u0007\u0005\u0007K\b\u0007\n\u0007\f\u0007N\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007R\b\u0007\n\u0007\f\u0007U\t\u0007\u0001\u0007"+
		"\u0004\u0007X\b\u0007\u000b\u0007\f\u0007Y\u0003\u0007\\\b\u0007\u0000"+
		"\u0000\b\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0001\u0000\u0006\u0002\u0000\r\r  \u0001\u0000"+
		"\n\n\u0003\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u00000"+
		"9h\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0001\u0012"+
		"\u0001\u0000\u0000\u0000\u0003\u0018\u0001\u0000\u0000\u0000\u0005!\u0001"+
		"\u0000\u0000\u0000\u0007#\u0001\u0000\u0000\u0000\t%\u0001\u0000\u0000"+
		"\u0000\u000b0\u0001\u0000\u0000\u0000\r2\u0001\u0000\u0000\u0000\u000f"+
		"[\u0001\u0000\u0000\u0000\u0011\u0013\u0007\u0000\u0000\u0000\u0012\u0011"+
		"\u0001\u0000\u0000\u0000\u0013\u0014\u0001\u0000\u0000\u0000\u0014\u0012"+
		"\u0001\u0000\u0000\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0016"+
		"\u0001\u0000\u0000\u0000\u0016\u0017\u0006\u0000\u0000\u0000\u0017\u0002"+
		"\u0001\u0000\u0000\u0000\u0018\u001c\u0005#\u0000\u0000\u0019\u001b\b"+
		"\u0001\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001"+
		"\u0000\u0000\u0000\u001f \u0006\u0001\u0000\u0000 \u0004\u0001\u0000\u0000"+
		"\u0000!\"\u0005\n\u0000\u0000\"\u0006\u0001\u0000\u0000\u0000#$\u0005"+
		"=\u0000\u0000$\b\u0001\u0000\u0000\u0000%&\u0005+\u0000\u0000&\n\u0001"+
		"\u0000\u0000\u0000\'(\u0005T\u0000\u0000()\u0005r\u0000\u0000)*\u0005"+
		"u\u0000\u0000*1\u0005e\u0000\u0000+,\u0005F\u0000\u0000,-\u0005a\u0000"+
		"\u0000-.\u0005l\u0000\u0000./\u0005s\u0000\u0000/1\u0005e\u0000\u0000"+
		"0\'\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u00001\f\u0001\u0000\u0000"+
		"\u000026\u0007\u0002\u0000\u000035\u0007\u0003\u0000\u000043\u0001\u0000"+
		"\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007\u000e\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u00009=\u0007\u0004\u0000\u0000:<\u0007\u0005\u0000\u0000;:\u0001\u0000"+
		"\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"@9\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BD\u0005.\u0000\u0000CE\u0007\u0005\u0000\u0000DC\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000G\\\u0001\u0000\u0000\u0000HL\u0007\u0004\u0000\u0000IK\u0007"+
		"\u0005\u0000\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000OS\u0005.\u0000\u0000PR\u0007\u0005\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000T\\\u0001\u0000\u0000\u0000US\u0001"+
		"\u0000\u0000\u0000VX\u0007\u0005\u0000\u0000WV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000"+
		"\u0000Z\\\u0001\u0000\u0000\u0000[@\u0001\u0000\u0000\u0000[H\u0001\u0000"+
		"\u0000\u0000[W\u0001\u0000\u0000\u0000\\\u0010\u0001\u0000\u0000\u0000"+
		"\f\u0000\u0014\u001c06=@FLSY[\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}