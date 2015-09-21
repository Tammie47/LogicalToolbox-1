package de.arlab.formulas;

import java.util.Map;

/**
 * Class for a NOT-formula.
 */
public class Not extends Formula {
	private Formula f;

	/**
	 * Returns the operand of this Not formula.
	 * 
	 * @return operand of this Not formula
	 */
	public Formula getF() {
		return f;
	}

	/**
	 * Constructor for NOT-formula.
	 * 
	 * @param f
	 *            f of the not formula
	 */
	public Not(Formula f) {
		this.f = f;
	}

	@Override
	public boolean syntEqual(Formula form) {
		if(!(form instanceof Not)) {
			return false;
		}
		
		Not formNot = (Not) form;		
		
		return this.getF().syntEqual(formNot.getF());
	}

	@Override
	public String toString() {
		return "(" + "NOT " + f + ")";
	}

	@Override
	public boolean evaluate(Map<Variable, Boolean> assignment)
			throws IllegalArgumentException {
		return !f.evaluate(assignment);
	}

	@Override
	public Formula substitute(Variable var, Formula form) {
		// TODO to implement
		return null;
	}

	@Override
	public boolean isDNF() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isMinterm() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isLiteral() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isAtomicFormula() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isCNF() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isClause() {
		// TODO to implement
		return false;
	}

	@Override
	public boolean isNNF() {
		// TODO to implement
		return false;
	}

	@Override
	public Formula dnf() {
		// TODO to implement
		return null;
	}

	@Override
	public Formula nnf() {
		// TODO to implement
		return null;
	}

	@Override
	public Formula cnf() {
		// TODO to implement
		return null;
	}

	@Override
	public Formula simplify() {
		// TODO to implement
		return null;
	}
}