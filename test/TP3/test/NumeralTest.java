package TP3.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import TP3.Numeral;

public class NumeralTest {
	
	@Test
	public void should_handle_units() {
		assertEquals(new Numeral("1").toLetters(), "Un");
		assertEquals(new Numeral("7").toLetters(), "Sept");
	}
	
	@Test
	public void should_handle_dozens() {
		assertEquals(new Numeral("10").toLetters(), "Dix");
		assertEquals(new Numeral("18").toLetters(), "Dix-huit");
	}
	
	@Test
	public void should_handle_other_dozens() {
		assertEquals(new Numeral("41").toLetters(), "Quarante et un");
		assertEquals(new Numeral("39").toLetters(), "Trente-neuf");
		assertEquals(new Numeral("63").toLetters(), "Soixante-trois");
		assertEquals(new Numeral("98").toLetters(), "Quatre-vingt-dix-huit");
		assertEquals(new Numeral("96").toLetters(), "Quatre-vingt-seize");
	}
	
	@Test
	public void should_handle_other_hundreds() {
		assertEquals(new Numeral("100").toLetters(), "Cent");
		assertEquals(new Numeral("200").toLetters(), "Deux cents");
		assertEquals(new Numeral("375").toLetters(), "Trois cent soixante-quinze");
	}	
}