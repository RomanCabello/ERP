package persistence;

import bean.Job;
import bean.Staff;
import java.util.List;

public interface StaffDAO {
	
	public List<Staff> findAll();
	public void saveStaff(Staff staff);
	public Staff findStaff(Long id);
	void deleteStaff(Long id);
	void updateStaff(Staff staff);
	public List<Staff> StaffFrom(Long id, String area);
}
