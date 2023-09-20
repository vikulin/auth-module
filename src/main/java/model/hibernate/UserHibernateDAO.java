package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;

import org.hibernate.Session;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import model.UserDAO;
import model.pojo.User;
import model.pojo.UserPojo;

/**
 * <p>Hibernate DAO layer for Users</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public class UserHibernateDAO extends
		GenericHibernateDAO<UserPojo, Long> implements
		UserDAO, UserDetailsService {

	/**
	 * Find User by username
	 */
	public Collection<UserPojo> findByUsername(String username) {
	    return super.findByFieldName("username", username);
	}
	
	/**
	 * Find User by password
	 */
	public Collection<UserPojo> findByPassword(String password) {
	    return super.findByFieldName("password", password);
	}
	
	/**
	 * Find User by createDate
	 */
	public Collection<UserPojo> findByCreateDate(Timestamp createDate) {
	    return super.findByFieldName("createDate", createDate);
	}
	
	public Collection<UserPojo> findByLoginWithRole(String login) {
	    return super.findByFieldName("username", login);
	}
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Session session = getSession();
		session.beginTransaction();
		setSession(session);
		Collection<UserPojo> results = findByLoginWithRole(userName);
		session.getTransaction().commit();
		if(results.size() == 0) {
            throw new UsernameNotFoundException(userName + "not found");
		}
		UserPojo userPojo = results.iterator().next();
		return (UserDetails)(new User(userPojo));
	}
	

}
