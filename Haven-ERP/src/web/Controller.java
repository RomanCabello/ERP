package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Staff;
import service.IStaffService;
import service.StaffService;

/**
 * Servlet implementation class Controller
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ACTION_KEY = "action";
	
	private static final String ALL_STAFF_VIEW = "allStaff.jsp";
	
	private static final String UNKNOWN_VIEW = "unknown.jsp";
	
	private static final String LIST_STAFF_ACTION = "liststaff";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
		String page = UNKNOWN_VIEW;
		
		if (LIST_STAFF_ACTION.contentEquals(actionName)) {
			
			IStaffService service = new StaffService();
			
			request.setAttribute("staffList", service.findAllStaff());
			page = ALL_STAFF_VIEW;
		}
		
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/pages" + page);
        disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
