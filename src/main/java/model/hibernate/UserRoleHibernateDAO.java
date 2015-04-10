package model.hibernate;

import java.util.List;

import model.UserRoleDAO;
import model.pojo.UserRole;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for UserRoles</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class UserRoleHibernateDAO extends
		AbstractHibernateDAO<UserRole, Long> implements
		UserRoleDAO {

	/**
	 * Find UserRole by id
	 */
	public List<UserRole> findById(Long id) {
		return findByCriteria(Restrictions.eq("id", id));
	}
	
	/**
	 * Find UserRole by userId
	 */
	public List<UserRole> findByUserId(Long userId) {
		return findByCriteria(Restrictions.eq("user.id", userId));
	}
	
	/**
	 * Find UserRole by roleId
	 */
	public List<UserRole> findByRoleId(Long roleId) {
		return findByCriteria(Restrictions.eq("role.id", roleId));
	}
	

}
