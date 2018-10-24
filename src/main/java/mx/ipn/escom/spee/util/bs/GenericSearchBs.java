package mx.ipn.escom.spee.util.bs;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.spee.util.dao.GenericDao;
import mx.ipn.escom.spee.util.mapeo.Modelo;

@Service("genericSearchBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericSearchBs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GenericDao genericDao;

	@Transactional(readOnly = true)
	public <C extends Modelo> C findById(Class<C> clazz, Serializable id) {
		return genericDao.findById(clazz, id);
	}

	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findByExample(C example) {
		return genericDao.findByExample(example);
	}

	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findAll(Class<C> clazz) {
		return genericDao.findAll(clazz);
	}

}
