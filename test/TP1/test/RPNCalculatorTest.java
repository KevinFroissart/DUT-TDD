package TP1.test;

import TP1.RPNCalculator;
import static org.junit.Assert.*;
import org.junit.Test;

public class RPNCalculatorTest {

	private static final double DELTA7 = 0.0000001;
	private static final double DELTA4 = 0.0001;
	
	@Test
	public void testConstructor() {
		RPNCalculator test = new RPNCalculator();
	}

	@Test
	public void should_add_numbers() {
		assertEquals(2, RPNCalculator.eval("1 1 +"), DELTA7);
		assertEquals(10, RPNCalculator.eval("7 3 +"), DELTA7);
		assertEquals(22, RPNCalculator.eval("9 13 +"), DELTA7);
		assertEquals(15.2, RPNCalculator.eval("13.9 1.3 +"), DELTA7);
	}

	@Test
	public void should_substract_numbers() {
		assertEquals(3, RPNCalculator.eval("4 1 -"), DELTA7);
		assertEquals(-2, RPNCalculator.eval("7 9 -"), DELTA7);
		assertEquals(127.7, RPNCalculator.eval("139.7 12 -"), DELTA7);
	}

    @Test
    public void should_do_multiple_operations() {
        assertEquals(9, RPNCalculator.eval("1 2 + 6 +"), DELTA7);
        assertEquals(5, RPNCalculator.eval("7 3 5 - +"), DELTA7);
    }
    
    @Test
    public void should_multiply_numbers() {
        assertEquals(4, RPNCalculator.eval("2 2 *"), DELTA7);
        assertEquals(4.5, RPNCalculator.eval("9 0.5 *"), DELTA7);
        assertEquals(1494.9, RPNCalculator.eval("1359 1.1 *"), DELTA7);
        assertEquals(25, RPNCalculator.eval("7 3 * 4 +"), DELTA7);
        assertEquals(19, RPNCalculator.eval("7 3 4 * +"), DELTA7);
    }

	@Test
	public void should_divide_numbers() {
		assertEquals(0.5, RPNCalculator.eval("2 4 /"), DELTA7);
		assertEquals(6.4666, RPNCalculator.eval("19.4 3 /"), DELTA4);
		assertEquals(8, RPNCalculator.eval("18 3 / 2 +"), DELTA7);
		assertEquals(16.5, RPNCalculator.eval("18 3 2 / -"), DELTA7);
	}
	
	@Test
	public void should_square_numbers() {
		 assertEquals(4, RPNCalculator.eval("16 SQRT"), DELTA7);
	     assertEquals(10, RPNCalculator.eval("25 SQRT 2 *"), DELTA7);
	     assertEquals(5, RPNCalculator.eval("49 SQRT 3 + 2 /"), DELTA7);
	}
}