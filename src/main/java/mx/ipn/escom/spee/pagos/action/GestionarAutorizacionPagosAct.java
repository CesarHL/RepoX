package mx.ipn.escom.spee.pagos.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.spee.controlacceso.mapeo.InformacionPersonal;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.pagos.bs.GestionarServiciosBs;
import mx.ipn.escom.spee.pagos.bs.PagoBs;
import mx.ipn.escom.spee.pagos.mapeo.ArchivoPagoDia;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/pagos")
@AllowedMethods({ "autorizarPago", "rechazarPago" })
@Results({
		@Result(name = GestionarAutorizacionPagosAct.ERROR, type = "redirectAction", params = { "actionName",
				"gestionar-autorizacion-pagos" }),
		@Result(name = GestionarAutorizacionPagosAct.SUCCESS, type = "redirectAction", params = { "actionName",
				"gestionar-autorizacion-pagos" }) })
public class GestionarAutorizacionPagosAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericSearchBs genericSearchBs;

	@Autowired
	private PagoBs pagoBs;

	@Autowired
	private GestionarServiciosBs gestionarServiciosBs;

	private InformacionPersonal infoUsuario;

	private Integer idSel;

	private ArchivoPagoDia model;

	public InputStream inputStream;

	private Usuario usuarioSel;

	private File file;

	private List<ArchivoPagoDia> listArchivoPagosRevision;

	public String index() {
		listArchivoPagosRevision = pagoBs.obtenerPagosPorAutorizar();
	
		return INDEX;
	}

	public String show() {
		getIdSel();
		getUsuarioSel();
		
		try {
			infoUsuario = gestionarServiciosBs.obtenerInformacionPersonal(usuarioSel);
			FileOutputStream fileOuputStream = new FileOutputStream("filename.pdf");
			fileOuputStream.write(genericSearchBs.findById(ArchivoPagoDia.class, idSel).getArchivo());
			file = new File("filename.pdf");
			inputStream = new DataInputStream(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SHOW;
	}

	public String editNew() {
		return EDITNEW;
	}

	public String create() {
		addActionMessage("Se adjunto el comprobante exitosamente");
		return SUCCESS;
	}

	public String autorizarPago() {
		getIdSel();
		pagoBs.autorizarPago(idSel);
		addActionMessage(getText("Se ha autorizado el pago"));
		return SUCCESS;
	}

	public String rechazarPago() {
		getIdSel();
		pagoBs.rechazarPago(idSel);
		addActionMessage("Se ha rechazado el pago");
		return SUCCESS;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public List<ArchivoPagoDia> getListArchivoPagosRevision() {
		return listArchivoPagosRevision;
	}

	public void setListArchivoPagosRevision(List<ArchivoPagoDia> listArchivoPagosRevision) {
		this.listArchivoPagosRevision = listArchivoPagosRevision;
	}

	public PagoBs getPagoBs() {
		return pagoBs;
	}

	public void setPagoBs(PagoBs pagoBs) {
		this.pagoBs = pagoBs;
	}

	public Integer getIdSel() {
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		if (idSel != null) {
			model = genericSearchBs.findById(ArchivoPagoDia.class, idSel);
		}
		this.idSel = idSel;
	}

	public ArchivoPagoDia getModel() {
		return model;
	}

	public void setModel(ArchivoPagoDia model) {
		this.model = model;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public InformacionPersonal getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(InformacionPersonal infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	public GestionarServiciosBs getGestionarServiciosBs() {
		return gestionarServiciosBs;
	}

	public void setGestionarServiciosBs(GestionarServiciosBs gestionarServiciosBs) {
		this.gestionarServiciosBs = gestionarServiciosBs;
	}

	public Usuario getUsuarioSel() {
		if (SessionManager.get(NombreObjetosSesion.USUARIO_SESION) != null) {
			usuarioSel = (Usuario) SessionManager.get(NombreObjetosSesion.USUARIO_SESION);
		}
		return usuarioSel;
	}

	public void setUsuarioSel(Usuario usuarioSel) {
		this.usuarioSel = usuarioSel;
	}

}
