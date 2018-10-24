package mx.edu.spee.controlacceso.mapeo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tau03_cuenta")
public class Cuenta implements Modelo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuenta")
	private Integer idCuenta;

	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "id_perfil")
	private Integer idPerfil;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", insertable = false, updatable = false)
	private Perfil perfil;	
	
	@Column(name = "st_activa")
	private Boolean estatus;

	public Cuenta() {
		super();
	}

	public Cuenta(Integer idCuenta) {
		super();
		this.idCuenta = idCuenta;
	}

	public Cuenta(Integer idCuenta, Integer idUsuario, Perfil perfil) {
		super();
		this.idCuenta = idCuenta;
		this.idUsuario = idUsuario;
		this.perfil = perfil;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	
	


}
