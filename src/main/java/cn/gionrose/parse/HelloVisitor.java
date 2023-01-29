package cn.gionrose.parse;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HelloParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HelloVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(HelloParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(HelloParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(HelloParser.ParExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(HelloParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(HelloParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#blockStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(HelloParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(HelloParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#forControl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForControl(HelloParser.ForControlContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#forInit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInit(HelloParser.ForInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#forVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForVariableDeclaration(HelloParser.ForVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#commonVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommonVariableDeclaration(HelloParser.CommonVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#dataType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataType(HelloParser.DataTypeContext ctx);
}