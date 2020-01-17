package TP0.test;

import TP0.FooBarQix;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

public class FooBarQixTest {
	
	@Test
	public void testConstructeur() {
		FooBarQix test = new FooBarQix();
	}
	
	@Test
	public void testIntToString() {
		Assert.assertEquals("1", FooBarQix.intToString(1));
		Assert.assertNotEquals("salut", FooBarQix.intToString(3));
	}

	@Test
	public void testIntDivisiblePar3() {
		Assert.assertEquals("Foo", FooBarQix.intToString(3));
		Assert.assertEquals("Foo", FooBarQix.intToString(78));
	}
	
	@Test
	public void testIntDivisiblePar5() {
		Assert.assertEquals("Bar", FooBarQix.intToString(5));
		Assert.assertEquals("Bar", FooBarQix.intToString(80));
	}
	
	@Test
	public void testIntDivisiblePar7() {
		Assert.assertEquals("Qix", FooBarQix.intToString(7));
		Assert.assertEquals("Qix", FooBarQix.intToString(182));
	}
}
