package mx.edu.spee.example.action;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

import mx.ipn.escom.spee.action.SessionManager;

@Namespace("/example")
@AllowedMethods({ "cambiarMenu" })
@Results({ @Result(name = MenuAct.MENU, type = "redirectAction", params = { "actionName", "%{action}" }) })
public class MenuAct extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String action;
	public static final String MENU = "menu";
	private static final String MENU_1 = "calendario";
	private static final String MENU_2A = "aspirante";
	private static final String MENU_2B = "aspirante";
	private static final String MENU_3 = "pago_examen";
	private static final String MENU_4 = "ceneval";
	private static final String MENU_6 = "gestion_entrevistas";
	private static final String MENU_7 = "evaluar_entrevistas";
	private static final String MENU_8 = "seleccion_estudiantes";
	private static final String MENU_9 = "coordinador_psicologo";
	private static final String MENU_10 = "psicologo";

	private String usuario;

	public String index() {
		return "index";
	}

	public String cambiarMenu() {
		System.out.println("---> H" + getText("IU1.4-2_LBL5"));
		SessionManager.set("usuario", usuario);
		if (MENU_1.equals(usuario)) {
			System.out.println(MENU_1);
			action = "";
		} else if (MENU_2A.equals(usuario)) {
			System.out.println(MENU_2A);
			action = "../admision/registrar-aspirante/new";
		} else if (MENU_2B.equals(usuario)) {
			System.out.println(MENU_2B);
			action = "../admision/gestionar-aspirantes";
		} else if (MENU_3.equals(usuario)) {
			System.out.println(MENU_3);
			action = "../admision/pagar-admision";
		} else if (MENU_4.equals(usuario)) {
			System.out.println(MENU_4);
			action = "../ceneval/gestionar-registrar-folios";
		} else if (MENU_6.equals(usuario)) {
			System.out.println(MENU_6);
			action = "../admision/aspirantes-entrevistar";
		} else if (MENU_7.equals(usuario)) {
			System.out.println(MENU_7);
			action = "../entrevistas/gestionar-entrevistas/new";
		} else if (MENU_8.equals(usuario)) {
			System.out.println(MENU_8);
			action = "../admision/aspirantes-aceptar";
		} else if (MENU_9.equals(usuario)) {
			System.out.println(MENU_9);
			action = "../psicometrico/gestionar-psicologo";
		} else if (MENU_10.equals(usuario)) {
			System.out.println(MENU_10);
			action = "../psicometrico/gestionar-entrevista";
		} else {
			System.out.println("menu");
			action = "menu";
		}
		return MENU;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
}
