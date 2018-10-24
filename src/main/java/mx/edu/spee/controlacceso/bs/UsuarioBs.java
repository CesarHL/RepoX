package mx.edu.spee.controlacceso.bs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.spee.controlacceso.exception.UniqueException;
import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.edu.spee.controlacceso.mapeo.InformacionPersonal;
import mx.edu.spee.controlacceso.mapeo.Perfil;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.mail.business.MailSender;
import mx.ipn.escom.spee.util.Constantes;
import mx.ipn.escom.spee.util.SHADigest;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;
import mx.ipn.escom.spee.util.dao.GenericDao;

@Service("usuarioBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class UsuarioBs implements Serializable {

	private static final long serialVersionUID = -5310565999405879581L;

	@Autowired
	private GenericSearchBs genericSearchBs;

	@Autowired
	private GenericDao genericDao;

	@Autowired
	private MailSender mailSender;

	public Usuario buscarUsuario(String login) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		List<Usuario> listUsuarios = genericSearchBs.findByExample(usuario);
		return !listUsuarios.isEmpty() ? listUsuarios.get(0) : null;
	}

	@Transactional(rollbackFor = Exception.class)
	public Usuario registrar(Usuario usuario, InformacionPersonal info) throws UniqueException {
		Usuario usuarioExample = new Usuario();
		usuarioExample.setLogin(info.getCorreo());
		if (!genericSearchBs.findByExample(usuarioExample).isEmpty()) {
			throw new UniqueException();
		}
		usuario.setPassword(SHADigest.digest(usuario.getPassword()));
		Date date = new Date();
		usuario.setFechaAlta(date);
		genericDao.save(usuario);
		crearCuenta(usuario);
//		info.setClave("clave");
//		genericDao.save(info);
		usuario.setLogin(info.getCorreo());
		enviarEmailConfirmacion(usuario);
		return usuario;
	}

	public void guardarInformacionPersonal(Usuario usuario, InformacionPersonal info) {

		InformacionPersonal infoExample = new InformacionPersonal();

		info.setClave("clave");
		genericDao.save(info);
	}

	public void crearCuenta(Usuario usuario) {
		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario(usuario.getId());
		cuenta.setIdPerfil(Perfil.PerfilEnum.ALUMNO.getValor());
		cuenta.setEstatus(true);
		genericDao.save(cuenta);
	}
	
	public void crearCuentaPerfilDefault(Usuario usuario) {
		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario(usuario.getId());
		cuenta.setIdPerfil(Perfil.PerfilEnum.DEFAULT.getValor());
		cuenta.setEstatus(true);
		genericDao.save(cuenta);
	}

	public void enviarEmailConfirmacion(Usuario usuario) {
		Map<String, String> mailProperties = new HashMap<>();
		Map<String, Object> templateParams = new HashMap<>();

		mailProperties.put(Constantes.SUBJECT, "Sistema de Pagos Electrónicos ESCOM");
		mailProperties.put(Constantes.TEMPLATE, "mx/ipn/escom/spee/mail/templates/confirmacionCuenta.vm");

		String ip = "http://localhost:8123";
		String contextPath = ServletActionContext.getRequest().getContextPath();
		String namespace = "/control-acceso/login";
		
		templateParams.put("usuario", usuario.getLogin());
		templateParams.put("urlAcceso", ip + contextPath + namespace);
		templateParams.put("password", usuario.getPassword());

		List<String> destinatarios = new ArrayList<>();
		destinatarios.add(usuario.getLogin());

		mailSender.sendEmail(templateParams, mailProperties.get(Constantes.TEMPLATE), destinatarios,
				mailProperties.get(Constantes.SUBJECT), null);

	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

}
