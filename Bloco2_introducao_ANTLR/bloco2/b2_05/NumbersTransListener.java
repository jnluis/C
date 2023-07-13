// Generated from NumbersTrans.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NumbersTransParser}.
 */
public interface NumbersTransListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NumbersTransParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NumbersTransParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NumbersTransParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NumbersTransParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LineAssoc}
	 * labeled alternative in {@link NumbersTransParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineAssoc(NumbersTransParser.LineAssocContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LineAssoc}
	 * labeled alternative in {@link NumbersTransParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineAssoc(NumbersTransParser.LineAssocContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LineEmpty}
	 * labeled alternative in {@link NumbersTransParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLineEmpty(NumbersTransParser.LineEmptyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LineEmpty}
	 * labeled alternative in {@link NumbersTransParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLineEmpty(NumbersTransParser.LineEmptyContext ctx);
}