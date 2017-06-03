package main;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import exception.NegativeNumberException;
import exception.UnknownNumberException;

public class StringCalculator {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEWLINE_DELIMITER = "\n";
	private static final String INPUT_PATTERN = "^\\d+([\\,|\\n]?\\d+)*";

	public int add(String input) {
		if (isEmpty(input)) {
			return 0;
		}
		String[] numbers = input.split(",|\n");
		List<String> listNegativ = Arrays.stream(numbers).filter(n-> n.contains("-")).collect(Collectors.toList());
		if(!listNegativ.isEmpty()){
			throw new NegativeNumberException("negatives not allowed: "+listNegativ);
		}
		
		if (input.contains(COMMA_DELIMITER) || input.contains(NEWLINE_DELIMITER)) {
			validateInput(input);
		}
		return getSum(numbers);
	}

	private void validateInput(String input) {
		Pattern pattern = Pattern.compile(INPUT_PATTERN);
		boolean isValidInput = pattern.matcher(input).matches();
		if (!isValidInput) {
			throw new IllegalArgumentException("input not valid");
		}
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
