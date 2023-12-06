// Generated from D:/Projects/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
package main.java.evilpops.pyathome_2_x86.grammar.grammar_classes;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PyAtHomeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, ASSIGN=4, L_PAREN=5, R_PAREN=6, 
		PLUS=7, MINUS=8, MUL=9, DIV=10, EQ=11, GR=12, LS=13, GREQ=14, LSEQ=15, 
		BOOLEAN=16, ID=17, FLOAT=18, INTEGER=19;
	public static final int
		RULE_program = 0, RULE_statementsList = 1, RULE_statement = 2, RULE_simpleStatement = 3, 
		RULE_assignStatement = 4, RULE_numExpression = 5, RULE_addSubOperators = 6, 
		RULE_mulDivOperators = 7, RULE_relOperators = 8, RULE_expression = 9, 
		RULE_literal = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statementsList", "statement", "simpleStatement", "assignStatement", 
			"numExpression", "addSubOperators", "mulDivOperators", "relOperators", 
			"expression", "literal"
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

	@Override
	public String getGrammarFileName() { return "PyAtHome.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public PyAtHomeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ContextExtention {
		public StatementsListContext statementsList() {
			return getRuleContext(StatementsListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			statementsList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsListContext extends ContextExtention {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterStatementsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitStatementsList(this);
		}
	}

	public final StatementsListContext statementsList() throws RecognitionException {
		StatementsListContext _localctx = new StatementsListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				statement();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ContextExtention {
		public SimpleStatementContext simpleStatement() {
			return getRuleContext(SimpleStatementContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PyAtHomeParser.NEWLINE, 0); }
		public TerminalNode EOF() { return getToken(PyAtHomeParser.EOF, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(35);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				simpleStatement();
				setState(30);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				simpleStatement();
				setState(33);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleStatementContext extends ContextExtention {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterSimpleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitSimpleStatement(this);
		}
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simpleStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			assignStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatementContext extends ContextExtention {
		public TerminalNode ID() { return getToken(PyAtHomeParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PyAtHomeParser.ASSIGN, 0); }
		public NumExpressionContext numExpression() {
			return getRuleContext(NumExpressionContext.class,0);
		}
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitAssignStatement(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(ID);
			setState(40);
			match(ASSIGN);
			setState(41);
			numExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumExpressionContext extends ContextExtention {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(PyAtHomeParser.L_PAREN, 0); }
		public List<NumExpressionContext> numExpression() {
			return getRuleContexts(NumExpressionContext.class);
		}
		public NumExpressionContext numExpression(int i) {
			return getRuleContext(NumExpressionContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(PyAtHomeParser.R_PAREN, 0); }
		public MulDivOperatorsContext mulDivOperators() {
			return getRuleContext(MulDivOperatorsContext.class,0);
		}
		public AddSubOperatorsContext addSubOperators() {
			return getRuleContext(AddSubOperatorsContext.class,0);
		}
		public RelOperatorsContext relOperators() {
			return getRuleContext(RelOperatorsContext.class,0);
		}
		public NumExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterNumExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitNumExpression(this);
		}
	}

	public final NumExpressionContext numExpression() throws RecognitionException {
		return numExpression(0);
	}

	private NumExpressionContext numExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumExpressionContext _localctx = new NumExpressionContext(_ctx, _parentState);
		NumExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_numExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case ID:
			case FLOAT:
			case INTEGER:
				{
				setState(44);
				expression();
				}
				break;
			case L_PAREN:
				{
				setState(45);
				match(L_PAREN);
				setState(46);
				numExpression(0);
				setState(47);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(63);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(51);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(52);
						mulDivOperators();
						setState(53);
						numExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(55);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(56);
						addSubOperators();
						setState(57);
						numExpression(3);
						}
						break;
					case 3:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(59);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(60);
						relOperators();
						setState(61);
						numExpression(2);
						}
						break;
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddSubOperatorsContext extends ContextExtention {
		public TerminalNode PLUS() { return getToken(PyAtHomeParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PyAtHomeParser.MINUS, 0); }
		public AddSubOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addSubOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterAddSubOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitAddSubOperators(this);
		}
	}

	public final AddSubOperatorsContext addSubOperators() throws RecognitionException {
		AddSubOperatorsContext _localctx = new AddSubOperatorsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_addSubOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulDivOperatorsContext extends ContextExtention {
		public TerminalNode MUL() { return getToken(PyAtHomeParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PyAtHomeParser.DIV, 0); }
		public MulDivOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulDivOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterMulDivOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitMulDivOperators(this);
		}
	}

	public final MulDivOperatorsContext mulDivOperators() throws RecognitionException {
		MulDivOperatorsContext _localctx = new MulDivOperatorsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_mulDivOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelOperatorsContext extends ContextExtention {
		public TerminalNode EQ() { return getToken(PyAtHomeParser.EQ, 0); }
		public TerminalNode GR() { return getToken(PyAtHomeParser.GR, 0); }
		public TerminalNode LS() { return getToken(PyAtHomeParser.LS, 0); }
		public TerminalNode GREQ() { return getToken(PyAtHomeParser.GREQ, 0); }
		public TerminalNode LSEQ() { return getToken(PyAtHomeParser.LSEQ, 0); }
		public RelOperatorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOperators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterRelOperators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitRelOperators(this);
		}
	}

	public final RelOperatorsContext relOperators() throws RecognitionException {
		RelOperatorsContext _localctx = new RelOperatorsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 63488L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ContextExtention {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ID() { return getToken(PyAtHomeParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expression);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				literal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ContextExtention {
		public TerminalNode INTEGER() { return getToken(PyAtHomeParser.INTEGER, 0); }
		public TerminalNode FLOAT() { return getToken(PyAtHomeParser.FLOAT, 0); }
		public TerminalNode BOOLEAN() { return getToken(PyAtHomeParser.BOOLEAN, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 851968L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return numExpression_sempred((NumExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean numExpression_sempred(NumExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0013Q\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0004\u0001\u001a\b\u0001\u000b\u0001\f\u0001\u001b\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"$\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u00052\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005@\b\u0005\n\u0005\f\u0005"+
		"C\t\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0003\tM\b\t\u0001\n\u0001\n\u0001\n\u0000\u0001\n"+
		"\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0004"+
		"\u0001\u0000\u0007\b\u0001\u0000\t\n\u0001\u0000\u000b\u000f\u0002\u0000"+
		"\u0010\u0010\u0012\u0013L\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u0019"+
		"\u0001\u0000\u0000\u0000\u0004#\u0001\u0000\u0000\u0000\u0006%\u0001\u0000"+
		"\u0000\u0000\b\'\u0001\u0000\u0000\u0000\n1\u0001\u0000\u0000\u0000\f"+
		"D\u0001\u0000\u0000\u0000\u000eF\u0001\u0000\u0000\u0000\u0010H\u0001"+
		"\u0000\u0000\u0000\u0012L\u0001\u0000\u0000\u0000\u0014N\u0001\u0000\u0000"+
		"\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0001\u0001\u0000\u0000"+
		"\u0000\u0018\u001a\u0003\u0004\u0002\u0000\u0019\u0018\u0001\u0000\u0000"+
		"\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u0003\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0003\u0006\u0003\u0000\u001e\u001f\u0005\u0003\u0000"+
		"\u0000\u001f$\u0001\u0000\u0000\u0000 !\u0003\u0006\u0003\u0000!\"\u0005"+
		"\u0000\u0000\u0001\"$\u0001\u0000\u0000\u0000#\u001d\u0001\u0000\u0000"+
		"\u0000# \u0001\u0000\u0000\u0000$\u0005\u0001\u0000\u0000\u0000%&\u0003"+
		"\b\u0004\u0000&\u0007\u0001\u0000\u0000\u0000\'(\u0005\u0011\u0000\u0000"+
		"()\u0005\u0004\u0000\u0000)*\u0003\n\u0005\u0000*\t\u0001\u0000\u0000"+
		"\u0000+,\u0006\u0005\uffff\uffff\u0000,2\u0003\u0012\t\u0000-.\u0005\u0005"+
		"\u0000\u0000./\u0003\n\u0005\u0000/0\u0005\u0006\u0000\u000002\u0001\u0000"+
		"\u0000\u00001+\u0001\u0000\u0000\u00001-\u0001\u0000\u0000\u00002A\u0001"+
		"\u0000\u0000\u000034\n\u0003\u0000\u000045\u0003\u000e\u0007\u000056\u0003"+
		"\n\u0005\u00046@\u0001\u0000\u0000\u000078\n\u0002\u0000\u000089\u0003"+
		"\f\u0006\u00009:\u0003\n\u0005\u0003:@\u0001\u0000\u0000\u0000;<\n\u0001"+
		"\u0000\u0000<=\u0003\u0010\b\u0000=>\u0003\n\u0005\u0002>@\u0001\u0000"+
		"\u0000\u0000?3\u0001\u0000\u0000\u0000?7\u0001\u0000\u0000\u0000?;\u0001"+
		"\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"AB\u0001\u0000\u0000\u0000B\u000b\u0001\u0000\u0000\u0000CA\u0001\u0000"+
		"\u0000\u0000DE\u0007\u0000\u0000\u0000E\r\u0001\u0000\u0000\u0000FG\u0007"+
		"\u0001\u0000\u0000G\u000f\u0001\u0000\u0000\u0000HI\u0007\u0002\u0000"+
		"\u0000I\u0011\u0001\u0000\u0000\u0000JM\u0003\u0014\n\u0000KM\u0005\u0011"+
		"\u0000\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000M\u0013"+
		"\u0001\u0000\u0000\u0000NO\u0007\u0003\u0000\u0000O\u0015\u0001\u0000"+
		"\u0000\u0000\u0006\u001b#1?AL";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}