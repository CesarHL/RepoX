package mx.edu.spee.controlacceso.mapeo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;
import mx.ipn.escom.spee.util.mapeo.Modelo;

@Entity
@Table(name = "tau02_usuario")
public class Usuario implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer id;

	@Column(name = "tx_login")
	private String login;

	@Column(name = "tx_password")
	private String password;
	
	@Column(name = "fh_alta")
	private Date fechaAlta;

	@Transient
	private Perfil perfilActivo;

	public Usuario() {
		super();
	}

	public Usuario(String login) {
		super();
		this.login = login;
	}

	public Usuario(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public Usuario(Integer id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	@Validations(requiredStrings = { @RequiredStringValidator(message = "Campo Obligatorio") }, emails = {
			@EmailValidator(type = ValidatorType.FIELD, message = "%{getText('MSG27')}") }, stringLengthFields = {
					@StringLengthFieldValidator(maxLength = "50", message = "%{getText('MSG57', {getText('CO_MENOR'), '50', 'caracteres'})}", trim = true, type = ValidatorType.FIELD) })
	public String getLogin() {
		return login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Validations(requiredStrings = { @RequiredStringValidator(message = "Campo Obligatorio") }, stringLengthFields = {
			@StringLengthFieldValidator(maxLength = "10", message = "Debe ser menor que 10 caracteres", trim = true, type = ValidatorType.FIELD) })
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Perfil getPerfilActivo() {
		return perfilActivo;
	}

	public void setPerfilActivo(Perfil perfilActivo) {
		this.perfilActivo = perfilActivo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

}
