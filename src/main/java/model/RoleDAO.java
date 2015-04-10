package model;

import java.util.List;
import java.sql.Timestamp;

import model.pojo.Role;
/**
 * <p>Generic DAO layer for Roles</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public interface RoleDAO extends GenericDAO<Role,Long> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildRoleDAO()
	 */
	  	 
	/**
	 * Find Role by name
	 */
	public List<Role> findByName(String name);

	/**
	 * Find Role by createDate
	 */
	public List<Role> findByCreateDate(Timestamp createDate);

}