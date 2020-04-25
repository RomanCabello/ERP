package service;

import bean.Staff;
import java.util.List;

public interface IStaffService {
	
	public List<Staff> findAllStaff();
	public void saveStaff(Staff staff);

}
