package formulas.parser;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.arlab.formulas.parser.Parser;
import formulas.F;

public class TestParser {

	Parser parser = new Parser();

	@Test
	public void testParseFalsum() {
		String shouldBe = "0";
		assertEquals(shouldBe, parser.parseFormula("0").toString());
	}

	@Test
	public void testParseVerum() {
		String shouldBe = "1";
		assertEquals(shouldBe, parser.parseFormula("1").toString());
	}

	@Test
	public void testParseVariable() {
		String shouldBe = "x102";
		assertEquals(shouldBe, parser.parseFormula("x102").toString());
	}

	@Test
	public void testParseAVO1() {
		String shouldBe = "((a0 AND a1) OR (NOT ((NOT a1) OR (a2 AND a3))))";
		assertEquals(shouldBe, parser.parseFormula(F.avo1).toString());
	}

	@Test
	public void testParseAVO2() {
		String shouldBe = "((((a0 AND a1) OR a2) AND (((NOT a1) OR (a2 OR ((NOT a3) OR b0))) OR b1)) OR ((NOT ((a1 AND (NOT b1)) AND (NOT b0))) AND ((NOT a3) OR (NOT a1))))";
		assertEquals(shouldBe, parser.parseFormula(F.avo2).toString());
	}

	@Test
	public void testParseAVO3() {
		String shouldBe = "(NOT ((x1 AND x3) OR (NOT (0 OR x4))))";
		assertEquals(shouldBe, parser.parseFormula(F.avo3).toString());
	}

	@Test
	public void testParseAVO4() {
		String shouldBe = "((NOT ((x1 AND 0) OR x2)) OR x3)";
		assertEquals(shouldBe, parser.parseFormula(F.avo4).toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseException01() {
		parser.parseFormula("(NOT x1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testParseException02() {
		parser.parseFormula("x1 AND x2 OR");
	}
}