package formulas;

import static org.junit.Assert.*;

import org.junit.Test;

import de.arlab.formulas.Falsum;
import de.arlab.formulas.Formula;
import de.arlab.formulas.Verum;

public class TestSyntEqual {

	@Test
	public void testSyntEqualVerum() {
		assertTrue(F.verum.syntEqual(Verum.mk()));
		assertFalse(F.verum.syntEqual(Falsum.mk()));
	}
	@Test
	public void testSyntEqualFalsum() {
		assertTrue(F.falsum.syntEqual(F.falsum));
		assertFalse(F.falsum.syntEqual(F.verum));
	}

	@Test
	public void testSyntEqualNot() {
		assertFalse(F.f6.syntEqual(F.falsum));
		assertFalse(F.f6.syntEqual(F.verum));
		assertFalse(F.f6.syntEqual(F.f13));

		assertTrue(F.f6.syntEqual(F.f6));
		assertFalse(F.f6.syntEqual(F.f6a));

		assertFalse(F.f12.syntEqual(F.f1));
		assertTrue(F.f12.syntEqual(F.f12));
		
	}

	@Test
	public void testSyntEqualOr() {
		assertTrue(F.f2.syntEqual(F.f2));
		assertTrue(F.f13.syntEqual(F.f13));
		assertFalse(F.f13.syntEqual(F.f12));
		assertFalse(F.f13.syntEqual(F.f5));
		assertFalse(F.f13.syntEqual(F.f7));
		assertFalse(F.f13.syntEqual(F.f9));
		assertFalse(F.f13.syntEqual(F.f1));
	}
	@Test	
	public void testSyntEqualAnd() {

		assertTrue(F.f1.syntEqual(F.f1));
		assertTrue(F.f9.syntEqual(F.f9));
		assertFalse(F.f9.syntEqual(F.f1));
		assertFalse(F.f9.syntEqual(F.f5));
		assertFalse(F.f9.syntEqual(F.f6));
		assertFalse(F.f9.syntEqual(F.f11));
		assertFalse(F.f9.syntEqual(F.f13));
		assertFalse(F.f9.syntEqual(F.f14));
		
	}
}
