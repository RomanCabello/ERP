package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Client;
import bean.Login;
import service.Client.ClientService;
import service.Client.IClientService;
import service.Login.ILoginService;
import service.Login.LoginService;
import util.auth;

/**
 * Servlet implementation class ControllerLog
 */
@WebServlet("/ControllerLog")
public class ControllerLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ACTION_KEY = "action";
	
	private static final String REGISTER_VIEW = "register.jsp";
	private static final String LOG_STAFF_VIEW = "i1";
	private static final String LOG_CLIENT_VIEW = "i2";
	private static final String ERROR = "Error";
	
	private static final String REGISTER_ACTION = "register";
	private static final String READ_ACTION = "read";
	
	private static final String LOG_STAFF = "logstaff";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String actionName = request.getParameter(ACTION_KEY);
		String page = "";
		
		
		
		if (READ_ACTION.equals(actionName)) {
			
			page = REGISTER_VIEW;
			
		}
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/" + page);
        disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		
		String actionName = request.getParameter(ACTION_KEY);
		String page = "";
		
		if (LOG_STAFF.equals(actionName)) {
			
			String mail = request.getParameter("LogMail");
			String pass = request.getParameter("LogPass");
			
			ILoginService service = new LoginService();
			
			
			auth a = service.auth(mail, pass);
			
			if(a.isFlag())
			{
				Login log  = a.getLogin();
				if(log.getAccess()<100)
				{
					page = LOG_CLIENT_VIEW;
				}else {
					page = LOG_STAFF_VIEW;
				}
			}else {
				page = ERROR;
			}

		}
		
		if(REGISTER_ACTION.equals(actionName))
		{
			String name =request.getParameter("Name");
			String lname = request.getParameter("Lname");
			String mail = request.getParameter("Mail");
			String pass = request.getParameter("Pass");
			int cc = Integer.parseInt(request.getParameter("CC"));
			
			Client client = new Client();
			client.setCc(cc);
			client.setFname(name);
			client.setLname(lname);
			client.setMail(mail);
			
			Login login = new Login();
			login.setAccess(1);
			login.setUsername(mail);
			login.setPassword(pass);
			
			IClientService service = new ClientService();
			ILoginService logservice = new LoginService();
			
			service.save(client);
			logservice.save(login);
			
			
			page = "login";
			
		}
		
		response.sendRedirect( page);
		
		
	}

}
