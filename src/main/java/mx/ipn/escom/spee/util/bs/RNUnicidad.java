package mx.ipn.escom.spee.util.bs;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Service("rNUnicidad")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class RNUnicidad implements ReglaNegocio, Serializable {

	@Autowired
	private GenericBs genericBs;

	public <T extends Modelo> Boolean validate(Class<T> clazz, Map<String, Serializable> id,
			Map<String, Object> attributes) {
		Boolean valido = true;
		if (genericBs.existeAtributo(clazz, id, attributes)) {
			valido = false;
		}
		return valido;
	}

	public GenericBs getGenericBs() {
		return genericBs;
	}

	public void setGenericBs(GenericBs genericBs) {
		this.genericBs = genericBs;
	}

}
