// Generated from H:/Projects/diplomski/py.at.home_2_x86_compiler/py.at.home_2_x86_compiler/src/main/java/evilpops/pyathome_2_x86/_migration/grammar/PyAtHome.g4 by ANTLR 4.13.1
package main.java.evilpops.pyathome_2_x86._migration.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyAtHomeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyAtHomeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PyAtHomeParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#statementsList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementsList(PyAtHomeParser.StatementsListContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PyAtHomeParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#simpleStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(PyAtHomeParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#compundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompundStatement(PyAtHomeParser.CompundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#assignStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStatement(PyAtHomeParser.AssignStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(PyAtHomeParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(PyAtHomeParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(PyAtHomeParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#functionIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionIdentifier(PyAtHomeParser.FunctionIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PyAtHomeParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#paramNonDefVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamNonDefVal(PyAtHomeParser.ParamNonDefValContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#paramDefVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDefVal(PyAtHomeParser.ParamDefValContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#functionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBlock(PyAtHomeParser.FunctionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PyAtHomeParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#retType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRetType(PyAtHomeParser.RetTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#varType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarType(PyAtHomeParser.VarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(PyAtHomeParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#numExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpression(PyAtHomeParser.NumExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#addSubOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubOperators(PyAtHomeParser.AddSubOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#mulDivOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivOperators(PyAtHomeParser.MulDivOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#relOperators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOperators(PyAtHomeParser.RelOperatorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#logicAndOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAndOperator(PyAtHomeParser.LogicAndOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#logicOrOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOrOperator(PyAtHomeParser.LogicOrOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PyAtHomeParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(PyAtHomeParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(PyAtHomeParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#nonIdArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonIdArgs(PyAtHomeParser.NonIdArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#idArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdArgs(PyAtHomeParser.IdArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyAtHomeParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(PyAtHomeParser.LiteralContext ctx);
}