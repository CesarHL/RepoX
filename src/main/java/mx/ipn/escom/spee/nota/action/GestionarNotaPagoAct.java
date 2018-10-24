package mx.ipn.escom.spee.nota.action;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/nota-pago")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
		"gestionar-nota-pago" }) })
@AllowedMethods({ "visualizarNotaDental" })
public class GestionarNotaPagoAct extends GeneralActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2661946695781600755L;

	private static final String NOTA_DENTAL = "notaDental";
	private static final String NOTA_BIBLIOTECA = "notaBiblioteca";
	private static final String SHOW_NOTA_DENTAL = "showDental";

	private Integer banderaPrueba = 1;

	public String index() {
		if (banderaPrueba == 1)
			return NOTA_DENTAL;
		else
			return NOTA_BIBLIOTECA;
	}

	public String visualizarNotaDental() {
		return SHOW_NOTA_DENTAL;
	}
}
