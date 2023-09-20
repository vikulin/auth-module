package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;

import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import jakarta.persistence.criteria.Predicate;
import model.RoleDAO;
import model.pojo.Role;

/**
 * <p>
 * Hibernate DAO layer for Roles
 * </p>
 * <p>
 * Generated at Tue Apr 14 19:54:58 EEST 2015
 * </p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class RoleHibernateDAO extends GenericHibernateDAO<Role, Long>
		implements RoleDAO {

	/**
	 * Find Role by name
	 */
	public Collection<Role> findByName(String name) {
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<Role> query = builder.createQuery(Role.class);
	    JpaRoot<Role> root = query.from(Role.class);

	    Predicate predicate = builder.equal(root.get("name"), name);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
		
	}

	/**
	 * Find Role by createDate
	 */
	public Collection<Role> findByCreateDate(Timestamp createDate) {
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<Role> query = builder.createQuery(Role.class);
	    JpaRoot<Role> root = query.from(Role.class);

	    Predicate predicate = builder.equal(root.get("createDate"), createDate);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

}
