// Generated from Hello.g4 by ANTLR 4.12.0
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
	 * Visit a parse tree produced by {@link HelloParser#order}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrder(HelloParser.OrderContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(HelloParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Visit a parse tree produced by {@link HelloParser#goodbyes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoodbyes(HelloParser.GoodbyesContext ctx);
}