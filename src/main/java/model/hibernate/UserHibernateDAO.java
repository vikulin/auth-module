package model.hibernate;

import java.sql.Timestamp;
import java.util.Collection;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserPojo> query = builder.createQuery(UserPojo.class);
	    Root<UserPojo> root = query.from(UserPojo.class);

	    Predicate predicate = builder.equal(root.get("username"), username);

	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}
	
	/**
	 * Find User by password
	 */
	public Collection<UserPojo> findByPassword(String password) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserPojo> query = builder.createQuery(UserPojo.class);
	    Root<UserPojo> root = query.from(UserPojo.class);

	    Predicate predicate = builder.equal(root.get("password"), password);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}
	
	/**
	 * Find User by createDate
	 */
	public Collection<UserPojo> findByCreateDate(Timestamp createDate) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserPojo> query = builder.createQuery(UserPojo.class);
	    Root<UserPojo> root = query.from(UserPojo.class);

	    Predicate predicate = builder.equal(root.get("createDate"), createDate);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}
	
	public Collection<UserPojo> findByLoginWithRole(String login) {
	    CriteriaBuilder builder = getSession().getCriteriaBuilder();
	    CriteriaQuery<UserPojo> query = builder.createQuery(UserPojo.class);
	    Root<UserPojo> root = query.from(UserPojo.class);

	    Predicate predicate = builder.equal(root.get("username"), login);
	    query.select(root);
	    query.where(predicate);

	    return getSession().createQuery(query).getResultList();
	}
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
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
