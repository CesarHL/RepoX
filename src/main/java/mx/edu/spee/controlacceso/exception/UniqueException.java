package mx.edu.spee.controlacceso.exception;

public class UniqueException extends Exception {
	private static final long serialVersionUID = 1L;

	public UniqueException() {
		super();
	}

	public UniqueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UniqueException(String message, Throwable cause) {
		super(message, cause);
	}

	public UniqueException(String message) {
		super(message);
	}

	public UniqueException(Throwable cause) {
		super(cause);
	}

}
