package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exeption.UnknownNumberException;
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
		assertEquals(stringCalculator.add("58"), 58);
	}

	@Test
	public void test_TwoValuesWithComma_ShouldReturnSum() {
		assertEquals(stringCalculator.add("8,10"), 18);
	}

	@Test(expected = UnknownNumberException.class)
	public void test_UnkownValues_ShouldThrowException() {
		stringCalculator.add("/@@@&&");
	}
	
	@Test
	public void test_HandleNewLineBtwValues_ShouldReturnSum() {
		assertEquals(stringCalculator.add("1\n2,3"), 18);
	}
}
