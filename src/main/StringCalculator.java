package main;

public class StringCalculator {

	public int add(String string) {
		if(string.isEmpty()){
			return 0;
		}
		return Integer.parseInt(string);
	}

}
