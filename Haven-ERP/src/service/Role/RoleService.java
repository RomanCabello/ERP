package service.Role;

import java.util.List;

import persistence.Role.JdbcDAO;
import persistence.Role.RoleDAO;
import bean.Role;

public class RoleService implements IRoleService{

	@Override
	public List<Role> findAllRoles() {
		// TODO Auto-generated method stub
		RoleDAO roleDAO = new JdbcDAO();
		return roleDAO.findAll();
	}

	@Override
	public List<Role> findSomeRoles(String name) {
		// TODO Auto-generated method stub
		RoleDAO roleDAO = new JdbcDAO();
		return roleDAO.semiAll(name);
	}

	@Override
	public Role findRole(String name) {
		// TODO Auto-generated method stub
		RoleDAO roleDAO = new JdbcDAO();
		return roleDAO.findRole(name);
	}

}
