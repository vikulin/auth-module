package model;

import java.util.List;
import java.sql.Timestamp;

import model.pojo.User;
/**
 * <p>Generic DAO layer for Users</p>
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 *
 * @author Salto-db Generator v1.0.16 / Pojos + Hibernate mapping + Generic DAO
 * @see http://www.hibernate.org/328.html
 */
public interface UserDAO extends GenericDAO<User,Long> {

	/*
	 * TODO : Add specific businesses daos here.
	 * These methods will be overwrited if you re-generate this interface.
	 * You might want to extend this interface and to change the dao factory to return 
	 * an instance of the new implemenation in buildUserDAO()
	 */
	  	 
	/**
	 * Find User by username
	 */
	public List<User> findByUsername(String username);

	/**
	 * Find User by password
	 */
	public List<User> findByPassword(String password);

	/**
	 * Find User by createDate
	 */
	public List<User> findByCreateDate(Timestamp createDate);

}