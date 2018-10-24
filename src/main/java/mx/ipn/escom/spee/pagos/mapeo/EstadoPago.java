package mx.ipn.escom.spee.pagos.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tp02_estado_pago")
public class EstadoPago implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	public enum EstadoPagoEnum {

		AUTORIZADO(1, "Pago Autorizado"),

		REVISION(2, "Pago en Revision"),

		RECHAZADO(3, "Pago Rechazado");

		private Integer idEstatus;

		private String nombre;

		private EstadoPagoEnum(Integer idEstatus, String nombre) {
			this.idEstatus = idEstatus;
			this.nombre = nombre;
		}

		public Integer getIdEstatus() {
			return idEstatus;
		}

		public String getNombre() {
			return nombre;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_pago")
	private Integer id;

	@Column(name = "nb_estado_pago")
	private String nombreEstadoPago;
	
	@Column(name = "ds_descripcion")
	private String descripcionPago;
	
	@Column(name = "st_actvo")
	private Boolean estadoPago;
	
//	@OneToMany(mappedBy = "estadoArchivo")
//	private List<ArchivoPagoDia> listArchivosPago;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
//	public List<ArchivoPagoDia> getListArchivosPago() {
//		return listArchivosPago;
//	}
//
//	public void setListArchivosPago(List<ArchivoPagoDia> listArchivosPago) {
//		this.listArchivosPago = listArchivosPago;
//	}

}
