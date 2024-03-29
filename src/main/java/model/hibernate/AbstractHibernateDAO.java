package model.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import jakarta.persistence.criteria.Predicate;
import model.GenericDAO;

/**
 * Generated at Thu Mar 22 14:32:50 EET 2012
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public abstract class AbstractHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

	private Session session;

	private Class<T> persistentClass;

	public AbstractHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

    public void setSession(Session session) {
		this.session = session;
	}

	protected Session getSession() {
		if (session == null || !session.isConnected())
           session = HibernateUtil.getSessionFactory().getCurrentSession();
       return session;
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
					LockOptions.UPGRADE);
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
        HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
        JpaCriteriaQuery<T> query = builder.createQuery(getPersistentClass());

        query.where(predicates);

        return getSession().createQuery(query).getResultList();
    }
}
