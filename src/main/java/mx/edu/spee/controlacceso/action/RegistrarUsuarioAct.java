package mx.edu.spee.controlacceso.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import mx.edu.spee.controlacceso.bs.UsuarioBs;
import mx.edu.spee.controlacceso.exception.UniqueException;
import mx.edu.spee.controlacceso.mapeo.InformacionPersonal;

import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/control-acceso")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
		"registrar-usuario/new" }) })
public class RegistrarUsuarioAct extends GeneralActionSupport implements ModelDriven<InformacionPersonal> {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;

	private InformacionPersonal model;

	private Integer perfil;

	private String selectValue;

	@Autowired
	private UsuarioBs usuarioBs;

	@Autowired
	private GenericSearchBs genericSearchBs;

	public String editNew() {
		return EDITNEW;
	}

	public void validateCreate() {
		try {
			if (getFieldErrors().isEmpty() && getActionErrors().isEmpty()) {
				Usuario usr = usuarioBs.registrar(usuario, model);
				//usuarioBs.guardarInformacionPersonal(usr, model);
			} else {
				addActionError("Verifique su información.");
			}
		} catch (UniqueException ue) {
			addActionError("El usuario ya existe.");
		}
	}

	public String create() {
		addActionMessage("El usuario se registró exitosamente, revise su correo electrónico");
		return SUCCESS;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}

	public InformacionPersonal getInfo() {
		return model;
	}

	public void setInfo(InformacionPersonal info) {
		this.model = info;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	@VisitorFieldValidator
	public InformacionPersonal getModel() {
		if (model == null) {
			model = new InformacionPersonal();
		}
		return model;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public String getSelectValue() {
		return selectValue;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

}
