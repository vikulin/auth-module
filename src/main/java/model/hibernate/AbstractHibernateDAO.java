package model.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import model.GenericDAO;

/**
 * Generated at Thu Mar 22 14:32:50 EET 2012
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public abstract class AbstractHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Class<T> persistentClass;

	public AbstractHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager getSession() {
		return HibernateUtil.getSessionFactory().createEntityManager();
	}

	public Class<T> getPersistentClass() {
        return persistentClass;
    }

	@SuppressWarnings("unchecked")
	public T getById(ID id) {
		return (T) getSession().find(getPersistentClass(), id);
	}

	@SuppressWarnings("unchecked")
	public T getById(ID id, boolean lock) {
		if (lock) {
			return (T) getSession().find(getPersistentClass(), id,
					LockModeType.READ);
		} else
			return getById(id);
	}

	@SuppressWarnings("unchecked")
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

	public void deleteById(ID id) 	{
		getSession().remove(loadById(id));
	}

	public List<T> findAll() {
        return findByCriteria();
    }
	
	/**
     * Use this inside subclasses as a convenience method.
     */
    protected List<T> findByCriteria(Predicate... predicates) {
        CriteriaBuilder builder = getSession().getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(getPersistentClass());

        query.where(predicates);

        return getSession().createQuery(query).getResultList();
    }
}
