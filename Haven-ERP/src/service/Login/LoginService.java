package service.Login;

import bean.Login;
import persistence.Login.JdbcDAO;
import persistence.Login.LoginDAO;

public class LoginService implements ILoginService{

	@Override
	public util.auth auth(String user, String pass) {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new JdbcDAO();
		return loginDAO.auth(user, pass);
	}

	@Override
	public void save(Login login) {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new JdbcDAO();
		loginDAO.save(login);
		
	}

	@Override
	public void chpass(String pass) {
		// TODO Auto-generated method stub
		LoginDAO loginDAO = new JdbcDAO();
		loginDAO.chpass(pass);
		
	}

}
