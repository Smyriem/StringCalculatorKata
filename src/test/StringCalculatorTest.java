package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.StringCalculator;

public class StringCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_EmptyString_ShouldReturnZero() {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(stringCalculator.add(""), 0);
	}

}
