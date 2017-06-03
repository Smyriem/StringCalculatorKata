package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import exception.NegativeNumberException;
import exception.UnknownNumberException;
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
		assertEquals(stringCalculator.add("1\n2,3"), 6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_NewLineBtwValues_ShouldThrowException() {
		stringCalculator.add("1,\n");
	}

	@Test
	public void test_NegativeValues_ShouldThrowException() {
		try {
			stringCalculator.add("1,-2,-53");
		} catch (NegativeNumberException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_IgnoreBigNumbers_ShouldThrowException(){
		stringCalculator.add("2,10001");
	}
}
