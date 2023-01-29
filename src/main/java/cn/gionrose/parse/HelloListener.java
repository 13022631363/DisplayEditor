package cn.gionrose.parse;// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(HelloParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(HelloParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(HelloParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(HelloParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(HelloParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(HelloParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(HelloParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(HelloParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(HelloParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(HelloParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(HelloParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(HelloParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(HelloParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(HelloParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(HelloParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(HelloParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(HelloParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(HelloParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(HelloParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#forVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterForVariableDeclaration(HelloParser.ForVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#forVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitForVariableDeclaration(HelloParser.ForVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#commonVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCommonVariableDeclaration(HelloParser.CommonVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#commonVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCommonVariableDeclaration(HelloParser.CommonVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#dataType}.
	 * @param ctx the parse tree
	 */
	void enterDataType(HelloParser.DataTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#dataType}.
	 * @param ctx the parse tree
	 */
	void exitDataType(HelloParser.DataTypeContext ctx);
}