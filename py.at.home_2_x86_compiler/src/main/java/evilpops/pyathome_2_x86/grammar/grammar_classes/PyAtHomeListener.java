// Generated from D:/Projects/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
package main.java.evilpops.pyathome_2_x86.grammar.grammar_classes;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PyAtHomeParser}.
 */
public interface PyAtHomeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PyAtHomeParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PyAtHomeParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#statementsList}.
	 * @param ctx the parse tree
	 */
	void enterStatementsList(PyAtHomeParser.StatementsListContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#statementsList}.
	 * @param ctx the parse tree
	 */
	void exitStatementsList(PyAtHomeParser.StatementsListContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PyAtHomeParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PyAtHomeParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(PyAtHomeParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#simpleStatement}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(PyAtHomeParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignStatement(PyAtHomeParser.AssignStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#assignStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignStatement(PyAtHomeParser.AssignStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#numExpression}.
	 * @param ctx the parse tree
	 */
	void enterNumExpression(PyAtHomeParser.NumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#numExpression}.
	 * @param ctx the parse tree
	 */
	void exitNumExpression(PyAtHomeParser.NumExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#addSubOperators}.
	 * @param ctx the parse tree
	 */
	void enterAddSubOperators(PyAtHomeParser.AddSubOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#addSubOperators}.
	 * @param ctx the parse tree
	 */
	void exitAddSubOperators(PyAtHomeParser.AddSubOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#mulDivOperators}.
	 * @param ctx the parse tree
	 */
	void enterMulDivOperators(PyAtHomeParser.MulDivOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#mulDivOperators}.
	 * @param ctx the parse tree
	 */
	void exitMulDivOperators(PyAtHomeParser.MulDivOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PyAtHomeParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PyAtHomeParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PyAtHomeParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PyAtHomeParser.LiteralContext ctx);
}