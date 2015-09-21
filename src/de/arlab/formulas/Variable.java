package de.arlab.formulas;

import java.util.Map;

/**
 * Class for a variable-formula.
 */
public class Variable extends Formula implements Comparable<Variable> {
	private String name;

	/**
	 * Returns the name of this variable.
	 * 
	 * @return name of the variable
	 */
	public String getName() {
		return name;
	}

	/**
	 * Constructor for a Variable.
	 * 
	 * @param name
	 *            name of the variable
	 */
	public Variable(String name) {
		this.name = name;
	}

	@Override
	public boolean syntEqual(Formula f) {
		// TODO to implement
		return false;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public boolean evaluate(Map<Variable, Boolean> assignment)
			throws IllegalArgumentException {
		if (!assignment.containsKey(this))
			throw new IllegalArgumentException("Variable " + this
					+ " was not assigned.");
		return assignment.get(this);
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

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public int compareTo(Variable v) {
		return this.getName().compareTo(v.getName());
	}
}