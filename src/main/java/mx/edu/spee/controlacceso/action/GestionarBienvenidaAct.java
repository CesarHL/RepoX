package mx.edu.spee.controlacceso.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;

@Namespace("/control-acceso")
@Results({ @Result(name = "login", type = "redirectAction", params = { "actionName", "login" }) })
public class GestionarBienvenidaAct extends GeneralActionSupport {

	private static final long serialVersionUID = -1689537805258891308L;

	public String index() {
		Usuario usuario = (Usuario) SessionManager.get(NombreObjetosSesion.USUARIO_SESION);
		if (usuario != null) {
			return INDEX;
		} else {
			return LOGIN;
		}
	}
}
