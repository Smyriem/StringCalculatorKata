package main;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import exception.NegativeNumberException;
import exception.UnknownNumberException;

public class StringCalculator {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEWLINE_DELIMITER = "\n";	
	private static final Pattern INPUT_PATTERN = Pattern.compile("^[\\-]?\\d+([\\,|\\n]?[\\-]?\\d+)*");

	public int add(String input) {

		String[] numbers = input.split(",|\n");

		validateInput(input);

		checkNegativeNumbers(numbers);

		return getSum(numbers);
	}

	private void validateInput(String input) {
		if (input.contains(COMMA_DELIMITER) || input.contains(NEWLINE_DELIMITER)) {			
			boolean isValidInput = INPUT_PATTERN.matcher(input).matches();
			if (!isValidInput) {
				throw new IllegalArgumentException("input not valid");
			}
		}
	}

	private int getSum(String[] numbers) {
		return getIntNumbers(numbers).sum();
	}

	private void checkNegativeNumbers(String[] numbers) {
		String negativeNumbers;
		try {
			negativeNumbers = getIntNumbers(numbers).filter(n -> n < 0).mapToObj(Integer::toString)
					.collect(Collectors.joining(","));

		} catch (NumberFormatException e) {
			throw new UnknownNumberException("unknown amount of numbers", e);
		}

		if (!negativeNumbers.isEmpty()) {
			throw new NegativeNumberException("negatives not allowed: " + negativeNumbers);
		}
	}

	private IntStream getIntNumbers(String[] numbers) {
		IntStream intStream;
		List<Integer> listNumbers;
		try {
			listNumbers = Arrays.stream(numbers).filter(this:: nonEmpty).map(Integer :: valueOf)					
							.collect(Collectors.toList());
		} catch (NumberFormatException e) {
			throw new UnknownNumberException("unknown amount of numbers", e);
		}

		if (listNumbers.stream().anyMatch(n -> n > 1000)) {
			throw new IllegalArgumentException("big numbers not allowed");
		} else {
			intStream = Arrays.stream(numbers).filter(this:: nonEmpty).mapToInt(Integer::parseInt);
		}

		return intStream;
	}

	private boolean nonEmpty(String input) {
		return !input.isEmpty();
	}

}
