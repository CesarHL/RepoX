package mx.ipn.escom.spee.util.bs;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.spee.util.dao.GenericDao;
import mx.ipn.escom.spee.util.mapeo.Modelo;

@Service("genericBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericBs<T extends Modelo> {

	@Autowired
	protected GenericDao genericDao;

	@Autowired
	protected GenericSearchBs genericSearchBs;

	@Transactional(rollbackFor = Exception.class)
	public T save(T entity) {
		return genericDao.save(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public <C extends Modelo> void save(List<C> list) {
		genericDao.update(list);
	}

	@Transactional(rollbackFor = Exception.class)
	public T update(T entity) {
		return genericDao.update(entity);
	}

	@Transactional(rollbackFor = Exception.class)
	public <C extends Modelo> void update(List<C> list) {
		genericDao.update(list);
	}


	@Transactional(rollbackFor = Exception.class)
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	
	@Transactional(readOnly = true)
	public <T extends Modelo> Boolean existeAtributo(Class<T> clazz, Map<String, Serializable> id,
			Map<String, Object> attributes) {
		return genericDao.existByAttribute(clazz, id, attributes);
	}
}
