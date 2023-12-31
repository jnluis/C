// Generated from Hello.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#order}.
	 * @param ctx the parse tree
	 */
	void enterOrder(HelloParser.OrderContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#order}.
	 * @param ctx the parse tree
	 */
	void exitOrder(HelloParser.OrderContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(HelloParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(HelloParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#goodbyes}.
	 * @param ctx the parse tree
	 */
	void enterGoodbyes(HelloParser.GoodbyesContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#goodbyes}.
	 * @param ctx the parse tree
	 */
	void exitGoodbyes(HelloParser.GoodbyesContext ctx);
}