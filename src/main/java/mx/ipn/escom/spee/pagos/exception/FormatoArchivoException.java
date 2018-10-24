package mx.ipn.escom.spee.pagos.exception;

public class FormatoArchivoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FormatoArchivoException() {
		super();
	}

	public FormatoArchivoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FormatoArchivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public FormatoArchivoException(String message) {
		super(message);
	}

	public FormatoArchivoException(Throwable cause) {
		super(cause);
	}

}
