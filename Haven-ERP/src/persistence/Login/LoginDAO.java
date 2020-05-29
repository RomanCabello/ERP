package persistence.Login;

import bean.Login;

public interface LoginDAO {
	
	public util.auth auth(String user, String pass);
	
	public void save(Login login);
	
	public void chpass(String pass);

}
