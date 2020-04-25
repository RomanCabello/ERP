package persistence;

import bean.Staff;
import java.util.List;

public interface StaffDAO {
	
	public List<Staff> findAll();
	public void saveStaff(Staff staff);

}
