package mx.edu.spee.controlacceso.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.SessionManager;

@Namespace("/control-acceso")
@Results({ @Result(name = "success", type = "redirectAction", params = { "actionName", "login" }) })
public class LogoutAct extends GeneralActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() {
		SessionManager.clear();
		return SUCCESS;
	}
}
