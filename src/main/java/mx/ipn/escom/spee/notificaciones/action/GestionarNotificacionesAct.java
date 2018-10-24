package mx.ipn.escom.spee.notificaciones.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.notificaciones.mapeo.Notificacion;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;
import mx.ipn.escom.spee.util.mapeo.AjaxResult;

@Namespace("/notificaciones")
@Results({
		@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
				"gestionar-notificaciones" }),
		@Result(name = "getNotificationsByUserId", type = "json", params = { "root", "action", "includeProperties",
				"ajaxResult.*" }) })
@AllowedMethods({ "getNotificationsByUserId" })
public class GestionarNotificacionesAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	public static final String GET_NOTIFICATIONS_BY_USER = "getNotificationsByUserId";

	@Autowired
	private GenericSearchBs genericSearchBs;

	private Usuario usuarioSel;

	private AjaxResult ajaxResult;

	private Integer idUser;

	private List<Notificacion> listNotificaciones;

	public String index() {
		getUsuarioSel();
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.ALUMNO
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.ENCARGADO_CAJA
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.CONTADOR
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.EXTERNO
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo()
				.getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.ADMINISTRADOR_DENTALES.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.SUBDIRECTOR
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		}
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.TRABAJADOR
				.getValor()) {
			Notificacion notificacion = new Notificacion();
			notificacion.setIdCuenta(usuarioSel.getId());
			listNotificaciones = genericSearchBs.findByExample(notificacion);
			return INDEX;
		} else {
			return NO_AUTORIZADO;
		}
	}

	public void validateCreate() {

	}

	public String create() {
		addActionMessage("... exitosamente");
		return SUCCESS;
	}

	@SkipValidation
	public String getNotificationsByUserId() {
		getUsuarioSel();
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.ALUMNO.getValor()
				&& usuarioSel != null) {
			getAjaxResult();
			ajaxResult = obtenerNotificaciónUsuario(idUser);
			SessionManager.put(NombreObjetosSesion.AJAX_RESULT, ajaxResult);
			return GET_NOTIFICATIONS_BY_USER;
		} else if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.SUBDIRECTOR
				.getValor()) {
			getAjaxResult();
			ajaxResult = obtenerNotificaciónUsuario(idUser);
			SessionManager.put(NombreObjetosSesion.AJAX_RESULT, ajaxResult);
			return GET_NOTIFICATIONS_BY_USER;
		} else {
			return NO_AUTORIZADO;
		}

	}

	public AjaxResult obtenerNotificaciónUsuario(Integer idUsuario) {
		AjaxResult ajaxResult = new AjaxResult();
		Notificacion notificacion = new Notificacion();
		notificacion.setIdCuenta(usuarioSel.getId());
		ajaxResult.addCampo("notificaciones", genericSearchBs.findByExample(notificacion));
		return ajaxResult;
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

	public AjaxResult getAjaxResult() {
		this.ajaxResult = (AjaxResult) SessionManager.get(NombreObjetosSesion.AJAX_RESULT);
		if (ajaxResult == null) {
			ajaxResult = new AjaxResult();
			SessionManager.put(NombreObjetosSesion.AJAX_RESULT, ajaxResult);
		}
		return ajaxResult;
	}

	public void setAjaxResult(AjaxResult ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public List<Notificacion> getListNotificaciones() {
		return listNotificaciones;
	}

	public void setListNotificaciones(List<Notificacion> listNotificaciones) {
		this.listNotificaciones = listNotificaciones;
	}

}
