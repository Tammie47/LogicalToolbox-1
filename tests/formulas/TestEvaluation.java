package formulas;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import de.arlab.formulas.Variable;

public class TestEvaluation {

	static Map<Variable, Boolean> assignment = new HashMap<Variable, Boolean>();

	@BeforeClass
	public static void setUpClass() {
		assignment.put(F.var1, true);
		assignment.put(F.var2, false);
		assignment.put(F.var3, true);
		assignment.put(F.var4, false);
	}

	@Test
	public void testEvaluateVerum() {
		assertTrue(F.verum.evaluate(assignment));
	}

	@Test
	public void testEvaluateFalsum() {
		assertFalse(F.falsum.evaluate(assignment));
	}

	@Test
	public void testEvaluateVariable() {
		assertTrue(F.var1.evaluate(assignment));
		assertFalse(F.var2.evaluate(assignment));
		assertTrue(F.var3.evaluate(assignment));
		assertFalse(F.var4.evaluate(assignment));
	}

	@Test
	public void testEvaluateF1() {
		assertFalse(F.f1.evaluate(assignment));
	}

	@Test
	public void testEvaluateF2() {
		assertFalse(F.f2.evaluate(assignment));
	}

	@Test
	public void testEvaluateF3() {
		assertTrue(F.f3.evaluate(assignment));
	}

	@Test
	public void testEvaluateF4() {
		assertTrue(F.f4.evaluate(assignment));
	}

	@Test
	public void testEvaluateF5() {
		assertTrue(F.f5.evaluate(assignment));
	}

	@Test
	public void testEvaluateF6() {
		assertFalse(F.f6.evaluate(assignment));
	}

	@Test
	public void testEvaluateF7() {
		assertTrue(F.f7.evaluate(assignment));
	}

	@Test
	public void testEvaluateF8() {
		assertFalse(F.f8.evaluate(assignment));
	}

	@Test
	public void testEvaluateF9() {
		assertTrue(F.f9.evaluate(assignment));
	}

	@Test
	public void testEvaluateF10() {
		assertTrue(F.f10.evaluate(assignment));
	}

	@Test
	public void testEvaluateF11() {
		assertTrue(F.f11.evaluate(assignment));
	}

	@Test
	public void testEvaluateF12() {
		assertFalse(F.f12.evaluate(assignment));
	}

	@Test
	public void testEvaluateF13() {
		assertTrue(F.f13.evaluate(assignment));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEvaluateException() {
		F.f14.evaluate(assignment);
	}
}