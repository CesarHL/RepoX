package mx.edu.spee.controlacceso.action;

import java.util.List;

import org.apache.struts2.convention.annotation.AllowedMethods;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

import mx.edu.spee.controlacceso.bs.LoginBs;
import mx.edu.spee.controlacceso.exception.LoginIncorrectoException;
import mx.edu.spee.controlacceso.exception.UsuarioNoEncontradoException;
import mx.edu.spee.example.action.MenuAct;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/control-acceso")
@AllowedMethods({ "welcome" })
@Results({ @Result(name = MenuAct.MENU, type = "redirectAction", params = { "actionName", "%{action}" }) })
public class LoginAct extends GeneralActionSupport {

	protected static final String WELCOME = "welcome";

	private static final Logger log = LoggerFactory.getLogger(LoginAct.class);

	private static final long serialVersionUID = 1L;
	
	private static final String BIENVENIDA = "../control-acceso/gestionar-bienvenida";

	public static final String MENU = "menu";
	
	@Autowired
	private GenericSearchBs genericSearchBs;
	
	@Autowired
	private LoginBs loginBs;

	private String action;

	private String login;

	private String password;

	public HttpHeaders index() {
		Usuario usuario = (Usuario) SessionManager.get(NombreObjetosSesion.USUARIO_SESION);
		if (usuario != null) {
			return new DefaultHttpHeaders(redireccionarPorPerfil(usuario)).disableCaching();
		}
		return new DefaultHttpHeaders(INDEX).disableCaching();
	}

	public void validateCreate() {
		try {
			loginBs.ingresar(login, password);
		} catch (UsuarioNoEncontradoException e) {
			addActionError(getText("Usuario o Password icorrectos"));
		} catch (LoginIncorrectoException e) {
			addActionError(getText("Usuario o Password icorrectos"));
		}
	}

	public String create() {
		Usuario usuario = (Usuario) SessionManager.get(NombreObjetosSesion.USUARIO_SESION);
		log.info(usuario + ": Sesión iniciada");
		return redireccionarPorPerfil(usuario);
	}

	public String redireccionarPorPerfil(Usuario usuario) {
		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario(usuario.getId());
		List<Cuenta> usuarioCuenta = genericSearchBs.findByExample(cuenta);
		if (PerfilEnum.SUBDIRECTOR.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ADMINISTRADOR_CELEX.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ADMINISTRADOR_DENTALES.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ADMINISTRADOR_BIBLIOTECA.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ADMINISTRADOR_FOTOCOPIADO.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ENCARGADO_CAJA.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.CONTADOR.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.ALUMNO.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.TRABAJADOR.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else if (PerfilEnum.EXTERNO.getValor().equals(usuarioCuenta.get(0).getIdPerfil())) {
			action = BIENVENIDA;
		} else {
			action = "../example/example-a";
		}
		return MENU;
	}

	public String welcome() {
		return WELCOME;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") }, emails = {
					@EmailValidator(type = ValidatorType.FIELD, message = "Formato de correo incorrecto") })
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") })
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginBs getLoginBs() {
		return loginBs;
	}

	public void setLoginBs(LoginBs loginBs) {
		this.loginBs = loginBs;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
