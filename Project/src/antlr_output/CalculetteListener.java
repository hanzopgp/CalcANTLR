// Generated from Calculette.g4 by ANTLR 4.9
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculetteParser}.
 */
public interface CalculetteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void enterCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#calcul}.
	 * @param ctx the parse tree
	 */
	void exitCalcul(CalculetteParser.CalculContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(CalculetteParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(CalculetteParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(CalculetteParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculetteParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculetteParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#branchement}.
	 * @param ctx the parse tree
	 */
	void enterBranchement(CalculetteParser.BranchementContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#branchement}.
	 * @param ctx the parse tree
	 */
	void exitBranchement(CalculetteParser.BranchementContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#inputInstr}.
	 * @param ctx the parse tree
	 */
	void enterInputInstr(CalculetteParser.InputInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#inputInstr}.
	 * @param ctx the parse tree
	 */
	void exitInputInstr(CalculetteParser.InputInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#outputInstr}.
	 * @param ctx the parse tree
	 */
	void enterOutputInstr(CalculetteParser.OutputInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#outputInstr}.
	 * @param ctx the parse tree
	 */
	void exitOutputInstr(CalculetteParser.OutputInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#loopInstr}.
	 * @param ctx the parse tree
	 */
	void enterLoopInstr(CalculetteParser.LoopInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#loopInstr}.
	 * @param ctx the parse tree
	 */
	void exitLoopInstr(CalculetteParser.LoopInstrContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#conditionAvecLogique}.
	 * @param ctx the parse tree
	 */
	void enterConditionAvecLogique(CalculetteParser.ConditionAvecLogiqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#conditionAvecLogique}.
	 * @param ctx the parse tree
	 */
	void exitConditionAvecLogique(CalculetteParser.ConditionAvecLogiqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(CalculetteParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CalculetteParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CalculetteParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void enterAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#assignation}.
	 * @param ctx the parse tree
	 */
	void exitAssignation(CalculetteParser.AssignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void enterFinInstruction(CalculetteParser.FinInstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#finInstruction}.
	 * @param ctx the parse tree
	 */
	void exitFinInstruction(CalculetteParser.FinInstructionContext ctx);
}