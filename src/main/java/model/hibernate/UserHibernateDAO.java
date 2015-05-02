package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import model.UserDAO;
import model.pojo.User;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * <p>Hibernate DAO layer for Users</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class UserHibernateDAO extends
		AbstractHibernateDAO<User, Long> implements
		UserDAO, UserDetailsService {

	/**
	 * Find User by username
	 */
	public List<User> findByUsername(String username) {
		return findByCriteria(Restrictions.eq("username", username));
	}
	
	/**
	 * Find User by password
	 */
	public List<User> findByPassword(String password) {
		return findByCriteria(Restrictions.eq("password", password));
	}
	
	/**
	 * Find User by createDate
	 */
	public List<User> findByCreateDate(Timestamp createDate) {
		return findByCriteria(Restrictions.eq("createDate", createDate));
	}
	
	public List<User> findByLoginWithRole(String login) {
		return findByCriteriaWith(Restrictions.eq("username", login), "username");
	}
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		setSession(session);
		Collection<User> results = findByLoginWithRole(userName);
		session.getTransaction().commit();
		if(results.size() == 0) {
            throw new UsernameNotFoundException(userName + "not found");
		}
		return (UserDetails) results.iterator().next();
	}
	

}
