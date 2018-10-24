package mx.edu.spee.controlacceso.exception;

public class UsuarioNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontradoException() {
		super();
	}

	public UsuarioNoEncontradoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsuarioNoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioNoEncontradoException(String message) {
		super(message);
	}

	public UsuarioNoEncontradoException(Throwable cause) {
		super(cause);
	}
}
