package web;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Area;
import bean.Equipment;
import bean.Job;
import bean.Login;
import bean.Role;
import bean.Staff;
import service.Role.IRoleService;
import service.Role.RoleService;
import service.AreaService;
import service.IAreaService;
import service.IJobService;
import service.IStaffService;
import service.JobService;
import service.StaffService;
import service.Equipment.EquipService;
import service.Equipment.IEquipService;
import service.Login.ILoginService;
import service.Login.LoginService;

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
	
	//////////////////////////////////////////////////////////////////EQUIPMENT///////////////////////////////////////////////////////////////
	
	private static final String LIST_EQUIP_ACTION = "listequip";
	private static final String READ_EQUIP_ACTION = "readequip";
	private static final String SAVE_EQUIP_ACTION = "savedequip";
	private static final String LIST_BROKEN_ACTION = "getbroken";
	
    private static final String ALL_EQUIP_VIEW = "AllEquip.jsp";
    private static final String READ_EQUIP_VIEW = "readEquip.jsp";
    private static final String EQUIP_SAVED_VIEW = "savedequip";
	
	
       
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
		String page = "";
		
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
			
			IJobService jservice = new JobService();
			jservice.endContract(id);
			
			
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
                
                IJobService jservice = new JobService();
                
                request.setAttribute("returnedJob", jservice.findJobBySID(staffId));
                
                

                page = UPDATE_STAFF_VIEW;
            
        }
		
		/////////////////////////////////////EQUIPMENT////////////////////////////////////////////////////////////////////////////////////////
		
		if (LIST_EQUIP_ACTION.contentEquals(actionName)) {

			IEquipService service = new EquipService();

			request.setAttribute("equipList", service.findAll());
			page = ALL_EQUIP_VIEW;
		}
		
		if (READ_EQUIP_ACTION.equals(actionName)) {
			
            page = READ_EQUIP_VIEW;
        }
		
		if(LIST_BROKEN_ACTION.equals(actionName))
		{
			IEquipService service = new EquipService();

			request.setAttribute("equipList", service.findBroken());
			page = ALL_EQUIP_VIEW;
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
			
			String id = request.getParameter("selectRole");
			
			
			
			IRoleService rs = new RoleService();
			Role role = rs.findRole(id);
			
			
			
			String sname = request.getParameter("staffName");
			String lname = request.getParameter("staffLname");
			int salary = Integer.parseInt(request.getParameter("staffSalary"));
			
			String mail = sname.charAt(0)+lname+"@haven.awesome";
			
			Staff staff = new Staff();
			Job job = new Job();
			staff.setFname(sname);
			staff.setLname(lname);
			staff.setMail(mail);
			
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);  
			String sdate = date.toString(); 
			
			
			
			IStaffService service = new StaffService();
			service.saveStaff(staff);
			
			job.setRid(role.getId());
			job.setSdate(sdate);
			job.setSid(staff.getId());
			job.setSalary(salary);
			
			IJobService jser = new JobService();
			jser.saveJob(job);
			
			String password;
			
			Timestamp ts1 = new Timestamp(System.nanoTime());
			password = Integer.toString(ts1.hashCode());
			
			Login login = new Login();
			login.setAccess(100);
			login.setUsername(mail);
			login.setPassword(password);
			
			ILoginService logservice = new LoginService();
			logservice.save(login);
			
			request.getSession().setAttribute("staffFname", staff.getFname());
			request.getSession().setAttribute("staffLname", staff.getLname());
			request.getSession().setAttribute("id", staff.getId());
			request.getSession().setAttribute("pass", password);
			
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
			int staffsal = Integer.parseInt(salary);
			
			IStaffService service = new StaffService();
			service.updateStaff(staff);
			
			IJobService jservice = new JobService();
			jservice.modSal(staffsal,id);
			
			
			
			
			request.getSession().setAttribute("staffFname", sname);
			request.getSession().setAttribute("staffLname", lname);
			request.getSession().setAttribute("staffSalary", salary);
			
			page = STAFF_SAVED_VIEW;
		}
		
		///////////////////////////////////////////////////////////////EQUIPMENT///////////////////////////////////////////////////////
		if(SAVE_EQUIP_ACTION.equals(actionName))
		{
			String name = request.getParameter("equipName");
			int price = Integer.parseInt(request.getParameter("equipPrice"));
			
			long millis = System.currentTimeMillis();
			String date = new java.sql.Date(millis).toString();
			
			Equipment equip = new Equipment();
			equip.setBdate(date);
			equip.setName(name);
			equip.setPrice(price);
			equip.setStatus("available");
			
			IEquipService service = new EquipService();
			service.save(equip);
			
			
			page = EQUIP_SAVED_VIEW;
			
		}
		
		response.sendRedirect( page);
		
	}

}
