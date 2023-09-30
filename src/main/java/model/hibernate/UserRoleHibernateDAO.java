package model.hibernate;

import java.util.Collection;

import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import model.UserRoleDAO;
import model.pojo.Role;
import model.pojo.User;
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
	    return super.findByFieldName("id", id);
	}

	/**
	 * Find UserRole by userId
	 */
	public Collection<UserRole> findByUserId(Long userId) {
        HibernateCriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserRole> cq = cb.createQuery(UserRole.class);

        Root<UserRole> userRoleRoot = cq.from(UserRole.class);
        Join<UserRole, User> userJoin = userRoleRoot.join("user");

        cq.where(cb.equal(userJoin.get("id"), userId));

        return getSession().createQuery(cq).getResultList();
	}

	/**
	 * Find UserRole by roleId
	 */
	public Collection<UserRole> findByRoleId(Long roleId) {
        HibernateCriteriaBuilder cb = getSession().getCriteriaBuilder();
        CriteriaQuery<UserRole> cq = cb.createQuery(UserRole.class);

        Root<UserRole> userRoleRoot = cq.from(UserRole.class);
        Join<UserRole, Role> userJoin = userRoleRoot.join("role");

        cq.where(cb.equal(userJoin.get("id"), roleId));

        return getSession().createQuery(cq).getResultList();
	}

}
