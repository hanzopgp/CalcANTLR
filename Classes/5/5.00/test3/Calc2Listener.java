// Generated from Calc2.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Calc2Parser}.
 */
public interface Calc2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Calc2Parser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(Calc2Parser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calc2Parser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(Calc2Parser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Calc2Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calc2Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Calc2Parser.ExprContext ctx);
}