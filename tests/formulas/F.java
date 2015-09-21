package formulas;

import de.arlab.formulas.And;
import de.arlab.formulas.Formula;
import de.arlab.formulas.Not;
import de.arlab.formulas.Or;
import de.arlab.formulas.Variable;

public class F {
	public static final String avo1 = "(a0+a1)/-(-a1/a2+a3)";
	public static final String avo2 = "(a0+a1/a2)+(-a1/a2/-a3/b0/b1)/-(a1+-b1+-b0)+(-a3/-a1)";
	public static final String avo3 = "-((x1+x3)/-(0/x4))";
	public static final String avo4 = "-((x1+0)/x2)/x3";

	public static final Formula verum = Formula.VERUM;
	public static final Formula falsum = Formula.FALSUM;

	public static final Variable var1 = new Variable("x1");
	public static final Variable var2 = new Variable("x2");
	public static final Variable var3 = new Variable("x3");
	public static final Variable var4 = new Variable("x4");
	public static final Variable var5 = new Variable("x5");

	public static final Formula f1 = new And(var1, falsum);
	public static final Formula f2 = new Or(f1, var2);
	public static final Formula f3 = new Not(f1);
	public static final Formula f4 = new And(f3, var3);
	public static final Formula f5 = new Or(f3, verum);
	public static final Formula f6 = new Not(var1);
	public static final Formula f7 = new Not(f6);
	public static final Formula f8 = new And(f2, var1);
	public static final Formula f9 = new And(new Not(new Not(var1)), verum);
	public static final Formula f10 = new And(var1, var3);
	public static final Formula f11 = new Not(new Or(falsum, var4));
	public static final Formula f12 = new Not(new Or(f10, f11));
	public static final Formula f13 = new Or(new Not(new Or(new And(var1,
			falsum), var2)), var3);
	public static final Formula f14 = new Not(var5);
}
