package mx.edu.spee.controlacceso.exception;

public class UserDuplicatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDuplicatedException() {
		super();
	}

	public UserDuplicatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDuplicatedException(String message) {
		super(message);
	}

	public UserDuplicatedException(Throwable cause) {
		super(cause);
	}
}
