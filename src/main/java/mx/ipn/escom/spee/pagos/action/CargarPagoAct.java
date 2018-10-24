package mx.ipn.escom.spee.pagos.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.Archivo;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.pagos.bs.PagoBs;
import mx.ipn.escom.spee.pagos.exception.FolioDuplicadoException;
import mx.ipn.escom.spee.pagos.exception.FormatoArchivoException;
import mx.ipn.escom.spee.pagos.exception.TamanioArchivoException;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/pagos")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "gestionar-pagos" }),
		@Result(name = ActionSupport.ERROR, type = "redirectAction", params = { "actionName", "cargar-pago/new" }) })
public class CargarPagoAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PagoBs pagoBs;

	@Autowired
	private GenericSearchBs genericSearchBs;

	private Integer idServicio;

	private Usuario usuarioSel;

	private Archivo archivo;

	private String folio;

	public String editNew() {
		return EDITNEW;
	}

	public void validateCreate() {
		getUsuarioSel();
		getIdServicio();
		try {
			if (getFieldErrors().isEmpty() && getActionErrors().isEmpty()) {
				pagoBs.registrarPago(archivo, usuarioSel, idServicio, folio);
			} else {
				addActionError("Verifique su información.");
			}
		} catch (IOException e) {
			addActionError("No se pudo abrir su archivo");
		} catch (TamanioArchivoException tae) {
			addActionError("El archivo es demasiado grande");
		} catch (FormatoArchivoException fae) {
			addActionError("Formato no válido");
		} catch (FolioDuplicadoException fde) {
			addActionError("Folio no válido");
		}
	}

	public String create() {
		addActionMessage("Pago se envió exitosamente");
		return SUCCESS;
	}

	public PagoBs getPagoBs() {
		return pagoBs;
	}

	public void setPagoBs(PagoBs pagoBs) {
		this.pagoBs = pagoBs;
	}

	public Archivo getArchivo() {
		return archivo;
	}

	public void setArchivo(Archivo archivo) {
		this.archivo = archivo;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
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

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

}
