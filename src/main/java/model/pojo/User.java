package model.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.hibernate.HibernateUtil;
import model.hibernate.UserRoleHibernateDAO;

import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * <p>Pojo mapping TABLE user</p>
 * <p></p>
 *
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 * @author Salto-db Generator v1.0.16 / Hibernate pojos and xml mapping files.
 * 
 */
public class User implements Serializable, UserDetails {

	private static final long serialVersionUID = 1L;

	/**
	 * Attribute id.
	 */
	private Long id;
	
	/**
	 * Attribute username.
	 */
	private String username;
	
	/**
	 * Attribute password.
	 */
	private String password;
	
	/**
	 * Attribute createDate.
	 */
	private Timestamp createDate;
	
	/**
	 * List of UserRole
	 */
	private List<UserRole> userRoles = null;

	
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
	 * <p> 
	 * </p>
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username new value for username 
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password new value for password 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * <p> 
	 * </p>
	 * @return createDate
	 */
	public Timestamp getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate new value for createDate 
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * Get the list of UserRole
	 */
	 public List<UserRole> getUserRoles() {
	 	return this.userRoles;
	 }
	 
	/**
	 * Set the list of UserRole
	 */
	 public void setUserRoles(List<UserRole> userRoles) {
	 	this.userRoles = userRoles;
	 }

	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		UserRoleHibernateDAO userRoleDao = new UserRoleHibernateDAO();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		userRoleDao.setSession(session);
		session.beginTransaction();
		userRoles = userRoleDao.findByUserId(id);
		for (UserRole userRole:userRoles){
			list.add(new GrantedAuthorityImpl(userRole.getRole().getName()));
		}
		session.getTransaction().commit();
		return list;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}