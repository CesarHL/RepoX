package mx.ipn.escom.spee.pagos.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.area.mapeo.CatalogoArea.CatalogoAreaEnum;
import mx.ipn.escom.spee.pagos.mapeo.ArchivoPagoDia;
import mx.ipn.escom.spee.pagos.mapeo.EstadoPago.EstadoPagoEnum;
import mx.ipn.escom.spee.servicio.mapeo.CatalogoServicio;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/pagos")
public class GestionarArchivoPagosAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	private List<ArchivoPagoDia> listArchivosPagoAnual;

	@Autowired
	private GenericSearchBs genericSearchBs;

	private Usuario usuarioSel;

	public String index() {
		getUsuarioSel();
		if (usuarioSel.getPerfilActivo()
				.getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.ADMINISTRADOR_CELEX.getValor()) {
			ArchivoPagoDia archivoPago = new ArchivoPagoDia();
			archivoPago.setIdEstadoPago(EstadoPagoEnum.AUTORIZADO.getIdEstatus());
			CatalogoServicio catalogo = new CatalogoServicio();
			catalogo.setIdArea(CatalogoAreaEnum.CELEX.getIdEstatus());
			archivoPago.setCatalogoServicio(catalogo);
			listArchivosPagoAnual = genericSearchBs.findByExample(archivoPago);
			return INDEX;
		} else {
			return NO_AUTORIZADO;
		}
	}

	public String show() {
		return SHOW;
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

	public List<ArchivoPagoDia> getListArchivosPagoAnual() {
		return listArchivosPagoAnual;
	}

	public void setListArchivosPagoAnual(List<ArchivoPagoDia> listArchivosPagoAnual) {
		this.listArchivosPagoAnual = listArchivosPagoAnual;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

}
