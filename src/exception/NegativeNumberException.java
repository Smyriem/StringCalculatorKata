package exception;

public class NegativeNumberException extends RuntimeException {

	private static final long serialVersionUID = 7088479152288694425L;

	public NegativeNumberException() {
	}

	public NegativeNumberException(String message) {
		super(message);
	}

	public NegativeNumberException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
