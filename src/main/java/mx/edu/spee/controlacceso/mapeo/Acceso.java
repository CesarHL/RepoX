package mx.edu.spee.controlacceso.mapeo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tau04_acceso")
public class Acceso implements Modelo {
	/**
	 * Identificador del usuario al que está asociada la información de acceso
	 */
	@Id
	@Column(name = "id_usuario")
	private Integer idUsuario;
	/**
	 * Número de intentos fallidos de {@link Usuario} al que pertenece la
	 * cuenta.
	 */
	@Column(name = "nu_intento")
	private Integer intentoFallidos;

	/**
	 * Fecha del último intento fallido de ingreso al sistema. Si la fecha =
	 * null quiere decir que el {@link Usuario} nunca se ha equivocado al
	 * autenticarse en el sistema.
	 */
	@Column(name = "fh_intento")
	private Date ultimoIntento;

	/**
	 * Estampa de tiempo en la que el {@link Usuario} alcanzó el límite de
	 * intentos fallidos permitidos al autenticarse en el sistema, por lo cual
	 * es la estampa de tiempo en el que la cuenta fue bloqueda.
	 */
	@Column(name = "fh_bloqueo")
	private Date bloqueo;

	/**
	 * @return the idUsuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the intentoFallidos
	 */
	public Integer getIntentoFallidos() {
		return intentoFallidos;
	}

	/**
	 * @param intentoFallidos the intentoFallidos to set
	 */
	public void setIntentoFallidos(Integer intentoFallidos) {
		this.intentoFallidos = intentoFallidos;
	}

	/**
	 * @return the ultimoIntento
	 */
	public Date getUltimoIntento() {
		return ultimoIntento;
	}

	/**
	 * @param ultimoIntento the ultimoIntento to set
	 */
	public void setUltimoIntento(Date ultimoIntento) {
		this.ultimoIntento = ultimoIntento;
	}

	/**
	 * @return the bloqueo
	 */
	public Date getBloqueo() {
		return bloqueo;
	}

	/**
	 * @param bloqueo the bloqueo to set
	 */
	public void setBloqueo(Date bloqueo) {
		this.bloqueo = bloqueo;
	}
}
