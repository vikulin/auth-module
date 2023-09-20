package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;

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
	    return super.findByFieldName("name", name);
	}

	/**
	 * Find Role by createDate
	 */
	public Collection<Role> findByCreateDate(Timestamp createDate) {
	    return super.findByFieldName("createDate", createDate);
	}

}
