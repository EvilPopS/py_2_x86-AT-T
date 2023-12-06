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
		PLUS=7, MINUS=8, MUL=9, DIV=10, BOOLEAN=11, ID=12, FLOAT=13, INTEGER=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "BOOLEAN", "ID", "FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'('", "')'", "'+'", "'-'", "'*'", 
			"'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "BOOLEAN", "ID", "FLOAT", "INTEGER"
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
		"\u0004\u0000\u000e|\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0004\u0000\u001f"+
		"\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\'\b\u0001\n\u0001\f\u0001*\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\nG\b\n\u0001\u000b\u0001"+
		"\u000b\u0005\u000bK\b\u000b\n\u000b\f\u000bN\t\u000b\u0001\f\u0003\fQ"+
		"\b\f\u0001\f\u0001\f\u0005\fU\b\f\n\f\f\fX\t\f\u0003\fZ\b\f\u0001\f\u0001"+
		"\f\u0004\f^\b\f\u000b\f\f\f_\u0001\f\u0003\fc\b\f\u0001\f\u0001\f\u0005"+
		"\fg\b\f\n\f\f\fj\t\f\u0001\f\u0001\f\u0005\fn\b\f\n\f\f\fq\t\f\u0003\f"+
		"s\b\f\u0001\r\u0003\rv\b\r\u0001\r\u0004\ry\b\r\u000b\r\f\rz\u0000\u0000"+
		"\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u0001\u0000\u0006\u0002\u0000\r\r  \u0001\u0000\n\n\u0003\u0000AZ__a"+
		"z\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0089\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0001\u001e\u0001\u0000\u0000"+
		"\u0000\u0003$\u0001\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007"+
		"/\u0001\u0000\u0000\u0000\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000"+
		"\u0000\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000\u0000\u0000"+
		"\u00119\u0001\u0000\u0000\u0000\u0013;\u0001\u0000\u0000\u0000\u0015F"+
		"\u0001\u0000\u0000\u0000\u0017H\u0001\u0000\u0000\u0000\u0019r\u0001\u0000"+
		"\u0000\u0000\u001bu\u0001\u0000\u0000\u0000\u001d\u001f\u0007\u0000\u0000"+
		"\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000\u0000"+
		" \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\"\u0001\u0000"+
		"\u0000\u0000\"#\u0006\u0000\u0000\u0000#\u0002\u0001\u0000\u0000\u0000"+
		"$(\u0005#\u0000\u0000%\'\b\u0001\u0000\u0000&%\u0001\u0000\u0000\u0000"+
		"\'*\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+,\u0006\u0001"+
		"\u0000\u0000,\u0004\u0001\u0000\u0000\u0000-.\u0005\n\u0000\u0000.\u0006"+
		"\u0001\u0000\u0000\u0000/0\u0005=\u0000\u00000\b\u0001\u0000\u0000\u0000"+
		"12\u0005(\u0000\u00002\n\u0001\u0000\u0000\u000034\u0005)\u0000\u0000"+
		"4\f\u0001\u0000\u0000\u000056\u0005+\u0000\u00006\u000e\u0001\u0000\u0000"+
		"\u000078\u0005-\u0000\u00008\u0010\u0001\u0000\u0000\u00009:\u0005*\u0000"+
		"\u0000:\u0012\u0001\u0000\u0000\u0000;<\u0005/\u0000\u0000<\u0014\u0001"+
		"\u0000\u0000\u0000=>\u0005T\u0000\u0000>?\u0005r\u0000\u0000?@\u0005u"+
		"\u0000\u0000@G\u0005e\u0000\u0000AB\u0005F\u0000\u0000BC\u0005a\u0000"+
		"\u0000CD\u0005l\u0000\u0000DE\u0005s\u0000\u0000EG\u0005e\u0000\u0000"+
		"F=\u0001\u0000\u0000\u0000FA\u0001\u0000\u0000\u0000G\u0016\u0001\u0000"+
		"\u0000\u0000HL\u0007\u0002\u0000\u0000IK\u0007\u0003\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000M\u0018\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000OQ\u0005-\u0000\u0000PO\u0001\u0000\u0000\u0000PQ\u0001\u0000"+
		"\u0000\u0000QY\u0001\u0000\u0000\u0000RV\u0007\u0004\u0000\u0000SU\u0007"+
		"\u0005\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000YR\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[]\u0005.\u0000\u0000\\^\u0007\u0005"+
		"\u0000\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`s\u0001\u0000\u0000\u0000"+
		"ac\u0005-\u0000\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000dh\u0007\u0004\u0000\u0000eg\u0007\u0005\u0000"+
		"\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000ko\u0005.\u0000\u0000ln\u0007\u0005\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000rP\u0001\u0000\u0000\u0000rb\u0001\u0000\u0000\u0000s\u001a\u0001"+
		"\u0000\u0000\u0000tv\u0005-\u0000\u0000ut\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vx\u0001\u0000\u0000\u0000wy\u0007\u0005\u0000\u0000"+
		"xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{\u001c\u0001\u0000\u0000\u0000\u000f"+
		"\u0000 (FLPVY_bhoruz\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}