package model.hibernate;

import java.util.List;
import java.sql.Timestamp;

import model.pojo.Role;
import model.RoleDAO;

import org.hibernate.criterion.Restrictions;

/**
 * <p>Hibernate DAO layer for Roles</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class RoleHibernateDAO extends
		AbstractHibernateDAO<Role, Long> implements
		RoleDAO {

	/**
	 * Find Role by name
	 */
	public List<Role> findByName(String name) {
		return findByCriteria(Restrictions.eq("name", name));
	}
	
	/**
	 * Find Role by createDate
	 */
	public List<Role> findByCreateDate(Timestamp createDate) {
		return findByCriteria(Restrictions.eq("createDate", createDate));
	}
	

}
