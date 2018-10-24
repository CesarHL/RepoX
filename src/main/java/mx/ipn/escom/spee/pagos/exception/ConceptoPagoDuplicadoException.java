package mx.ipn.escom.spee.pagos.exception;

public class ConceptoPagoDuplicadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConceptoPagoDuplicadoException() {
		super();
	}

	public ConceptoPagoDuplicadoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConceptoPagoDuplicadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConceptoPagoDuplicadoException(String message) {
		super(message);
	}

	public ConceptoPagoDuplicadoException(Throwable cause) {
		super(cause);
	}

}
