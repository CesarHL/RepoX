package mx.ipn.escom.spee.pagos.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/pagos")
@Results({
		@Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName", "gestionar-pagos" }),
		@Result(name = ActionSupport.ERROR, type = "redirectAction", params = { "actionName", "cargar-pago/new" })})
public class GestionarCorteCajaAct  extends GeneralActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	public void validateCreate() {
		
	}

	public String create() {
		addActionMessage("Pago ha realizado el corte de caja exitosamente");
		return SUCCESS;
		
	}
}
