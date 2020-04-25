package service;

import bean.Staff;
import persistence.JdbcDAO;
import persistence.StaffDAO;
import java.util.List;

public class StaffService implements IStaffService{
	
	@Override
    public List<Staff> findAllStaff() {

        StaffDAO staffDAO = new JdbcDAO();
        return staffDAO.findAll();
    }
	
	@Override
	public void saveStaff(Staff staff) {
		
		StaffDAO staffDAO = new JdbcDAO();
		staffDAO.saveStaff(staff);
	}

}
