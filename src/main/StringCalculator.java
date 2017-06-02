package main;

public class StringCalculator {

	public int add(String input) {
		
		if(isEmpty(input)){
			return 0;
		}
		return convertStringToInt(input);
	}

	private boolean isEmpty(String input) {		
		return input.isEmpty();
	}

	private int convertStringToInt(String input) {
		return Integer.parseInt(input);
	}

}
