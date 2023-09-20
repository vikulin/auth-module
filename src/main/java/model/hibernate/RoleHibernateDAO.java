package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<Role> query = builder.createQuery(Role.class);
	    Root<Role> root = query.from(Role.class);

	    Predicate predicate = builder.equal(root.get("name"), name);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
		
	}

	/**
	 * Find Role by createDate
	 */
	public Collection<Role> findByCreateDate(Timestamp createDate) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<Role> query = builder.createQuery(Role.class);
	    Root<Role> root = query.from(Role.class);

	    Predicate predicate = builder.equal(root.get("createDate"), createDate);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

}
