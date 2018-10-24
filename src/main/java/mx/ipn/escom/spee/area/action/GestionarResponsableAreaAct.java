package mx.ipn.escom.spee.area.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;

import mx.edu.spee.controlacceso.exception.UniqueException;
import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.edu.spee.controlacceso.mapeo.InformacionPersonal;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.GeneralActionSupport;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.area.bs.AreaBs;
import mx.ipn.escom.spee.area.mapeo.CatalogoArea;
import mx.ipn.escom.spee.util.Numeros;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Namespace("/area")
@Results({ @Result(name = ActionSupport.SUCCESS, type = "redirectAction", params = { "actionName",
		"gestionar-responsable-area" }) })
public class GestionarResponsableAreaAct extends GeneralActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853253919957279842L;

	private Usuario usuarioSel;

	private InformacionPersonal model;

	private String nbCelex;
	private String nbDentalM;
	private String nbDentalV;
	private String nbBiblio;
	private String nbCopia;
	private String nombreArea;
	private String clave;

	private Integer idSel;

	@Autowired
	private GenericSearchBs genericSearchBs;

	@Autowired
	private AreaBs areaBs;

	private List<InformacionPersonal> listResponsablesArea;

	private List<CatalogoArea> listAreas;

	public String index() {
		getUsuarioSel();
		if (usuarioSel.getPerfilActivo().getId() == mx.edu.spee.controlacceso.mapeo.Perfil.PerfilEnum.SUBDIRECTOR
				.getValor()) {
			String nbArea = "";
			listResponsablesArea = areaBs.obtenerInfoResponsables();
			for (InformacionPersonal info : listResponsablesArea) {
				nbArea = areaBs.obtieneAreaResponsable(info.getIdCuenta());
				switch (nbArea) {
				case "CELEX":
					nbCelex = nbArea;
					break;
				case "Biblioteca":
					nbBiblio = nbArea;
					break;
				case "Odontología Matutino":
					nbDentalM = nbArea;
					break;
				case "Odontología Vespertino":
					nbDentalV = nbArea;
					break;
				case "Fotocopiado":
					nbCopia = nbArea;
					break;
				default:
					break;
				}
			}
			return INDEX;
		} else {
			return NO_AUTORIZADO;
		}
	}

	public String editNew() {
		return EDITNEW;
	}

	public void validateCreate() {
		try {
			if (getFieldErrors().isEmpty() && getActionErrors().isEmpty()) {
				areaBs.registrarResponsable(model);
			} else {
				addActionError("Verifique su información.");
			}
		} catch (UniqueException e) {
			addActionError("El usuario ya existe.");
		}
	}

	public String create() {
		addActionMessage(
				"El responsable de área se ha registrado correctamente. Dirígete a la sección \"Gestionar áreas\" para asignarle un área.");
		return SUCCESS;
	}

	public String edit() {
		getIdSel();
		InformacionPersonal infoAux = new InformacionPersonal();
		infoAux.setIdCuenta(idSel);
		model = genericSearchBs.findByExample(infoAux).get(Numeros.CERO.getValor());
		SessionManager.put("clave", model.getClave());
		clave = getClave();
		Cuenta cuenta = new Cuenta();
		CatalogoArea area = new CatalogoArea();
		cuenta = genericSearchBs.findById(Cuenta.class, model.getIdCuenta());
		area.setIdResponsable(cuenta.getIdCuenta());
		area = genericSearchBs.findByExample(area).get(Numeros.CERO.getValor());
		usuarioSel = genericSearchBs.findById(Usuario.class, cuenta.getIdUsuario());
		SessionManager.put(NombreObjetosSesion.NOMBRE_AREA, area.getNombreArea());
		nombreArea = getNombreArea();
		return EDIT;
	}

	public void validateUpdate() {
		InformacionPersonal info = new InformacionPersonal();
		info.setIdCuenta(idSel);
		info = genericSearchBs.findByExample(info).get(Numeros.CERO.getValor());
		model.setCorreoInicio(info.getCorreo());
		try {
			if (getFieldErrors().isEmpty() && getActionErrors().isEmpty()) {
				model.setIdCuenta(idSel);
				System.err.println("Correo de inicio -> " + model.getCorreoInicio());
				areaBs.editarResponsable(model, model.getCorreoInicio());
			} else {
				addActionError("Verifique su información.");
			}
		} catch (UniqueException e) {
			addActionError("Ya existe un usuario asociado a ese correo electrónico.");
		}
	}
	
	public String update() {
		addActionMessage("La información del responsable de área se actualizó correctamente.");
		return SUCCESS;
	}
	
	public String show() {
		InformacionPersonal info = new InformacionPersonal();
		info.setIdCuenta(idSel);
		model = genericSearchBs.findByExample(info).get(Numeros.CERO.getValor());
		Cuenta cuenta = new Cuenta();
		cuenta = genericSearchBs.findById(Cuenta.class, idSel);
		usuarioSel = genericSearchBs.findById(Usuario.class, cuenta.getIdUsuario());
		CatalogoArea area = new CatalogoArea();
		area.setIdResponsable(cuenta.getIdCuenta());
		area = genericSearchBs.findByExample(area).get(Numeros.CERO.getValor());
		nombreArea = area.getNombreArea();
		return SHOW;
	}

	public Usuario getUsuarioSel() {
		if (SessionManager.get(NombreObjetosSesion.USUARIO_SESION) != null) {
			usuarioSel = (Usuario) SessionManager.get(NombreObjetosSesion.USUARIO_SESION);
		}
		return usuarioSel;
	}

	public void setUsuarioSel(Usuario usuarioSel) {
		this.usuarioSel = usuarioSel;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public AreaBs getAreaBs() {
		return areaBs;
	}

	public void setAreaBs(AreaBs areaBs) {
		this.areaBs = areaBs;
	}

	public List<InformacionPersonal> getListResponsablesArea() {
		return listResponsablesArea;
	}

	public void setListResponsablesArea(List<InformacionPersonal> listResponsablesArea) {
		this.listResponsablesArea = listResponsablesArea;
	}

	public String getNbCelex() {
		return nbCelex;
	}

	public void setNbCelex(String nbCelex) {
		this.nbCelex = nbCelex;
	}

	public String getNbDentalM() {
		return nbDentalM;
	}

	public void setNbDentalM(String nbDentalM) {
		this.nbDentalM = nbDentalM;
	}

	public String getNbDentalV() {
		return nbDentalV;
	}

	public void setNbDentalV(String nbDentalV) {
		this.nbDentalV = nbDentalV;
	}

	public String getNbBiblio() {
		return nbBiblio;
	}

	public void setNbBiblio(String nbBiblio) {
		this.nbBiblio = nbBiblio;
	}

	public String getNbCopia() {
		return nbCopia;
	}

	public void setNbCopia(String nbCopia) {
		this.nbCopia = nbCopia;
	}

	@VisitorFieldValidator
	public InformacionPersonal getModel() {
		if (model == null) {
			model = new InformacionPersonal();
//			InformacionPersonal info = new InformacionPersonal();
//			info.setIdCuenta(idSel);
//			model = genericSearchBs.findByExample(info).get(Numeros.CERO.getValor());
		}
		return model;
	}

	public void setModel(InformacionPersonal model) {
		this.model = model;
	}

	public List<CatalogoArea> getListAreas() {
		return listAreas;
	}

	public void setListAreas(List<CatalogoArea> listAreas) {
		this.listAreas = listAreas;
	}

	public Integer getIdSel() {
		if (SessionManager.get(NombreObjetosSesion.SESSION_MODEL_ID) != null) {
			idSel = (Integer) SessionManager.get(NombreObjetosSesion.SESSION_MODEL_ID);
		}
		return idSel;
	}

	public void setIdSel(Integer idSel) {
		SessionManager.put(NombreObjetosSesion.SESSION_MODEL_ID, idSel);
		this.idSel = idSel;
	}

	public String getNombreArea() {
		if(SessionManager.get(NombreObjetosSesion.NOMBRE_AREA) != null) {
			nombreArea = (String) SessionManager.get(NombreObjetosSesion.NOMBRE_AREA);
		}
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public String getClave() {
		if(SessionManager.get("clave") != null) {
			clave = (String) SessionManager.get("clave");
		}
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}	
}
