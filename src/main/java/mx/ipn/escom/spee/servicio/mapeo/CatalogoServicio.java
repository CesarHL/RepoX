package mx.ipn.escom.spee.servicio.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tc02_catalogo_servicio")
public class CatalogoServicio implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_catalogo_servicio")
	private Integer id;

	@Column(name = "tx_clave")
	private String clave;

	@Column(name = "ds_servicio")
	private String descripcion;

	@Column(name = "precio")
	private String precio;

	@Column(name = "id_area")
	private Integer idArea;

	@Column(name = "id_tipo_servicio")
	private String idTipoServicio;

	public CatalogoServicio() {
		super();
	}

	public CatalogoServicio(Integer id, String clave, String descripcion, String precio, Integer idArea,
			String idTipoServicio) {
		super();
		this.id = id;
		this.clave = clave;
		this.descripcion = descripcion;
		this.precio = precio;
		this.idArea = idArea;
		this.idTipoServicio = idTipoServicio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(String idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

}
