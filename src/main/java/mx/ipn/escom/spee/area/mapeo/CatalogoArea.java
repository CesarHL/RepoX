package mx.ipn.escom.spee.area.mapeo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.ipn.escom.spee.servicio.mapeo.CatalogoServicio;
import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tc01_catalogo_area")
public class CatalogoArea implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	public enum CatalogoAreaEnum {

		CELEX(1, "Centro de Lenguas Extrangeras"),

		DENTALES(2, "Servicios Dentales"),

		FOTOCOPIADO(3, "Servicios Fotocopiado"),

		BIBLIOTECA(4, "Servicios Biblioteca");

		private Integer idArea;

		private String nombre;

		private CatalogoAreaEnum(Integer idEstatus, String nombre) {
			this.idArea = idEstatus;
			this.nombre = nombre;
		}

		public Integer getIdEstatus() {
			return idArea;
		}

		public String getNombre() {
			return nombre;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_area")
	private Integer id;

	@Column(name = "nb_area")
	private String nombreArea;

	@Column(name = "ds_descripcion")
	private String descripcion;

	@Column(name = "st_activa")
	private Boolean estatus;

	@Column(name = "responsable")
	private Integer idResponsable;
	
	@OneToOne
	@JoinColumn(name = "responsable", referencedColumnName = "id_cuenta", insertable = false, updatable = false)
	private Cuenta cuenta;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<CatalogoServicio> servicios;
	
	public CatalogoArea() {
		super();
	}

	public CatalogoArea(Integer id, String nombreArea, String descripcion) {
		super();
		this.id = id;
		this.nombreArea = nombreArea;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(message = "Campo Obligatorio", type = ValidatorType.FIELD) }, requiredFields = {
					@RequiredFieldValidator(message = "Campo Obligatorio", type = ValidatorType.FIELD) }, stringLengthFields = {
							@StringLengthFieldValidator(maxLength = "25", minLength = "3", trim = true, message = "El nombre del área debe ser menor o igual a 25 caracteres") })
	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstatus() {
		return estatus;
	}

	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}

	@Validations(requiredFields = {
			@RequiredFieldValidator(message = "Campo Obligatorio", type = ValidatorType.FIELD) })
	public Integer getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}
	
	@Override
	public String toString() {
		return getNombreArea();
	}

}
