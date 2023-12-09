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
		LSEQ=16, BOOLEAN=17, ID=18, FLOAT=19, INTEGER=20;
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
			"BOOLEAN", "ID", "FLOAT", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\\n'", "'='", "'('", "')'", "'+'", "'-'", "'*'", 
			"'/'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS_SKIP", "COMMENT_SKIP", "NEWLINE", "ASSIGN", "L_PAREN", "R_PAREN", 
			"PLUS", "MINUS", "MUL", "DIV", "EQ", "NEQ", "GR", "LS", "GREQ", "LSEQ", 
			"BOOLEAN", "ID", "FLOAT", "INTEGER"
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
		"\u0004\u0000\u0014\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0004\u0000"+
		"+\b\u0000\u000b\u0000\f\u0000,\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010c\b\u0010\u0001\u0011\u0001\u0011\u0005"+
		"\u0011g\b\u0011\n\u0011\f\u0011j\t\u0011\u0001\u0012\u0003\u0012m\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012q\b\u0012\n\u0012\f\u0012t\t\u0012"+
		"\u0003\u0012v\b\u0012\u0001\u0012\u0001\u0012\u0004\u0012z\b\u0012\u000b"+
		"\u0012\f\u0012{\u0001\u0012\u0003\u0012\u007f\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u0083\b\u0012\n\u0012\f\u0012\u0086\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u008a\b\u0012\n\u0012\f\u0012\u008d\t\u0012\u0003"+
		"\u0012\u008f\b\u0012\u0001\u0013\u0003\u0013\u0092\b\u0013\u0001\u0013"+
		"\u0004\u0013\u0095\b\u0013\u000b\u0013\f\u0013\u0096\u0000\u0000\u0014"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0006"+
		"\u0002\u0000\r\r  \u0001\u0000\n\n\u0003\u0000AZ__az\u0004\u000009AZ_"+
		"_az\u0001\u000019\u0001\u000009\u00a5\u0000\u0001\u0001\u0000\u0000\u0000"+
		"\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000"+
		"\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f"+
		"\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013"+
		"\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017"+
		"\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b"+
		"\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f"+
		"\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000"+
		"\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000"+
		"\u0000\u0001*\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u0005"+
		"9\u0001\u0000\u0000\u0000\u0007;\u0001\u0000\u0000\u0000\t=\u0001\u0000"+
		"\u0000\u0000\u000b?\u0001\u0000\u0000\u0000\rA\u0001\u0000\u0000\u0000"+
		"\u000fC\u0001\u0000\u0000\u0000\u0011E\u0001\u0000\u0000\u0000\u0013G"+
		"\u0001\u0000\u0000\u0000\u0015I\u0001\u0000\u0000\u0000\u0017L\u0001\u0000"+
		"\u0000\u0000\u0019O\u0001\u0000\u0000\u0000\u001bQ\u0001\u0000\u0000\u0000"+
		"\u001dS\u0001\u0000\u0000\u0000\u001fV\u0001\u0000\u0000\u0000!b\u0001"+
		"\u0000\u0000\u0000#d\u0001\u0000\u0000\u0000%\u008e\u0001\u0000\u0000"+
		"\u0000\'\u0091\u0001\u0000\u0000\u0000)+\u0007\u0000\u0000\u0000*)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000./\u0006\u0000\u0000"+
		"\u0000/\u0002\u0001\u0000\u0000\u000004\u0005#\u0000\u000013\b\u0001\u0000"+
		"\u000021\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001"+
		"\u0000\u0000\u000078\u0006\u0001\u0000\u00008\u0004\u0001\u0000\u0000"+
		"\u00009:\u0005\n\u0000\u0000:\u0006\u0001\u0000\u0000\u0000;<\u0005=\u0000"+
		"\u0000<\b\u0001\u0000\u0000\u0000=>\u0005(\u0000\u0000>\n\u0001\u0000"+
		"\u0000\u0000?@\u0005)\u0000\u0000@\f\u0001\u0000\u0000\u0000AB\u0005+"+
		"\u0000\u0000B\u000e\u0001\u0000\u0000\u0000CD\u0005-\u0000\u0000D\u0010"+
		"\u0001\u0000\u0000\u0000EF\u0005*\u0000\u0000F\u0012\u0001\u0000\u0000"+
		"\u0000GH\u0005/\u0000\u0000H\u0014\u0001\u0000\u0000\u0000IJ\u0005=\u0000"+
		"\u0000JK\u0005=\u0000\u0000K\u0016\u0001\u0000\u0000\u0000LM\u0005!\u0000"+
		"\u0000MN\u0005=\u0000\u0000N\u0018\u0001\u0000\u0000\u0000OP\u0005>\u0000"+
		"\u0000P\u001a\u0001\u0000\u0000\u0000QR\u0005<\u0000\u0000R\u001c\u0001"+
		"\u0000\u0000\u0000ST\u0005>\u0000\u0000TU\u0005=\u0000\u0000U\u001e\u0001"+
		"\u0000\u0000\u0000VW\u0005<\u0000\u0000WX\u0005=\u0000\u0000X \u0001\u0000"+
		"\u0000\u0000YZ\u0005T\u0000\u0000Z[\u0005r\u0000\u0000[\\\u0005u\u0000"+
		"\u0000\\c\u0005e\u0000\u0000]^\u0005F\u0000\u0000^_\u0005a\u0000\u0000"+
		"_`\u0005l\u0000\u0000`a\u0005s\u0000\u0000ac\u0005e\u0000\u0000bY\u0001"+
		"\u0000\u0000\u0000b]\u0001\u0000\u0000\u0000c\"\u0001\u0000\u0000\u0000"+
		"dh\u0007\u0002\u0000\u0000eg\u0007\u0003\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000i$\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000km\u0005"+
		"-\u0000\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mu\u0001"+
		"\u0000\u0000\u0000nr\u0007\u0004\u0000\u0000oq\u0007\u0005\u0000\u0000"+
		"po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rs\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000un\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wy\u0005.\u0000\u0000xz\u0007\u0005\u0000\u0000yx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|\u008f\u0001\u0000\u0000\u0000}\u007f\u0005"+
		"-\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0084\u0007\u0004\u0000\u0000"+
		"\u0081\u0083\u0007\u0005\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000"+
		"\u0083\u0086\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000"+
		"\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u008b\u0005.\u0000\u0000\u0088"+
		"\u008a\u0007\u0005\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d"+
		"\u008b\u0001\u0000\u0000\u0000\u008el\u0001\u0000\u0000\u0000\u008e~\u0001"+
		"\u0000\u0000\u0000\u008f&\u0001\u0000\u0000\u0000\u0090\u0092\u0005-\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000"+
		"\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0095\u0007\u0005\u0000"+
		"\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000"+
		"\u0000\u0097(\u0001\u0000\u0000\u0000\u000f\u0000,4bhlru{~\u0084\u008b"+
		"\u008e\u0091\u0096\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}