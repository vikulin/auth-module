package model;

import java.util.List;
import java.sql.Timestamp;

import model.pojo.UserRole;
/**
 * <p>Generic DAO layer for UserRoles</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public interface UserRoleDAO extends GenericDAO<UserRole,Long> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildUserRoleDAO()
	 */
	  	 
	/**
	 * Find UserRole by id
	 */
	public List<UserRole> findById(Long id);

	/**
	 * Find UserRole by userId
	 */
	public List<UserRole> findByUserId(Long userId);

	/**
	 * Find UserRole by roleId
	 */
	public List<UserRole> findByRoleId(Long roleId);

}