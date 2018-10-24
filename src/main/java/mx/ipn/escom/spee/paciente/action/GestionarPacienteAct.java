package mx.ipn.escom.spee.paciente.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/paciente")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
		"gestionar-paciente" }) })
public class GestionarPacienteAct extends GeneralActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8381454813302538764L;
	
	public String index() {
		return INDEX;
	}
	
}
