package mx.ipn.escom.spee.action;

public class SessionFile {
	/**
	 * Nombre del archivo que sube el usuario
	 */
	private String fileName;

	/**
	 * Nombre del archivo temporal
	 */
	private String tempFileName;

	/**
	 * Constructor sin parametrós del objeto
	 */
	public SessionFile() {
		super();
	}

	/**
	 * Constructor con parámetros
	 * 
	 * @param fileName
	 *            , hace referencia al nombre del archivo con base en el que el
	 *            usuario sube al sistema
	 * @param tempFileName
	 *            , nombre que se le asigna al archivo temporal
	 */
	public SessionFile(String fileName, String tempFileName) {
		super();
		this.fileName = fileName;
		this.tempFileName = tempFileName;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the tempFileName
	 */
	public String getTempFileName() {
		return tempFileName;
	}

	/**
	 * @param tempFileName
	 *            the tempFileName to set
	 */
	public void setTempFileName(String tempFileName) {
		this.tempFileName = tempFileName;
	}
}
