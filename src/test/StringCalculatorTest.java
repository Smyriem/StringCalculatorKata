package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.StringCalculator;

public class StringCalculatorTest {
	
	private StringCalculator stringCalculator;
	
	
	@Before
	public void setUp() throws Exception {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void test_EmptyString_ShouldReturnZero() {		
		assertEquals(stringCalculator.add(""), 0);
	}
	
	@Test
	public void test_OneValue_ShouldReturnSame() {		
		assertEquals(stringCalculator.add("58"),58);
	}

}
