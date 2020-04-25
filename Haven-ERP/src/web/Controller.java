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
//@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String ACTION_KEY = "action";
	
	private static final String ALL_STAFF_VIEW = "AllStaff.jsp";
	private static final String READ_STAFF_VIEW = "readStaff.jsp";
	private static final String STAFF_SAVED_VIEW = "staffSaved.jsp";
	
	private static final String UNKNOWN_VIEW = "unknown.jsp";
	
	private static final String LIST_STAFF_ACTION = "liststaff";
	private static final String READ_STAFF_ACTION = "readstaff";
	private static final String SAVE_STAFF_ACTION = "savestaff";
       
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
		if (READ_STAFF_ACTION.equals(actionName)) {
            page = READ_STAFF_VIEW;
        } 
		
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/pages/" + page);
        disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		
		String actionName = request.getParameter(ACTION_KEY);
		String page = UNKNOWN_VIEW;
		
		if(SAVE_STAFF_ACTION.equals(actionName)) {
			
			String sname = request.getParameter("staffName");
			String lname = request.getParameter("staffLname");
			String salary = request.getParameter("staffSalary");
			
			Staff staff = new Staff();
			staff.setFname(sname);
			staff.setLname(lname);
			staff.setSalary(Integer.valueOf(salary));
			
			page = STAFF_SAVED_VIEW;
			
		}
		
	}

}
