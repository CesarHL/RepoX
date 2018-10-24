package mx.edu.spee.controlacceso.mapeo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tau04_informacion_personal")
public class InformacionPersonal implements Modelo, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "clave")
	private String clave;

	@Column(name = "tx_nombre")
	private String nombre;

	@Column(name = "tx_primer_apellido")
	private String primerApellido;

	@Column(name = "tx_segundo_apellido")
	private String segundoApellido;

	@Column(name = "tx_celular")
	private String celular;

	@Column(name = "tx_correo")
	private String correo;

	@Column(name = "id_cuenta")
	private Integer idCuenta;

	@Transient
	private String curp;

	@Transient
	private String idPerfil;

	@Transient
	private String boleta;

	@Transient
	private String noEmpleado;
	
	@Transient 
	private String correoInicio;

	public InformacionPersonal() {
		super();
	}

	public InformacionPersonal(String clave, String nombre, String primerApellido, String segundoApellido,
			String celular, String correo, Integer idCuenta, String curp, String idPerfil, String boleta,
			String noEmpleado) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.celular = celular;
		this.correo = correo;
		this.idCuenta = idCuenta;
		this.curp = curp;
		this.idPerfil = idPerfil;
		this.boleta = boleta;
		this.noEmpleado = noEmpleado;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") })
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") })
	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") }, emails = {
					@EmailValidator(type = ValidatorType.FIELD, message = "Formato de correo incorrecto") })
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

//	@Validations(requiredStrings = {
//			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") }, regexFields = {
//					@RegexFieldValidator(regex = "[0-9]*", type = ValidatorType.FIELD, trim = true, key = "Formato no válido") })
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	@Validations(requiredStrings = {
			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") }, stringLengthFields = {
					@StringLengthFieldValidator(type = ValidatorType.FIELD, minLength = "7", maxLength = "18", message = "Longitud no válida") })
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

//	@Validations(requiredStrings = {
//			@RequiredStringValidator(type = ValidatorType.FIELD, message = "Campo obligatorio") }, stringLengthFields = {
//					@StringLengthFieldValidator(type = ValidatorType.FIELD, message = "Longitud no válida", maxLength = "18") })
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

//	@Validations(requiredStrings = {
//			@RequiredStringValidator(fieldName = "idCuenta", trim = true, type = ValidatorType.FIELD, message = "Campo obligatorio") }, regexFields = {
//					@RegexFieldValidator(regex = "[0-9]", type = ValidatorType.FIELD, trim = true, key = "Formato incorrecto") })
	public String getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getBoleta() {
		return boleta;
	}

	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	@Override
	public String toString() {
		return getNombre() + " " + getPrimerApellido() + " " + getSegundoApellido();
	}

	public String getCorreoInicio() {
		return correoInicio;
	}

	public void setCorreoInicio(String correoInicio) {
		this.correoInicio = correoInicio;
	}
	
	
}
