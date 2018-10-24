package mx.ipn.escom.spee.consulta.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/consulta")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
		"gestionar-historial-clinico" }) })
public class GestionarHistorialClinicoAct extends GeneralActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4391230293341782914L;
	
	public String show() {
		return SHOW;
	}

}
