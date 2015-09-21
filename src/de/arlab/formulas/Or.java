package de.arlab.formulas;

import java.util.Map;

/**
 * Class for an OR-formula.
 */
public class Or extends BinaryFormula {

	/**
	 * Constructor for OR-formula.
	 * 
	 * @param f1
	 *            left f in infix notation
	 * @param f2
	 *            right f in infix notation
	 */
	public Or(Formula f1, Formula f2) {
		super(f1, f2);
	}

	@Override
	public boolean syntEqual(Formula f) {
		if(!(f instanceof Or)) {
			return false;
		}
		
		Or fOr = (Or) f;
				
		return this.getF1().syntEqual(fOr.getF1()) && this.getF2().syntEqual(fOr.getF2()) ;
	}

	@Override
	public String toString() {
		return "(" + f1 + " OR " + f2 + ")";
	}

	@Override
	public boolean evaluate(Map<Variable, Boolean> assignment)
			throws IllegalArgumentException {
		return f1.evaluate(assignment) || f2.evaluate(assignment);
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
