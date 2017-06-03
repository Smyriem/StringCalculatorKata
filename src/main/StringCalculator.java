package main;

import java.util.Arrays;

import exeption.UnknownNumberException;

public class StringCalculator {

	public int add(String input) {

		if (isEmpty(input)) {

			return 0;

		} else if (input.contains(",") || input.contains("\n")) {

			String[] numbers = input.split(",|\n");
			return getSum(numbers);

		} else

			return convertStringToInt(input);
	}

	private int getSum(String[] numbers) {
		int sum;
		sum = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
		return sum;
		
	}

	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

	private int convertStringToInt(String input) {
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new UnknownNumberException("unknown amount of numbers", e);
		}
		return number;
	}

}
