package mx.ipn.escom.spee.pagos.bs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.edu.spee.controlacceso.mapeo.Cuenta;
import mx.edu.spee.controlacceso.mapeo.InformacionPersonal;
import mx.edu.spee.controlacceso.mapeo.Usuario;
import mx.ipn.escom.spee.servicio.mapeo.CatalogoServicio;
import mx.ipn.escom.spee.util.bs.GenericSearchBs;
import mx.ipn.escom.spee.util.mapeo.AjaxResult;

@Service("catalogoServiciosBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GestionarServiciosBs {

	private static final Logger LOGGER = LoggerFactory.getLogger(GestionarServiciosBs.class);

	@Autowired
	private GenericSearchBs genericSearchBs;

	public List<CatalogoServicio> obtenerServiciosTipo() {
		CatalogoServicio catalogoServicioExample = new CatalogoServicio();
		LOGGER.info("Se ha creado una lista de servicios celex");
		return genericSearchBs.findByExample(catalogoServicioExample);
	}

	public InformacionPersonal obtenerInformacionPersonal(Usuario usuarioSel) {
		Cuenta cuenta = new Cuenta();
		cuenta.setIdUsuario(usuarioSel.getId());
		InformacionPersonal info = new InformacionPersonal();
		info.setIdCuenta(genericSearchBs.findByExample(cuenta).get(0).getIdCuenta());
		return genericSearchBs.findByExample(info).get(0);
	}
	
	
	public AjaxResult obtenerServicios() {
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.addCampo("pagos", genericSearchBs.findAll(CatalogoServicio.class));
		return ajaxResult;
	}

	public GenericSearchBs getGenericSearchBs() {
		return genericSearchBs;
	}

	public void setGenericSearchBs(GenericSearchBs genericSearchBs) {
		this.genericSearchBs = genericSearchBs;
	}

}
