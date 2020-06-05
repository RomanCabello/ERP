package service.Login;
import bean.Login;
import util.auth;

public interface ILoginService {
	public auth auth(String user, String pass);
	
	public void save(Login login);
	
	public void chpass(String pass);
	
	public void delete(Long id);

}
