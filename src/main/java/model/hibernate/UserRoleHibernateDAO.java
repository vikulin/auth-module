package model.hibernate;

import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.UserRoleDAO;
import model.pojo.UserRole;

/**
 * <p>
 * Hibernate DAO layer for UserRoles
 * </p>
 * <p>
 * Generated at Tue Apr 14 19:54:58 EEST 2015
 * </p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class UserRoleHibernateDAO extends GenericHibernateDAO<UserRole, Long>
		implements UserRoleDAO {

	/**
	 * Find UserRole by id
	 */
	public Collection<UserRole> findById(Long id) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    Root<UserRole> root = query.from(UserRole.class);

	    Predicate predicate = builder.equal(root.get("id"), id);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

	/**
	 * Find UserRole by userId
	 */
	public Collection<UserRole> findByUserId(Long userId) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    Root<UserRole> root = query.from(UserRole.class);

	    Predicate predicate = builder.equal(root.get("id"), userId);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

	/**
	 * Find UserRole by roleId
	 */
	public Collection<UserRole> findByRoleId(Long roleId) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    Root<UserRole> root = query.from(UserRole.class);

	    Predicate predicate = builder.equal(root.get("id"), roleId);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

}
