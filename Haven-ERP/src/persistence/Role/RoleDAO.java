package persistence.Role;

import java.util.List;

import bean.Role;

public interface RoleDAO {
	
	public List<Role> findAll();
	public List<Role> semiAll(String name);
	public Role	findRole(String name);
	

}
