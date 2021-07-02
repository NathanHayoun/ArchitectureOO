package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.NegativeNumberException;
import model.Dollar;
import model.Money;
import model.Yen;

class MoneyTest {

	private static Money dol;
	private static Money yen;

	@BeforeEach
	void initialisation() {
		dol = new Dollar();
		yen = new Yen();
	}

	@Test
	void testConversion() throws NegativeNumberException {
		// convertir 15 euros en dollars
		assertEquals(dol.conversion(15), 17.7, 0.01);

		// convertir 12.65 euros en dollars
		assertEquals(dol.conversion(12.65), 14.93, 0.01);

		// convertir -0.9 euros en dollars
		try {
			assertEquals(dol.conversion(-0.9), -1.06, 0.01);
			fail();
		} catch (NegativeNumberException e) {

		}

		// convertir 0 euros en dollars
		assertEquals(dol.conversion(0), 0, 0.01);

		// convertir 10 euros en yen
		assertEquals(yen.conversion(10), 1292.5, 0.01);

		// convertir 28.32 euros en yen
		assertEquals(yen.conversion(28.32), 3660.36, 0.01);

		// convertir -0.87 euros en yen
		try {
			assertEquals(yen.conversion(-0.87), -112.45, 0.01);
			fail();
		} catch (NegativeNumberException e) {

		}

		// convertir 0 euros en yen
		assertEquals(yen.conversion(0), 0, 0.01);
	}

	@Test
	void testGetRate() {
		// obtenir taux du dollar
		assertEquals(dol.getRate(), 1.18, 0.01);

		// obtenir taux du yen
		assertEquals(yen.getRate(), 129.25, 0.01);

	}

	@Test
	void testSetRate() {
		// test de changement du taux du dollar
		dol.setRate(5);
		assertEquals(dol.getRate(), 5, 0.01);

		// test de changement du taux du yen
		yen.setRate(3.5);
		assertEquals(yen.getRate(), 3.5, 0.01);

	}

	@Test
	void testGetAccronym() {
		// obtenir symbole du dollar
		assertEquals(dol.getAcronym(), '$');

		// obtenir symbole du yen
		assertEquals(yen.getAcronym(), '¥');

	}

	@Test
	void testSetAccronym() {
		// test de changement du symbole du dollar
		dol.setAcronym('a');
		assertEquals(dol.getAcronym(), 'a');

		// test de changement du symbole du yen
		yen.setAcronym('b');
		assertEquals(yen.getAcronym(), 'b');

	}
}
