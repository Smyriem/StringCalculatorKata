package main;

import exeption.UnknownNumberException;

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
		int number = 0;
		try {
			number = Integer.parseInt(input);
		} catch(NumberFormatException e){
			throw new UnknownNumberException("unknown amount of numbers",e);
		}
		return number;
	}


}
