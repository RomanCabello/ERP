package web;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Area;
import bean.Job;
import bean.Staff;
import service.AreaService;
import service.IAreaService;
import service.IJobService;
import service.IStaffService;
import service.JobService;
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
	private static final String STAFF_SAVED_VIEW = "savedstaff";
	private static final String READ_STAFF_BY_ID_VIEW = "readStaffId.jsp";
    private static final String SHOW_STAFF_VIEW = "showStaff.jsp";
    private static final String UPDATE_STAFF_VIEW = "updateStaff.jsp";
	
	private static final String UNKNOWN_VIEW = "unknown.jsp";
	
	private static final String DELETE_STAFF_ACTION = "deletestaff";
	private static final String LIST_STAFF_ACTION = "liststaff";
	private static final String READ_STAFF_BY_ID_ACTION = "readbyid";
	private static final String READ_STAFF_ACTION = "readstaff";
	private static final String SAVE_STAFF_ACTION = "savestaff";
	private static final String VIEW_STAFF_ACTION = "viewstaff";
	private static final String CHANGE_STAFF_ACTION = "changestaff";
	private static final String UPDATE_STAFF_ACTION = "updatestaff";
	
	
       
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
			IAreaService service = new AreaService();
			
			request.setAttribute("areaList", service.findAllArea());
			
            page = READ_STAFF_VIEW;
        } 
		
		if (READ_STAFF_BY_ID_ACTION.equals(actionName)) {
            page = READ_STAFF_BY_ID_VIEW;
        }
		if(DELETE_STAFF_ACTION.equals(actionName))
		{
			Long id = Long.valueOf(request.getParameter("del"));
			IStaffService service = new StaffService();
			service.deleteStaff(id);
			
			
			request.setAttribute("staffList", service.findAllStaff());
			
			page = ALL_STAFF_VIEW;
		}

		
		if (VIEW_STAFF_ACTION.equals(actionName)) {

            String sid = request.getParameter("staffId");

            

                IStaffService service = new StaffService();
                Long staffId = Long.valueOf(sid);
                request.setAttribute("returnedStaff", service.findStaff(staffId));

                page = SHOW_STAFF_VIEW;
            
        }
		
		if (CHANGE_STAFF_ACTION.equals(actionName)) {

            String sid = request.getParameter("upd");

            

                IStaffService service = new StaffService();
                Long staffId = Long.valueOf(sid);
                request.setAttribute("returnedStaff", service.findStaff(staffId));

                page = UPDATE_STAFF_VIEW;
            
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
			
			String aname = request.getParameter("area");
			
			IAreaService ser =  new AreaService();
			Area area = ser.findArea(aname);
			
			Long id = area.getId();
			
			String sname = request.getParameter("staffName");
			String lname = request.getParameter("staffLname");
			String salary = request.getParameter("staffSalary");
			
			Staff staff = new Staff();
			Job job = new Job();
			staff.setFname(sname);
			staff.setLname(lname);
			staff.setSalary(Integer.valueOf(salary));
			
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
			String sdate = date.toString(); 
			
			
			
			IStaffService service = new StaffService();
			service.saveStaff(staff);
			
			job.setAid(id);
			job.setSdate(sdate);
			job.setSid(staff.getId());
			
			IJobService jser = new JobService();
			jser.saveJob(job);
			
			
			request.getSession().setAttribute("staffFname", staff.getFname());
			request.getSession().setAttribute("staffLname", staff.getLname());
			request.getSession().setAttribute("staffSalary", staff.getSalary());
			request.getSession().setAttribute("id", staff.getId());
			
			page = STAFF_SAVED_VIEW;
			
		}
		
		if(UPDATE_STAFF_ACTION.equals(actionName))
		{
			Long id = Long.valueOf(request.getParameter("id"));
			String sname = request.getParameter("staffName");
			String lname = request.getParameter("staffLname");
			String salary = request.getParameter("staffSalary");
			
			Staff staff = new Staff();
			staff.setId(id);
			staff.setFname(sname);
			staff.setLname(lname);
			staff.setSalary(Integer.valueOf(salary));
			
			IStaffService service = new StaffService();
			service.updateStaff(staff);
			
			
			request.getSession().setAttribute("staffFname", sname);
			request.getSession().setAttribute("staffLname", lname);
			request.getSession().setAttribute("staffSalary", salary);
			
			page = STAFF_SAVED_VIEW;
		}
		
		response.sendRedirect( page);
		
	}

}
