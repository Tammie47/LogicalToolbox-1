package de.arlab.formulas;

import java.util.Map;

/**
 * Abstract class for formulas of propositional logic.
 */
public abstract class Formula {
	public static final Formula VERUM = Verum.mk();
	public static final Formula FALSUM = Falsum.mk();

	/**
	 * Formula as a String.
	 * 
	 * @return a string representation of this formula
	 */
	abstract public String toString();

	/**
	 * Test if two formulas are syntactically equal. Note: This is not a test
	 * for semantically equality.
	 * 
	 * @param f
	 *            formula to compare with
	 * @return true if the given formula is syntactically equal to this formula,
	 *         false otherwise
	 */
	abstract public boolean syntEqual(Formula f);

	/**
	 * Evaluate a Formula with the given variable assignment.
	 * 
	 * @param assignment
	 *            mapping between variables and truth values
	 * @return true or false
	 * @throws IllegalArgumentException
	 *             if a variable was not assigned
	 */
	abstract public boolean evaluate(Map<Variable, Boolean> assignment)
			throws IllegalArgumentException;

	/**
	 * Substitute a variable with a formula.
	 * 
	 * @param var
	 *            variable to substitute
	 * @param form
	 *            formula to place in
	 * @return substituted formula
	 */
	abstract public Formula substitute(Variable var, Formula form);

	/**
	 * Test if the formula is a literal. A literal is an atomic formula or the
	 * negation of an atomic formula.
	 * 
	 * @return true if formula is a literal, false otherwise
	 */
	abstract public boolean isLiteral();

	/**
	 * Test if the formula is an atomic formula. An atomic formula is a
	 * variable, verum or bottom.
	 * 
	 * @return true if formula is atomic, false otherwise
	 */
	abstract public boolean isAtomicFormula();

	/**
	 * Test if the formula is a clause.
	 * 
	 * @return true if formula is a clause, false otherwise
	 */
	abstract public boolean isClause();

	/**
	 * Test if the formula is a minterm.
	 * 
	 * @return true if formula is a minterm, false otherwise
	 */
	abstract public boolean isMinterm();

	/**
	 * Test if the formula is in NNF (Negation Normal Form).
	 * 
	 * @return true if formula is in NNF, false otherwise
	 */
	abstract public boolean isNNF();

	/**
	 * Test if the formula is in CNF (Conjunctive Normal Form).
	 * 
	 * @return true if formula is in CNF, false otherwise
	 */
	abstract public boolean isCNF();

	/**
	 * Test if the formula is in DNF (Disjunctive Normal Form).
	 * 
	 * @return true if formula is in DNF, false otherwise
	 */
	abstract public boolean isDNF();

	/**
	 * Compute an equivalent formula in NNF.
	 * 
	 * @return equivalent formula in NNF
	 */
	abstract public Formula nnf();

	/**
	 * Compute an equivalent formula in CNF.
	 * 
	 * @return equivalent formula in CNF
	 */
	abstract public Formula cnf();

	/**
	 * Compute an equivalent formula in DNF.
	 * 
	 * @return equivalent formula in DNF
	 */
	abstract public Formula dnf();

	/**
	 * Simplify the formula
	 * 
	 * @return the simplified formula
	 */
	abstract public Formula simplify();

	/**
	 * Apply De Morgan laws on the formula. Note: This function will have an
	 * effect if and only if the formula has the form (NOT (s1 OR s2)) or (NOT
	 * (s1 AND s2)). For every other form, an IllegalArgumentException will be
	 * thrown.
	 * 
	 * @param not
	 *            The Formula on which to apply the De Morgan rule
	 * @return the formula with De Morgan applied
	 */
	public static Formula applyDeMorgan(Not not)
			throws IllegalArgumentException {
		// TODO to implement
		return null;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o instanceof Formula))
			return false;
		return ((Formula) o).syntEqual(this);
	}
}
