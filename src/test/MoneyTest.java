package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Dollar;
import application.Money;
import application.Yen;

class MoneyTest {

	private Money dol;
	private Money yen;

	@BeforeEach
	void initialisation() {
		dol = new Dollar();
		yen = new Yen();
	}

	@Test
	void testConversion() {
		// convertir 15 euros en dollars
		assertEquals(dol.conversion(15), 17.7);

		// convertir 12.65 euros en dollars
		assertEquals(dol.conversion(12.65), 14.93);

		// convertir -0.9 euros en dollars
		// TODO : conversion négative Message d'erreur
		assertEquals(dol.conversion(-0.9), -1.06);

		// convertir 0 euros en dollars
		assertEquals(dol.conversion(0), 0);

		// convertir 10 euros en yen
		assertEquals(yen.conversion(10), 1292.5);

		// convertir 28.32 euros en yen
		assertEquals(yen.conversion(28.32), 3660.36);

		// convertir -0.87 euros en yen
		// TODO : conversion négative Message d'erreur
		assertEquals(yen.conversion(-0.87), -112.45);

		// convertir 0 euros en yen
		assertEquals(yen.conversion(0), 0);

	}

	@Test
	void testGetRate() {
		// obtenir taux du dollar
		assertEquals(dol.getRate(), 1.18);

		// obtenir taux du yen
		assertEquals(yen.getRate(), 129.25);

	}

	@Test
	void testSetRate() {
		// test de changement du taux du dollar
		dol.setRate(5);
		assertEquals(dol.getRate(), 5);

		// test de changement du taux du yen
		yen.setRate(3.5);
		assertEquals(yen.getRate(), 3.5);

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
