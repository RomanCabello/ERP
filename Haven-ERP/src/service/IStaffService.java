package service;

import bean.Job;
import bean.Staff;
import java.util.List;

public interface IStaffService {
	
	public List<Staff> findAllStaff();
	public void saveStaff(Staff staff);
	public Staff findStaff(Long id);
	void deleteStaff(Long id);
	void updateStaff(Staff staff);

}
