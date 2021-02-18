// Generated from Calc1.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Calc1Parser}.
 */
public interface Calc1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Calc1Parser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(Calc1Parser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calc1Parser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(Calc1Parser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link Calc1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(Calc1Parser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Calc1Parser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(Calc1Parser.ExprContext ctx);
}