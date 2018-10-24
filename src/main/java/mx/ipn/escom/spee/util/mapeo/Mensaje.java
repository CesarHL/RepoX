/**
 * 
 */
package mx.ipn.escom.spee.util.mapeo;

import java.util.List;

public class Mensaje {

	public enum EnumTipoMensaje {
		FIELD_ERROR(1), ACTION_MESSAGE(2), ACTION_ERROR(3);

		private Integer id;

		private EnumTipoMensaje(Integer id) {
			this.id = id;
		}

		public Integer getId() {
			return id;
		}
	}

	private EnumTipoMensaje enumTipoMensaje;

	private String nombre;

	private List<String> mensajes;

	public Mensaje() {
		super();
	}

	public Mensaje(EnumTipoMensaje enumTipoMensaje, String nombre, List<String> mensajes) {
		super();
		this.enumTipoMensaje = enumTipoMensaje;
		this.nombre = nombre;
		this.mensajes = mensajes;
	}

	/**
	 * @return the enumTipoMensaje
	 */
	public EnumTipoMensaje getEnumTipoMensaje() {
		return enumTipoMensaje;
	}

	/**
	 * @param enumTipoMensaje the enumTipoMensaje to set
	 */
	public void setEnumTipoMensaje(EnumTipoMensaje enumTipoMensaje) {
		this.enumTipoMensaje = enumTipoMensaje;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the mensajes
	 */
	public List<String> getMensajes() {
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public void setMensajes(List<String> mensajes) {
		this.mensajes = mensajes;
	}

}
