package model.pojo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import model.hibernate.HibernateUtil;
import model.hibernate.UserRoleHibernateDAO;

import org.hibernate.Session;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>Pojo mapping TABLE user</p>
 * <p></p>
 *
 * <p>Generated at Thu Mar 22 14:32:50 EET 2012</p>
 * @author Salto-db Generator v1.0.16 / Hibernate pojos and xml mapping files.
 * 
 */
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;

	public User(UserPojo userPojo) {
		this.id = userPojo.getId();
		this.username = userPojo.getUsername();
		this.password = userPojo.getPassword();
	}

	public Collection<GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> list = new HashSet<GrantedAuthority>();
		UserRoleHibernateDAO userRoleDao = new UserRoleHibernateDAO();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		userRoleDao.setSession(session);
		session.beginTransaction();
		Set<UserRole> userRoles = new HashSet<UserRole>(userRoleDao.findByUserId(id));
		for (UserRole userRole:userRoles){
			list.add(new SimpleGrantedAuthority(userRole.getRole().getName()));
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

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}
}