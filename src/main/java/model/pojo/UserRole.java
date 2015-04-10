package model.pojo;

import java.util.List;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * <p>Pojo mapping TABLE user_role</p>
 * <p></p>
 *
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 * @author Salto-db Generator v1.0.16 / Hibernate pojos and xml mapping files.
 * 
 */
public class UserRole implements Serializable {

	/**
	 * Attribute id.
	 */
	private Long id;
	
	/**
	 * Attribute user
	 */
	 private User user;	

	/**
	 * Attribute role
	 */
	 private Role role;	

	
	/**
	 * <p> 
	 * </p>
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id new value for id 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * get user
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * set user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * get role
	 */
	public Role getRole() {
		return this.role;
	}
	
	/**
	 * set role
	 */
	public void setRole(Role role) {
		this.role = role;
	}



}