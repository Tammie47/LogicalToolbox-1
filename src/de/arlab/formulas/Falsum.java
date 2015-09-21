package de.arlab.formulas;

import java.util.Map;

/**
 * Class for the constant false.
 */
public class Falsum extends Formula {

	private static final Falsum instance = new Falsum();

	/**
	 * Private constructor for singleton pattern.
	 */
	private Falsum() {
	}

	/**
	 * Returns the single instance of the Falsum class.
	 * 
	 * @return Falsum object
	 */
	public static Falsum mk() {
		return instance;
	}

	@Override
	public boolean syntEqual(Formula f) {
		// TODO to implement
		return this.evaluate(null) == f.evaluate(null);
	}

	@Override
	public String toString() {
		return "0";
	}

	@Override
	public boolean evaluate(Map<Variable, Boolean> assignment)
			throws IllegalArgumentException {
		return false;
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
