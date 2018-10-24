package mx.edu.spee.controlacceso.exception;

public class UserLockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserLockedException() {
		super();
	}

	public UserLockedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserLockedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserLockedException(String message) {
		super(message);
	}

	public UserLockedException(Throwable cause) {
		super(cause);
	}

}
