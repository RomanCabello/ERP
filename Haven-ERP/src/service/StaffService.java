package service;

import bean.Job;
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
    public Staff findStaff(Long id) {

        StaffDAO staffDAO = new JdbcDAO();
        return staffDAO.findStaff(id);
    }
	
	@Override
	public void saveStaff(Staff staff) {
		
		StaffDAO staffDAO = new JdbcDAO();
		staffDAO.saveStaff(staff);
	}
	
	@Override
	public void deleteStaff(Long id) {
		
		StaffDAO staffDAO = new JdbcDAO();
		staffDAO.deleteStaff(id);
	}
	
	@Override
	public void updateStaff(Staff staff) {
		
		StaffDAO staffDAO = new JdbcDAO();
		staffDAO.updateStaff(staff);
	}

	@Override
	public List<Staff> StaffFrom(Long id, String area) {
		// TODO Auto-generated method stub
		return null;
	}

}
