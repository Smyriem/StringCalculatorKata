package exception;

public class UnknownNumberException extends RuntimeException {

	private static final long serialVersionUID = 7088479152288694425L;

	public UnknownNumberException() {

	}

	public UnknownNumberException(String message) {
		super(message);
	}

	public UnknownNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
