package mx.ipn.escom.spee.mail.model;

import java.util.Date;

/**
 * modelo que contien lo necesario para enviar el correo
 * 
 * @author emeth
 *
 */
public class ReporteError {

	/**
	 * Url donde se manifiesta el error
	 */
	private String url;
	/**
	 * Trama completa indicando el error que se ha manifestado
	 */
	private String traza;
	/**
	 * Fecha en la cual se manifestó el error
	 */
	private Date fecha;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTraza() {
		return traza;
	}

	public void setTraza(String traza) {
		this.traza = traza;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
