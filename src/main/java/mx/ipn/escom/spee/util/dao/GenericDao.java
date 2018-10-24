package mx.ipn.escom.spee.util.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mx.ipn.escom.spee.util.mapeo.Modelo;

@Repository("genericDao")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericDao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected SessionFactory sessionFactory;

	public <C extends Modelo> C findById(Class<C> clazz, Serializable id) {
		sessionFactory.getCurrentSession().clear();
		return (C) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findByExample(C example) {
		return (List<C>) sessionFactory.getCurrentSession().createCriteria(example.getClass())
				.add(Example.create(example)).list();
	}

	public <C extends Modelo> List<C> findAll(Class<C> clazz) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		criteria.from(clazz);
		return (List<C>) sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C save(C entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void save(List<C> list) {
		for (C entity : list) {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C update(C entity) {
		sessionFactory.getCurrentSession().update(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void update(List<C> list) {
		for (C entity : list) {
			sessionFactory.getCurrentSession().saveOrUpdate(entity);
		}
		sessionFactory.getCurrentSession().flush();
		sessionFactory.getCurrentSession().clear();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void delete(C entity) {
		sessionFactory.getCurrentSession().clear();
		sessionFactory.getCurrentSession().delete(entity);
	}

	public <C extends Modelo> C refreshEntity(C entity) {
		sessionFactory.getCurrentSession().refresh(entity);
		return entity;
	}

	public void clear() {
		sessionFactory.getCurrentSession().clear();
	}

	@SuppressWarnings("deprecation")
	public <C extends Modelo> Integer count(Class<C> clazz) {
		return ((Number) sessionFactory.getCurrentSession().createCriteria(clazz.getCanonicalName())
				.setProjection(Projections.rowCount()).uniqueResult()).intValue();
	}

	public <C extends Modelo> Boolean existByAttribute(Class<C> clazz, String nombreAtributo, String nombreIdAtributo,
			String valorAtributo, Serializable valorIdAtributo) {
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		Root<C> root = criteria.from(clazz);
		criteria.where(builder.equal(root.get(nombreAtributo), valorAtributo));
		criteria.where(builder.notEqual(root.get(nombreIdAtributo), valorIdAtributo));
		List<C> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
		return !result.isEmpty();

	}

	public <C extends Modelo> Boolean existByAttribute(Class<C> clazz, Map<String, Serializable> id,
			Map<String, Object> attributes) {

		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		Root<C> root = criteria.from(clazz);
		List<Predicate> predicates = new ArrayList<>();
		for (Entry<String, Serializable> e : id.entrySet()) {
			predicates.add(builder.notEqual(root.<String>get(e.getKey()), e.getValue()));
		}
		for (Entry<String, Object> e : attributes.entrySet()) {
			predicates.add(builder.equal(root.<String>get(e.getKey()), e.getValue()));
		}
		criteria.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));
		List<C> result = sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
		return !result.isEmpty();
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C updateMerge(C entity) {
		sessionFactory.getCurrentSession().merge(entity);
		sessionFactory.getCurrentSession().flush();
		return entity;
	}
}
