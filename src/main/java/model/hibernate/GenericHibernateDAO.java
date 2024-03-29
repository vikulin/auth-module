package model.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import jakarta.persistence.criteria.Predicate;
import model.GenericDAO;

/**
 * Generated at Tue Apr 14 19:54:58 EEST 2015
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T getById(ID id) {
		return (T) getSession().get(getPersistentClass(), id);
	}

	public T getById(ID id, boolean lock) {
		if (lock) {
			return (T) getSession().get(getPersistentClass(), id,
					LockMode.UPGRADE_NOWAIT);
		} else
			return getById(id);
	}

	public T loadById(ID id) {
		return (T) getSession().getReference(getPersistentClass(), id);
	}

	public void save(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().merge(entity);
	}

	public void delete(T entity) {
		getSession().remove(entity);
	}

	public void deleteById(ID id) {
		getSession().remove(loadById(id));
	}

	public Collection<T> findAll() {
		return findByCriteria();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	protected Collection<T> findByCriteria(Predicate... restrictions) {
        HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
        JpaCriteriaQuery<T> query = builder.createQuery(getPersistentClass());
        JpaRoot<T> root = query.from(getPersistentClass());
        query.where(restrictions);
        query.select(root);
        return getSession().createQuery(query).getResultList();
	}
	
	public Collection<T> findByFieldName(String field, Object value) {
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<T> query = builder.createQuery(getPersistentClass());
	    JpaRoot<T> root = query.from(getPersistentClass());

	    Predicate predicate = builder.equal(root.get(field), value);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
		
	}
}
