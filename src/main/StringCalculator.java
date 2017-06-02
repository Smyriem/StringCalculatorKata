package main;

public class StringCalculator {

	public int add(String input) {

		if (isEmpty(input)) {
			
			return 0;
			
		} else if (input.contains(",")) {
			
			String[] numbers = input.split(",");
			return getSum(numbers);

		} else

			return convertStringToInt(input);
	}

	private int getSum(String[] numbers) {
		return convertStringToInt(numbers[0]) + convertStringToInt(numbers[1]);
	}

	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

	private int convertStringToInt(String input) {
		return Integer.parseInt(input);
	}

}
