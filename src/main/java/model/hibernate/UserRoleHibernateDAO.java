package model.hibernate;

import java.util.Collection;

import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

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
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    JpaRoot<UserRole> root = query.from(UserRole.class);

	    JpaPredicate predicate = builder.equal(root.get("id"), id);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

	/**
	 * Find UserRole by userId
	 */
	public Collection<UserRole> findByUserId(Long userId) {
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    JpaRoot<UserRole> root = query.from(UserRole.class);

	    JpaPredicate predicate = builder.equal(root.get("id"), userId);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

	/**
	 * Find UserRole by roleId
	 */
	public Collection<UserRole> findByRoleId(Long roleId) {
	    HibernateCriteriaBuilder builder = getSession().getCriteriaBuilder();
	    JpaCriteriaQuery<UserRole> query = builder.createQuery(UserRole.class);
	    JpaRoot<UserRole> root = query.from(UserRole.class);

	    JpaPredicate predicate = builder.equal(root.get("id"), roleId);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}

}
