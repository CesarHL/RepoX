package mx.ipn.escom.spee.pagos.action;

import org.apache.struts2.convention.annotation.Namespace;

import mx.ipn.escom.spee.action.GeneralActionSupport;

@Namespace("/pagos")
public class GestionarHistorialPagosAct extends GeneralActionSupport {

	private static final long serialVersionUID = 1L;

	public String index() {
		return INDEX;
	}

}
