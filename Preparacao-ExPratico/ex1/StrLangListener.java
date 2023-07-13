// Generated from StrLang.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StrLangParser}.
 */
public interface StrLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StrLangParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(StrLangParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(StrLangParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignSTAT}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignSTAT(StrLangParser.AssignSTATContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignSTAT}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignSTAT(StrLangParser.AssignSTATContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printSTAT}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintSTAT(StrLangParser.PrintSTATContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printSTAT}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintSTAT(StrLangParser.PrintSTATContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InputAssign}
	 * labeled alternative in {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterInputAssign(StrLangParser.InputAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InputAssign}
	 * labeled alternative in {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitInputAssign(StrLangParser.InputAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NormalAssign}
	 * labeled alternative in {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterNormalAssign(StrLangParser.NormalAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NormalAssign}
	 * labeled alternative in {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitNormalAssign(StrLangParser.NormalAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(StrLangParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(StrLangParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pareExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPareExpr(StrLangParser.PareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pareExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPareExpr(StrLangParser.PareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code replaceExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterReplaceExpr(StrLangParser.ReplaceExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code replaceExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitReplaceExpr(StrLangParser.ReplaceExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(StrLangParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(StrLangParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trimExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterTrimExpr(StrLangParser.TrimExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trimExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitTrimExpr(StrLangParser.TrimExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(StrLangParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(StrLangParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(StrLangParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(StrLangParser.IdExprContext ctx);
}