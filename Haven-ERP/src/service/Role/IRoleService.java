package service.Role;

import java.util.List;

import bean.Role;

public interface IRoleService {
	
	public List<Role> findAllRoles();
	public List<Role> findSomeRoles(String name);
	public Role findRole(String name);

}
