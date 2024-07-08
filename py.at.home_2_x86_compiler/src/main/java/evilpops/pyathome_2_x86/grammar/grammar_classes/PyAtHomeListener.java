// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/grammar/PyAtHome.g4 by ANTLR 4.13.1
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
	 * Enter a parse tree produced by {@link PyAtHomeParser#compundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompundStatement(PyAtHomeParser.CompundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#compundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompundStatement(PyAtHomeParser.CompundStatementContext ctx);
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
	 * Enter a parse tree produced by {@link PyAtHomeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(PyAtHomeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(PyAtHomeParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(PyAtHomeParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(PyAtHomeParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(PyAtHomeParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#passStatement}.
	 * @param ctx the parse tree
	 */
	void enterPassStatement(PyAtHomeParser.PassStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#passStatement}.
	 * @param ctx the parse tree
	 */
	void exitPassStatement(PyAtHomeParser.PassStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#printFunctionCall}.
	 * @param ctx the parse tree
	 */
	void enterPrintFunctionCall(PyAtHomeParser.PrintFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#printFunctionCall}.
	 * @param ctx the parse tree
	 */
	void exitPrintFunctionCall(PyAtHomeParser.PrintFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(PyAtHomeParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(PyAtHomeParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#functionIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PyAtHomeParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PyAtHomeParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#paramNonDefVal}.
	 * @param ctx the parse tree
	 */
	void enterParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#paramNonDefVal}.
	 * @param ctx the parse tree
	 */
	void exitParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#paramDefVal}.
	 * @param ctx the parse tree
	 */
	void enterParamDefVal(PyAtHomeParser.ParamDefValContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#paramDefVal}.
	 * @param ctx the parse tree
	 */
	void exitParamDefVal(PyAtHomeParser.ParamDefValContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#whileElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileElseStatement(PyAtHomeParser.WhileElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#whileElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileElseStatement(PyAtHomeParser.WhileElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#whileStatPart}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatPart(PyAtHomeParser.WhileStatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#whileStatPart}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatPart(PyAtHomeParser.WhileStatPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#whileConditionPart}.
	 * @param ctx the parse tree
	 */
	void enterWhileConditionPart(PyAtHomeParser.WhileConditionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#whileConditionPart}.
	 * @param ctx the parse tree
	 */
	void exitWhileConditionPart(PyAtHomeParser.WhileConditionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#ifElifElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfElifElseStatement(PyAtHomeParser.IfElifElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#ifElifElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfElifElseStatement(PyAtHomeParser.IfElifElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#ifStatPart}.
	 * @param ctx the parse tree
	 */
	void enterIfStatPart(PyAtHomeParser.IfStatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#ifStatPart}.
	 * @param ctx the parse tree
	 */
	void exitIfStatPart(PyAtHomeParser.IfStatPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#ifConditionPart}.
	 * @param ctx the parse tree
	 */
	void enterIfConditionPart(PyAtHomeParser.IfConditionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#ifConditionPart}.
	 * @param ctx the parse tree
	 */
	void exitIfConditionPart(PyAtHomeParser.IfConditionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#elifStatPart}.
	 * @param ctx the parse tree
	 */
	void enterElifStatPart(PyAtHomeParser.ElifStatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#elifStatPart}.
	 * @param ctx the parse tree
	 */
	void exitElifStatPart(PyAtHomeParser.ElifStatPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#elifConditionPart}.
	 * @param ctx the parse tree
	 */
	void enterElifConditionPart(PyAtHomeParser.ElifConditionPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#elifConditionPart}.
	 * @param ctx the parse tree
	 */
	void exitElifConditionPart(PyAtHomeParser.ElifConditionPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#elseStatPart}.
	 * @param ctx the parse tree
	 */
	void enterElseStatPart(PyAtHomeParser.ElseStatPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#elseStatPart}.
	 * @param ctx the parse tree
	 */
	void exitElseStatPart(PyAtHomeParser.ElseStatPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#nonTerminalBlock}.
	 * @param ctx the parse tree
	 */
	void enterNonTerminalBlock(PyAtHomeParser.NonTerminalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#nonTerminalBlock}.
	 * @param ctx the parse tree
	 */
	void exitNonTerminalBlock(PyAtHomeParser.NonTerminalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#terminalBlock}.
	 * @param ctx the parse tree
	 */
	void enterTerminalBlock(PyAtHomeParser.TerminalBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#terminalBlock}.
	 * @param ctx the parse tree
	 */
	void exitTerminalBlock(PyAtHomeParser.TerminalBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PyAtHomeParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PyAtHomeParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#retType}.
	 * @param ctx the parse tree
	 */
	void enterRetType(PyAtHomeParser.RetTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#retType}.
	 * @param ctx the parse tree
	 */
	void exitRetType(PyAtHomeParser.RetTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#varType}.
	 * @param ctx the parse tree
	 */
	void enterVarType(PyAtHomeParser.VarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#varType}.
	 * @param ctx the parse tree
	 */
	void exitVarType(PyAtHomeParser.VarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(PyAtHomeParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(PyAtHomeParser.TypesContext ctx);
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
	 * Enter a parse tree produced by {@link PyAtHomeParser#relOperators}.
	 * @param ctx the parse tree
	 */
	void enterRelOperators(PyAtHomeParser.RelOperatorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#relOperators}.
	 * @param ctx the parse tree
	 */
	void exitRelOperators(PyAtHomeParser.RelOperatorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#logicAndOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndOperator(PyAtHomeParser.LogicAndOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#logicAndOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndOperator(PyAtHomeParser.LogicAndOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#logicOrOperator}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrOperator(PyAtHomeParser.LogicOrOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#logicOrOperator}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrOperator(PyAtHomeParser.LogicOrOperatorContext ctx);
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
	 * Enter a parse tree produced by {@link PyAtHomeParser#funcCallExpression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpression(PyAtHomeParser.FuncCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#funcCallExpression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpression(PyAtHomeParser.FuncCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(PyAtHomeParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(PyAtHomeParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(PyAtHomeParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(PyAtHomeParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#nonIdArgs}.
	 * @param ctx the parse tree
	 */
	void enterNonIdArgs(PyAtHomeParser.NonIdArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#nonIdArgs}.
	 * @param ctx the parse tree
	 */
	void exitNonIdArgs(PyAtHomeParser.NonIdArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#idArgs}.
	 * @param ctx the parse tree
	 */
	void enterIdArgs(PyAtHomeParser.IdArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#idArgs}.
	 * @param ctx the parse tree
	 */
	void exitIdArgs(PyAtHomeParser.IdArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#argNumExpression}.
	 * @param ctx the parse tree
	 */
	void enterArgNumExpression(PyAtHomeParser.ArgNumExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#argNumExpression}.
	 * @param ctx the parse tree
	 */
	void exitArgNumExpression(PyAtHomeParser.ArgNumExpressionContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(PyAtHomeParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#integerLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(PyAtHomeParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyAtHomeParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(PyAtHomeParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyAtHomeParser#floatLiteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(PyAtHomeParser.FloatLiteralContext ctx);
}