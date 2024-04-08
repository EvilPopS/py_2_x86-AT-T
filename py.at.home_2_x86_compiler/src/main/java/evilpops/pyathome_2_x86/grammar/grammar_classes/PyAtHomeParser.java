// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
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
		WS_SKIP=1, COMMENT_SKIP=2, NEWLINE=3, DEF=4, RETURN=5, T_INT=6, T_FLOAT=7, 
		T_BOOLEAN=8, T_STRING=9, T_NONE=10, ARROW=11, COMMA=12, COLON=13, ASSIGN=14, 
		L_PAREN=15, R_PAREN=16, PLUS=17, MINUS=18, MUL=19, DIV=20, EQ=21, NEQ=22, 
		GR=23, LS=24, GREQ=25, LSEQ=26, AND=27, OR=28, NONE=29, BOOLEAN=30, ID=31, 
		FLOAT=32, INTEGER=33, STRING=34, INDENT=35, DEDENT=36, INVALID_DENT=37;
	public static final int
		RULE_program = 0, RULE_statementsList = 1, RULE_statement = 2, RULE_simpleStatement = 3, 
		RULE_compundStatement = 4, RULE_assignStatement = 5, RULE_returnStatement = 6, 
		RULE_functionDef = 7, RULE_functionDeclaration = 8, RULE_functionIdentifier = 9, 
		RULE_parameters = 10, RULE_paramNonDefVal = 11, RULE_paramDefVal = 12, 
		RULE_block = 13, RULE_retType = 14, RULE_varType = 15, RULE_types = 16, 
		RULE_numExpression = 17, RULE_addSubOperators = 18, RULE_mulDivOperators = 19, 
		RULE_relOperators = 20, RULE_logicAndOperator = 21, RULE_logicOrOperator = 22, 
		RULE_expression = 23, RULE_literal = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statementsList", "statement", "simpleStatement", "compundStatement", 
			"assignStatement", "returnStatement", "functionDef", "functionDeclaration", 
			"functionIdentifier", "parameters", "paramNonDefVal", "paramDefVal", 
			"block", "retType", "varType", "types", "numExpression", "addSubOperators", 
			"mulDivOperators", "relOperators", "logicAndOperator", "logicOrOperator", 
			"expression", "literal"
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
			"FLOAT", "INTEGER", "STRING", "INDENT", "DEDENT", "INVALID_DENT"
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
		public TerminalNode EOF() { return getToken(PyAtHomeParser.EOF, 0); }
		public TerminalNode NEWLINE() { return getToken(PyAtHomeParser.NEWLINE, 0); }
		public TerminalNode INVALID_DENT() { return getToken(PyAtHomeParser.INVALID_DENT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(50);
				match(NEWLINE);
				}
			}

			setState(53);
			statementsList();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INVALID_DENT) {
				{
				setState(54);
				match(INVALID_DENT);
				}
			}

			setState(57);
			match(EOF);
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
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				statement();
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2147483696L) != 0) );
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
		public CompundStatementContext compundStatement() {
			return getRuleContext(CompundStatementContext.class,0);
		}
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
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				simpleStatement();
				setState(65);
				match(NEWLINE);
				}
				break;
			case DEF:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				compundStatement();
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
	public static class SimpleStatementContext extends ContextExtention {
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				assignStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				returnStatement();
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
	public static class CompundStatementContext extends ContextExtention {
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public CompundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compundStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterCompundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitCompundStatement(this);
		}
	}

	public final CompundStatementContext compundStatement() throws RecognitionException {
		CompundStatementContext _localctx = new CompundStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_compundStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			functionDef();
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
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
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
		enterRule(_localctx, 10, RULE_assignStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(ID);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(77);
				varType();
				}
			}

			setState(80);
			match(ASSIGN);
			setState(81);
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
	public static class ReturnStatementContext extends ContextExtention {
		public TerminalNode RETURN() { return getToken(PyAtHomeParser.RETURN, 0); }
		public NumExpressionContext numExpression() {
			return getRuleContext(NumExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStatement);
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83);
				match(RETURN);
				setState(84);
				numExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				match(RETURN);
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
	public static class FunctionDefContext extends ContextExtention {
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitFunctionDef(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			functionDeclaration();
			setState(89);
			block();
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
	public static class FunctionDeclarationContext extends ContextExtention {
		public FunctionIdentifierContext functionIdentifier() {
			return getRuleContext(FunctionIdentifierContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(PyAtHomeParser.L_PAREN, 0); }
		public TerminalNode R_PAREN() { return getToken(PyAtHomeParser.R_PAREN, 0); }
		public TerminalNode COLON() { return getToken(PyAtHomeParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(PyAtHomeParser.NEWLINE, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public RetTypeContext retType() {
			return getRuleContext(RetTypeContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			functionIdentifier();
			setState(92);
			match(L_PAREN);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(93);
				parameters();
				}
			}

			setState(96);
			match(R_PAREN);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARROW) {
				{
				setState(97);
				retType();
				}
			}

			setState(100);
			match(COLON);
			setState(101);
			match(NEWLINE);
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
	public static class FunctionIdentifierContext extends ContextExtention {
		public TerminalNode DEF() { return getToken(PyAtHomeParser.DEF, 0); }
		public TerminalNode ID() { return getToken(PyAtHomeParser.ID, 0); }
		public FunctionIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterFunctionIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitFunctionIdentifier(this);
		}
	}

	public final FunctionIdentifierContext functionIdentifier() throws RecognitionException {
		FunctionIdentifierContext _localctx = new FunctionIdentifierContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(DEF);
			setState(104);
			match(ID);
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
	public static class ParametersContext extends ContextExtention {
		public ParamNonDefValContext paramNonDefVal() {
			return getRuleContext(ParamNonDefValContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PyAtHomeParser.COMMA, 0); }
		public ParamDefValContext paramDefVal() {
			return getRuleContext(ParamDefValContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitParameters(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				paramNonDefVal(0);
				setState(107);
				match(COMMA);
				setState(108);
				paramDefVal(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				paramNonDefVal(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				paramDefVal(0);
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
	public static class ParamNonDefValContext extends ContextExtention {
		public TerminalNode ID() { return getToken(PyAtHomeParser.ID, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<ParamNonDefValContext> paramNonDefVal() {
			return getRuleContexts(ParamNonDefValContext.class);
		}
		public ParamNonDefValContext paramNonDefVal(int i) {
			return getRuleContext(ParamNonDefValContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PyAtHomeParser.COMMA, 0); }
		public ParamNonDefValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramNonDefVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterParamNonDefVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitParamNonDefVal(this);
		}
	}

	public final ParamNonDefValContext paramNonDefVal() throws RecognitionException {
		return paramNonDefVal(0);
	}

	private ParamNonDefValContext paramNonDefVal(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParamNonDefValContext _localctx = new ParamNonDefValContext(_ctx, _parentState);
		ParamNonDefValContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_paramNonDefVal, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(115);
			match(ID);
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(116);
				varType();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParamNonDefValContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_paramNonDefVal);
					setState(119);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(120);
					match(COMMA);
					setState(121);
					paramNonDefVal(2);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class ParamDefValContext extends ContextExtention {
		public TerminalNode ID() { return getToken(PyAtHomeParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(PyAtHomeParser.ASSIGN, 0); }
		public NumExpressionContext numExpression() {
			return getRuleContext(NumExpressionContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<ParamDefValContext> paramDefVal() {
			return getRuleContexts(ParamDefValContext.class);
		}
		public ParamDefValContext paramDefVal(int i) {
			return getRuleContext(ParamDefValContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PyAtHomeParser.COMMA, 0); }
		public ParamDefValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDefVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterParamDefVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitParamDefVal(this);
		}
	}

	public final ParamDefValContext paramDefVal() throws RecognitionException {
		return paramDefVal(0);
	}

	private ParamDefValContext paramDefVal(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ParamDefValContext _localctx = new ParamDefValContext(_ctx, _parentState);
		ParamDefValContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_paramDefVal, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(128);
			match(ID);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(129);
				varType();
				}
			}

			setState(132);
			match(ASSIGN);
			setState(133);
			numExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ParamDefValContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_paramDefVal);
					setState(135);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(136);
					match(COMMA);
					setState(137);
					paramDefVal(2);
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class BlockContext extends ContextExtention {
		public TerminalNode INDENT() { return getToken(PyAtHomeParser.INDENT, 0); }
		public StatementsListContext statementsList() {
			return getRuleContext(StatementsListContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(PyAtHomeParser.DEDENT, 0); }
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(INDENT);
			setState(144);
			statementsList();
			setState(145);
			match(DEDENT);
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
	public static class RetTypeContext extends ContextExtention {
		public TerminalNode ARROW() { return getToken(PyAtHomeParser.ARROW, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public RetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_retType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterRetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitRetType(this);
		}
	}

	public final RetTypeContext retType() throws RecognitionException {
		RetTypeContext _localctx = new RetTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_retType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(ARROW);
			setState(148);
			types();
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
	public static class VarTypeContext extends ContextExtention {
		public TerminalNode COLON() { return getToken(PyAtHomeParser.COLON, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(COLON);
			setState(151);
			types();
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
	public static class TypesContext extends ContextExtention {
		public TerminalNode T_INT() { return getToken(PyAtHomeParser.T_INT, 0); }
		public TerminalNode T_FLOAT() { return getToken(PyAtHomeParser.T_FLOAT, 0); }
		public TerminalNode T_BOOLEAN() { return getToken(PyAtHomeParser.T_BOOLEAN, 0); }
		public TerminalNode T_STRING() { return getToken(PyAtHomeParser.T_STRING, 0); }
		public TerminalNode T_NONE() { return getToken(PyAtHomeParser.T_NONE, 0); }
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitTypes(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1984L) != 0)) ) {
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
		public LogicAndOperatorContext logicAndOperator() {
			return getRuleContext(LogicAndOperatorContext.class,0);
		}
		public LogicOrOperatorContext logicOrOperator() {
			return getRuleContext(LogicOrOperatorContext.class,0);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_numExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case BOOLEAN:
			case ID:
			case FLOAT:
			case INTEGER:
			case STRING:
				{
				setState(156);
				expression();
				}
				break;
			case L_PAREN:
				{
				setState(157);
				match(L_PAREN);
				setState(158);
				numExpression(0);
				setState(159);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(183);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(163);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(164);
						mulDivOperators();
						setState(165);
						numExpression(6);
						}
						break;
					case 2:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(167);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(168);
						addSubOperators();
						setState(169);
						numExpression(5);
						}
						break;
					case 3:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(171);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(172);
						relOperators();
						setState(173);
						numExpression(4);
						}
						break;
					case 4:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(175);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(176);
						logicAndOperator();
						setState(177);
						numExpression(3);
						}
						break;
					case 5:
						{
						_localctx = new NumExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numExpression);
						setState(179);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(180);
						logicOrOperator();
						setState(181);
						numExpression(2);
						}
						break;
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
		enterRule(_localctx, 36, RULE_addSubOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 38, RULE_mulDivOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		public TerminalNode NEQ() { return getToken(PyAtHomeParser.NEQ, 0); }
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
		enterRule(_localctx, 40, RULE_relOperators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 132120576L) != 0)) ) {
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
	public static class LogicAndOperatorContext extends ContextExtention {
		public TerminalNode AND() { return getToken(PyAtHomeParser.AND, 0); }
		public LogicAndOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterLogicAndOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitLogicAndOperator(this);
		}
	}

	public final LogicAndOperatorContext logicAndOperator() throws RecognitionException {
		LogicAndOperatorContext _localctx = new LogicAndOperatorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_logicAndOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(AND);
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
	public static class LogicOrOperatorContext extends ContextExtention {
		public TerminalNode OR() { return getToken(PyAtHomeParser.OR, 0); }
		public LogicOrOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).enterLogicOrOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PyAtHomeListener ) ((PyAtHomeListener)listener).exitLogicOrOperator(this);
		}
	}

	public final LogicOrOperatorContext logicOrOperator() throws RecognitionException {
		LogicOrOperatorContext _localctx = new LogicOrOperatorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_logicOrOperator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(OR);
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
		enterRule(_localctx, 46, RULE_expression);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NONE:
			case BOOLEAN:
			case FLOAT:
			case INTEGER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				literal();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
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
		public TerminalNode STRING() { return getToken(PyAtHomeParser.STRING, 0); }
		public TerminalNode NONE() { return getToken(PyAtHomeParser.NONE, 0); }
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
		enterRule(_localctx, 48, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31675383808L) != 0)) ) {
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
		case 11:
			return paramNonDefVal_sempred((ParamNonDefValContext)_localctx, predIndex);
		case 12:
			return paramDefVal_sempred((ParamDefValContext)_localctx, predIndex);
		case 17:
			return numExpression_sempred((NumExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean paramNonDefVal_sempred(ParamNonDefValContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean paramDefVal_sempred(ParamDefValContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean numExpression_sempred(NumExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001%\u00cd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0003\u00004\b\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"8\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001=\b\u0001\u000b"+
		"\u0001\f\u0001>\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002E\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005O\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"W\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0003\b_\b\b\u0001\b\u0001\b\u0003\bc\b\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nq\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bv\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b{\b\u000b\n\u000b\f\u000b~\t"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u0083\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u008b\b\f\n\f\f\f\u008e\t\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00a2\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00b8\b\u0011\n\u0011\f\u0011\u00bb"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0003\u0017\u00c9\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0000"+
		"\u0003\u0016\u0018\"\u0019\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.0\u0000\u0005\u0001\u0000"+
		"\u0006\n\u0001\u0000\u0011\u0012\u0001\u0000\u0013\u0014\u0001\u0000\u0015"+
		"\u001a\u0002\u0000\u001d\u001e \"\u00c9\u00003\u0001\u0000\u0000\u0000"+
		"\u0002<\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006H"+
		"\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nL\u0001\u0000\u0000"+
		"\u0000\fV\u0001\u0000\u0000\u0000\u000eX\u0001\u0000\u0000\u0000\u0010"+
		"[\u0001\u0000\u0000\u0000\u0012g\u0001\u0000\u0000\u0000\u0014p\u0001"+
		"\u0000\u0000\u0000\u0016r\u0001\u0000\u0000\u0000\u0018\u007f\u0001\u0000"+
		"\u0000\u0000\u001a\u008f\u0001\u0000\u0000\u0000\u001c\u0093\u0001\u0000"+
		"\u0000\u0000\u001e\u0096\u0001\u0000\u0000\u0000 \u0099\u0001\u0000\u0000"+
		"\u0000\"\u00a1\u0001\u0000\u0000\u0000$\u00bc\u0001\u0000\u0000\u0000"+
		"&\u00be\u0001\u0000\u0000\u0000(\u00c0\u0001\u0000\u0000\u0000*\u00c2"+
		"\u0001\u0000\u0000\u0000,\u00c4\u0001\u0000\u0000\u0000.\u00c8\u0001\u0000"+
		"\u0000\u00000\u00ca\u0001\u0000\u0000\u000024\u0005\u0003\u0000\u0000"+
		"32\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0003\u0002\u0001\u000068\u0005%\u0000\u000076\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0005\u0000"+
		"\u0000\u0001:\u0001\u0001\u0000\u0000\u0000;=\u0003\u0004\u0002\u0000"+
		"<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0003"+
		"\u0006\u0003\u0000AB\u0005\u0003\u0000\u0000BE\u0001\u0000\u0000\u0000"+
		"CE\u0003\b\u0004\u0000D@\u0001\u0000\u0000\u0000DC\u0001\u0000\u0000\u0000"+
		"E\u0005\u0001\u0000\u0000\u0000FI\u0003\n\u0005\u0000GI\u0003\f\u0006"+
		"\u0000HF\u0001\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000I\u0007\u0001"+
		"\u0000\u0000\u0000JK\u0003\u000e\u0007\u0000K\t\u0001\u0000\u0000\u0000"+
		"LN\u0005\u001f\u0000\u0000MO\u0003\u001e\u000f\u0000NM\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0005\u000e"+
		"\u0000\u0000QR\u0003\"\u0011\u0000R\u000b\u0001\u0000\u0000\u0000ST\u0005"+
		"\u0005\u0000\u0000TW\u0003\"\u0011\u0000UW\u0005\u0005\u0000\u0000VS\u0001"+
		"\u0000\u0000\u0000VU\u0001\u0000\u0000\u0000W\r\u0001\u0000\u0000\u0000"+
		"XY\u0003\u0010\b\u0000YZ\u0003\u001a\r\u0000Z\u000f\u0001\u0000\u0000"+
		"\u0000[\\\u0003\u0012\t\u0000\\^\u0005\u000f\u0000\u0000]_\u0003\u0014"+
		"\n\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`b\u0005\u0010\u0000\u0000ac\u0003\u001c\u000e\u0000ba\u0001"+
		"\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000"+
		"de\u0005\r\u0000\u0000ef\u0005\u0003\u0000\u0000f\u0011\u0001\u0000\u0000"+
		"\u0000gh\u0005\u0004\u0000\u0000hi\u0005\u001f\u0000\u0000i\u0013\u0001"+
		"\u0000\u0000\u0000jk\u0003\u0016\u000b\u0000kl\u0005\f\u0000\u0000lm\u0003"+
		"\u0018\f\u0000mq\u0001\u0000\u0000\u0000nq\u0003\u0016\u000b\u0000oq\u0003"+
		"\u0018\f\u0000pj\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000q\u0015\u0001\u0000\u0000\u0000rs\u0006\u000b\uffff"+
		"\uffff\u0000su\u0005\u001f\u0000\u0000tv\u0003\u001e\u000f\u0000ut\u0001"+
		"\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v|\u0001\u0000\u0000\u0000"+
		"wx\n\u0001\u0000\u0000xy\u0005\f\u0000\u0000y{\u0003\u0016\u000b\u0002"+
		"zw\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u0017\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0006\f\uffff\uffff\u0000\u0080\u0082\u0005"+
		"\u001f\u0000\u0000\u0081\u0083\u0003\u001e\u000f\u0000\u0082\u0081\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005\u000e\u0000\u0000\u0085\u0086\u0003"+
		"\"\u0011\u0000\u0086\u008c\u0001\u0000\u0000\u0000\u0087\u0088\n\u0001"+
		"\u0000\u0000\u0088\u0089\u0005\f\u0000\u0000\u0089\u008b\u0003\u0018\f"+
		"\u0002\u008a\u0087\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000"+
		"\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000"+
		"\u0000\u008d\u0019\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005#\u0000\u0000\u0090\u0091\u0003\u0002\u0001\u0000"+
		"\u0091\u0092\u0005$\u0000\u0000\u0092\u001b\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005\u000b\u0000\u0000\u0094\u0095\u0003 \u0010\u0000\u0095\u001d"+
		"\u0001\u0000\u0000\u0000\u0096\u0097\u0005\r\u0000\u0000\u0097\u0098\u0003"+
		" \u0010\u0000\u0098\u001f\u0001\u0000\u0000\u0000\u0099\u009a\u0007\u0000"+
		"\u0000\u0000\u009a!\u0001\u0000\u0000\u0000\u009b\u009c\u0006\u0011\uffff"+
		"\uffff\u0000\u009c\u00a2\u0003.\u0017\u0000\u009d\u009e\u0005\u000f\u0000"+
		"\u0000\u009e\u009f\u0003\"\u0011\u0000\u009f\u00a0\u0005\u0010\u0000\u0000"+
		"\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009b\u0001\u0000\u0000\u0000"+
		"\u00a1\u009d\u0001\u0000\u0000\u0000\u00a2\u00b9\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\n\u0005\u0000\u0000\u00a4\u00a5\u0003&\u0013\u0000\u00a5"+
		"\u00a6\u0003\"\u0011\u0006\u00a6\u00b8\u0001\u0000\u0000\u0000\u00a7\u00a8"+
		"\n\u0004\u0000\u0000\u00a8\u00a9\u0003$\u0012\u0000\u00a9\u00aa\u0003"+
		"\"\u0011\u0005\u00aa\u00b8\u0001\u0000\u0000\u0000\u00ab\u00ac\n\u0003"+
		"\u0000\u0000\u00ac\u00ad\u0003(\u0014\u0000\u00ad\u00ae\u0003\"\u0011"+
		"\u0004\u00ae\u00b8\u0001\u0000\u0000\u0000\u00af\u00b0\n\u0002\u0000\u0000"+
		"\u00b0\u00b1\u0003*\u0015\u0000\u00b1\u00b2\u0003\"\u0011\u0003\u00b2"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b3\u00b4\n\u0001\u0000\u0000\u00b4\u00b5"+
		"\u0003,\u0016\u0000\u00b5\u00b6\u0003\"\u0011\u0002\u00b6\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b7\u00a3\u0001\u0000\u0000\u0000\u00b7\u00a7\u0001"+
		"\u0000\u0000\u0000\u00b7\u00ab\u0001\u0000\u0000\u0000\u00b7\u00af\u0001"+
		"\u0000\u0000\u0000\u00b7\u00b3\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba#\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u0007\u0001\u0000\u0000\u00bd%\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0007\u0002\u0000\u0000\u00bf\'\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0007\u0003\u0000\u0000\u00c1)\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005\u001b\u0000\u0000\u00c3+\u0001\u0000\u0000\u0000\u00c4\u00c5"+
		"\u0005\u001c\u0000\u0000\u00c5-\u0001\u0000\u0000\u0000\u00c6\u00c9\u0003"+
		"0\u0018\u0000\u00c7\u00c9\u0005\u001f\u0000\u0000\u00c8\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000\u00c9/\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0007\u0004\u0000\u0000\u00cb1\u0001\u0000\u0000\u0000"+
		"\u001237>DHNV^bpu|\u0082\u008c\u00a1\u00b7\u00b9\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}