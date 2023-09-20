package model.hibernate;

import java.util.Collection;

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
	    return super.findByFieldName("id", id);
	}

	/**
	 * Find UserRole by userId
	 */
	public Collection<UserRole> findByUserId(Long userId) {
	    //TODO Fix me
		return super.findByFieldName("id", userId);
	}

	/**
	 * Find UserRole by roleId
	 */
	public Collection<UserRole> findByRoleId(Long roleId) {
		//TODO Fix me
	    return super.findByFieldName("id", roleId);
	}

}
