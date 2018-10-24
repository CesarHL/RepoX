package mx.ipn.escom.spee.pagos.exception;

public class FolioDuplicadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FolioDuplicadoException() {
		super();
	}

	public FolioDuplicadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FolioDuplicadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public FolioDuplicadoException(String message) {
		super(message);
	}

	public FolioDuplicadoException(Throwable cause) {
		super(cause);
	}

}
