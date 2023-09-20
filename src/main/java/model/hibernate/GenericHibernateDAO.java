package model.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

	public EntityManager getSession() {
		return HibernateUtil.getSessionFactory().createEntityManager();
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public T getById(ID id) {
		return (T) getSession().find(getPersistentClass(), id);
	}

	public T getById(ID id, boolean lock) {
		if (lock) {
			return (T) getSession().find(getPersistentClass(), id,
					LockModeType.READ);
		} else
			return getById(id);
	}

	public T loadById(ID id) {
		return (T) getSession().find(getPersistentClass(), id);
	}

	public void save(T entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().merge(entity);
	}

	public void saveOrUpdate(T entity) {
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
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getPersistentClass());
        Root<T> root = query.from(getPersistentClass());
        query.where(restrictions);
        query.select(root);
        return getSession().createQuery(query).getResultList();
	}
	
	public Collection<T> findByFieldName(String field, Object value) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<T> query = builder.createQuery(getPersistentClass());
	    Root<T> root = query.from(getPersistentClass());

	    Predicate predicate = builder.equal(root.get(field), value);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
		
	}
}
