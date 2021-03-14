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
	 * Enter a parse tree produced by {@link CalculetteParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(CalculetteParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(CalculetteParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#cast}.
	 * @param ctx the parse tree
	 */
	void enterCast(CalculetteParser.CastContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#cast}.
	 * @param ctx the parse tree
	 */
	void exitCast(CalculetteParser.CastContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#preparenthesis}.
	 * @param ctx the parse tree
	 */
	void enterPreparenthesis(CalculetteParser.PreparenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#preparenthesis}.
	 * @param ctx the parse tree
	 */
	void exitPreparenthesis(CalculetteParser.PreparenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(CalculetteParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(CalculetteParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#ifElseInstr}.
	 * @param ctx the parse tree
	 */
	void enterIfElseInstr(CalculetteParser.IfElseInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#ifElseInstr}.
	 * @param ctx the parse tree
	 */
	void exitIfElseInstr(CalculetteParser.IfElseInstrContext ctx);
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
	 * Enter a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(CalculetteParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(CalculetteParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(CalculetteParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculetteParser#returnInstr}.
	 * @param ctx the parse tree
	 */
	void enterReturnInstr(CalculetteParser.ReturnInstrContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculetteParser#returnInstr}.
	 * @param ctx the parse tree
	 */
	void exitReturnInstr(CalculetteParser.ReturnInstrContext ctx);
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