package mx.ipn.escom.spee.action;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Transient;

public class Archivo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2778629277334743838L;

	/**
	 * Atributo transient que contiene al archivo que se adjunta al anexo
	 */
	@Transient
	private File fileUpload;

	/**
	 * Atributo transient que guarda el nombre del archivo que se adjunta
	 */
	@Transient
	private String fileUploadFileName;

	/**
	 * Atributo transient que guarda el tipo de formato del archivo que se
	 * adjunta
	 */
	@Transient
	private String fileUploadContentType;

	/**
	 * Especifica si el archivo se encuentra en sessión
	 */
	@Transient
	private Boolean inSession;

	/**
	 * Constructor sin parámetros
	 */
	public Archivo() {
		super();
		this.inSession = false;
	}

	/**
	 * Obtiene el valor del atributo fileUpload.
	 * 
	 * @return fileUpload
	 */
	public File getFileUpload() {
		return fileUpload;
	}

	/**
	 * Establece el valor del atributo fileUpload.
	 *
	 * @param fileUpload
	 */
	public void setFileUpload(File fileUpload) {
		this.fileUpload = fileUpload;
	}

	/**
	 * Obtiene el valor del atributo fileUploadFileName.
	 * 
	 * @return fileUploadFileName
	 */
	public String getFileUploadFileName() {
		return fileUploadFileName;
	}

	/**
	 * Establece el valor del atributo fileUploadFileName.
	 *
	 * @param fileUploadFileName
	 */
	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}

	/**
	 * Obtiene el valor del atributo fileUploadContentType.
	 * 
	 * @return fileUploadContentType
	 */
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}

	/**
	 * Establece el valor del atributo fileUploadContentType.
	 *
	 * @param fileUploadContentType
	 */
	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}

	/**
	 * @return the inSession
	 */
	public Boolean getInSession() {
		return inSession;
	}

	/**
	 * @param inSession
	 *            the inSession to set
	 */
	public void setInSession(Boolean inSession) {
		this.inSession = inSession;
	}
}
