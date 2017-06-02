package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.StringCalculator;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;
	Exception exception;

	@Before
	public void setUp() throws Exception {
		stringCalculator = new StringCalculator();
		String message = "unknown amount of numbers";
		exception = new Exception(message);
	}

	@Test
	public void test_EmptyString_ShouldReturnZero() {
		assertEquals(stringCalculator.add(""), 0);
	}

	@Test
	public void test_OneValue_ShouldReturnSame() {
		assertEquals(stringCalculator.add("58"), 58);
	}

	@Test
	public void test_TwoValuesWithComma_ShouldReturnSum() {
		assertEquals(stringCalculator.add("8,10"), 18);
	}

	@Test
	public void test_UnkownValues_ShouldThrowException() {
		try {
			stringCalculator.add("/@@,@&&");
		} catch (Exception e) {
			assertEquals(e.getMessage(), exception.getMessage());
		}		
	}
}
