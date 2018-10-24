package mx.ipn.escom.spee.pagos.exception;

public class TamanioArchivoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TamanioArchivoException() {
		super();
	}

	public TamanioArchivoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TamanioArchivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TamanioArchivoException(String message) {
		super(message);
	}

	public TamanioArchivoException(Throwable cause) {
		super(cause);
	}

}
