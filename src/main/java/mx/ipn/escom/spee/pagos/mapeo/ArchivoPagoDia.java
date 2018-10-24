package mx.ipn.escom.spee.pagos.mapeo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import mx.ipn.escom.spee.servicio.mapeo.CatalogoServicio;
import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tp01_pago_dia")
public class ArchivoPagoDia implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pago_dia")
	private Integer id;

	@Column(name = "tx_archivo")
	private byte[] archivo;

	@Column(name = "fh_envio")
	private Date fechaEnvio;

	@Column(name = "id_tipo_comprobante")
	private Integer idTipoComprobante;

	@Column(name = "id_catalogo_servicio")
	private Integer idCatalogoServicio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_catalogo_servicio", referencedColumnName = "id_catalogo_servicio", insertable = false, updatable = false)
	private CatalogoServicio catalogoServicio;

	@Column(name = "id_estado_pago")
	private Integer idEstadoPago;

	@Column(name = "id_cuenta")
	private Integer idUsuario;

	@Column(name = "id_carpeta")
	private Integer idCarpeta;

	@Column(name = "folio_operacion")
	private String folioOperacion;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
//	private Usuario usuario;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "id_estado", referencedColumnName = "id_estado", insertable = false, updatable = false)
//	private EstadoPago estadoArchivo;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_area", referencedColumnName = "id_area_pago", insertable = false, updatable = false)
//	private CatalogoArea catalogoArea;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_catalogo_servicios", referencedColumnName = "id_catalogo", insertable = false, updatable = false)
//	private CatalogoServicio catalogoServicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public CatalogoServicio getCatalogoServicio() {
		return catalogoServicio;
	}

	public void setCatalogoServicio(CatalogoServicio catalogoServicio) {
		this.catalogoServicio = catalogoServicio;
	}

	public Integer getIdCarpeta() {
		return idCarpeta;
	}

	public void setIdCarpeta(Integer idCarpeta) {
		this.idCarpeta = idCarpeta;
	}

	public Integer getIdTipoComprobante() {
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}

	public Integer getIdEstadoPago() {
		return idEstadoPago;
	}

	public void setIdEstadoPago(Integer idEstadoPago) {
		this.idEstadoPago = idEstadoPago;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdCatalogoServicio() {
		return idCatalogoServicio;
	}

	public void setIdCatalogoServicio(Integer idCatalogoServicio) {
		this.idCatalogoServicio = idCatalogoServicio;
	}

	public String getFolioOperacion() {
		return folioOperacion;
	}

	public void setFolioOperacion(String folioOperacion) {
		this.folioOperacion = folioOperacion;
	}

}
