// Generated from skeleton.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link skeletonParser}.
 */
public interface skeletonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link skeletonParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(skeletonParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link skeletonParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(skeletonParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link skeletonParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(skeletonParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skeletonParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(skeletonParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link skeletonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(skeletonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skeletonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(skeletonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link skeletonParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(skeletonParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link skeletonParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(skeletonParser.FinInstructionContext ctx);
}