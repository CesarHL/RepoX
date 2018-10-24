package mx.ipn.escom.spee.consulta.action;


import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import mx.ipn.escom.spee.action.GeneralActionSupport;


@Namespace("/consulta")
@Results({
		@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "gestionar-consulta" }) })
public class GestionarConsultaAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;
	
	public String index() {
		return INDEX;
	}
	
	public String editNew() {
		return EDITNEW;
	}
	
	public void validateCreate() {
		
	}
	
	public String create() {
		addActionMessage("Se ha generado tu consulta exitosamente");
		return SUCCESS;
	}
	
	public String show() {
		return SHOW;
	}
}