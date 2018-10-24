package mx.edu.spee.controlacceso.exception;

public class UserLimitLockedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserLimitLockedException() {
		super();
	}

	public UserLimitLockedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserLimitLockedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserLimitLockedException(String message) {
		super(message);
	}

	public UserLimitLockedException(Throwable cause) {
		super(cause);
	}
}
