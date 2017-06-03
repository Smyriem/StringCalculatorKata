package main;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exeption.UnknownNumberException;

public class StringCalculator {

	public int add(String input) {
		if (isEmpty(input)) {
			return 0;
		}
		if (input.contains(",") || input.contains("\n")) {
			String patternInput = "^\\d+([\\,|\\n]?\\d+)*";
			Pattern pattern = Pattern.compile(patternInput);
			Matcher matcher = pattern.matcher(input);
			boolean isValid = matcher.matches();
			if (!isValid) {
				throw new IllegalArgumentException("input not valid");
			}
		}

		String[] numbers = input.split(",|\n");
		return getSum(numbers);
	}

	private int getSum(String[] numbers) {
		int sum;
		try {
			sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
		} catch (NumberFormatException e) {
			throw new UnknownNumberException("unknown amount of numbers", e);
		}
		return sum;
	}

	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

}
