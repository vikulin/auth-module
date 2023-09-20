package viewmodel;

import java.util.Collection;

import org.zkoss.bind.annotation.Init;

import model.RoleDAO;
import model.hibernate.RoleHibernateDAO;
import model.pojo.Role;

public class UserViewModel {

	RoleDAO roleDAO;
	private Collection<Role> roleList;
	private Role role;

	public UserViewModel() {
		roleDAO = new RoleHibernateDAO();
	}

	@Init
	public void init() {
		roleList = roleDAO.findAll();
	}
    
	public Collection<Role> getRoles() {
		return roleList;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

}
