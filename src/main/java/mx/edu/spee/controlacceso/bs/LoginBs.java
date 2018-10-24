package mx.edu.spee.controlacceso.bs;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.edu.spee.controlacceso.exception.LoginIncorrectoException;
import mx.edu.spee.controlacceso.exception.UsuarioNoEncontradoException;
import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.action.NombreObjetosSesion;
import mx.ipn.escom.spee.action.SessionManager;
import mx.ipn.escom.spee.util.SHADigest;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;

@Service("loginBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class LoginBs implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginBs.class);

	@Autowired
	private UsuarioBs usuarioBs;

	@Autowired
	private GenericSearchBs genericSearchBs;

	@Transactional
	public Usuario ingresar(String mail, String password)
			throws UsuarioNoEncontradoException, LoginIncorrectoException {
		Usuario usuario = usuarioBs.buscarUsuario(mail);
		if (usuario == null) {
			LOGGER.trace("Usuario no encontrado");
			SessionManager.clear();
			throw new UsuarioNoEncontradoException();
		} else {
			String passwordSHA = SHADigest.digest(password);
			if (passwordSHA.equals(usuario.getPassword())) {
				Cuenta cuenta = new Cuenta();
				cuenta.setIdUsuario(usuario.getId());
				List<Cuenta> cuentas = genericSearchBs.findByExample(cuenta);
				usuario.setPerfilActivo(cuentas.get(0).getPerfil());
				if (!cuentas.isEmpty()) {
					SessionManager.put(NombreObjetosSesion.USUARIO_SESION, usuario);
				} else {
					System.err.println("Usuario sin cuenta");
				}
			} else {
				throw new LoginIncorrectoException();
			}
		}
		return usuario;
	}

	public UsuarioBs getUsuarioBs() {
		return usuarioBs;
	}

	public void setUsuarioBs(UsuarioBs usuarioBs) {
		this.usuarioBs = usuarioBs;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

}
