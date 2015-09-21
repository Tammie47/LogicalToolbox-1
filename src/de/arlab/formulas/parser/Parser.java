package de.arlab.formulas.parser;

import de.arlab.formulas.And;
import de.arlab.formulas.Formula;
import de.arlab.formulas.Not;
import de.arlab.formulas.Or;
import de.arlab.formulas.Variable;


/**
 * A simple formula parser.
 */
public class Parser {

  /**
   * Parses a string and converts it into a Formula object. Variables are
   * arbitrary strings beginning with a character and containing only a-z,
   * A-Z, 0-9 and _ . AND is represented by + OR by / NOT by -.
   *
   * @param s formula as string
   * @return Formula object of the input string
   * @throws IllegalArgumentException if the input string is no valid formula
   */
  public Formula parseFormula(String s) throws IllegalArgumentException {
		pos = 0;
		Formula res = parseFormula2(s);
		if (pos < s.length())
			throw new IllegalArgumentException("Unerwartetes Ende der Eingabe. pos=" + pos + "s.length" + s.length());
		return res;
	}

	private Formula parseFormula2(String s) throws IllegalArgumentException {
		int end = s.length();
		if (end == 0)
			throw new IllegalArgumentException("Keine Formel eingegeben!");
		Formula res = parseDisjunction(s);
		char current = currentChar(s);
		if (current == '#')
			return res;
		return res;
	}

	private Formula parseDisjunction(String s) throws IllegalArgumentException {
		Formula res = parseConjunction(s);
		char current = currentChar(s);
		if (current == '/') {
			nextChar(s);
			Formula g = parseDisjunction(s);
			if (!(g instanceof Or))
				res = new Or(res, g);
			else
				res = new Or(new Or(res, ((Or) g).getF1()), ((Or) g).getF2());
		}
		return res;
	}

	private Formula parseConjunction(String s) throws IllegalArgumentException {
		Formula res = parseAtom(s);
		char current = currentChar(s);
		if (current == '+') {
			nextChar(s);
			Formula g = parseConjunction(s);
			if (!(g instanceof And))
				res = new And(res, g);
			else
				res = new And(new And(res, ((And) g).getF1()), ((And) g).getF2());
		}
		return res;
	}

	private Formula parseAtom(String s) throws IllegalArgumentException {
		Formula res, g;
		char current = currentChar(s);
		switch (current) {
		case '-':
			nextChar(s);
			g = parseAtom(s);
			res = new Not(g);
			break;
		case '(':
			nextChar(s);
			g = parseFormula2(s);
			if (currentChar(s) == ')') {
				nextChar(s);
				res = g;
			} else
				throw new IllegalArgumentException("Fehlende schließende Klammer in Formel " + s + ".");
			break;
		case '#':
			throw new IllegalArgumentException("Unerwartetes Ende der Eingabe bei Atom.");
		case '0':
			nextChar(s);
			res = Formula.FALSUM;
			break;
		case '1':
			nextChar(s);
			res = Formula.VERUM;
			break;
		default:
			String variable = varName(s, pos);
			pos += variable.length();
			if (!isVariableName(variable))
				throw new IllegalArgumentException("Ungueltiger Variablenbezeichner '" + variable + "' in Formel " + s + ".");
			res = new Variable(variable);
			break;
		}
		return res;
	}

	private String varName(String s, int pos) {
		int i = pos;
		while (i < s.length()
				&& (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))))
			++i;
		String res = s.substring(pos, i);
		pos = i;
		return res;
	}

	private boolean isVariableName(String s) {
		char c = s.charAt(0);
		if (!Character.isLetter(c))
			return false;
		else
			return true;
	}

  private int pos = 0;

	private boolean isValidChar(char c) {
		return Character.isLetter(c) || c == '/' || c == '+' || c == '-'
				|| c == '(' || c == ')' || c == ' ' || c == '1' || c == '0';
	}

	private char nextChar(String s) throws IllegalArgumentException {
		pos++;
		if (pos < s.length()) {
			char c = s.charAt(pos);
			if (isValidChar(c))
				return c;
			else
				throw new IllegalArgumentException("Ungueltiges Zeichen " + c + " !");
		} else
			return '#';
	}

	private char currentChar(String s) throws IllegalArgumentException {
		while (pos < s.length() && s.charAt(pos) == ' ')
			pos++;
		if (pos < s.length()) {
			char c = s.charAt(pos);
			if (isValidChar(c))
				return c;
			else
				throw new IllegalArgumentException("Ungueltiges Zeichen" + c + " !");
		} else
			return '#';
	}
}
