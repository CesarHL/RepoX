package mx.edu.spee.controlacceso.exception;

public class DisableUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisableUserException() {
		super();
	}

	public DisableUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DisableUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public DisableUserException(String message) {
		super(message);
	}

	public DisableUserException(Throwable cause) {
		super(cause);
	}
}
