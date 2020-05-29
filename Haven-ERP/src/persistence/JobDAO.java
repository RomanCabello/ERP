package persistence;

import bean.Job;

public interface JobDAO {
	
	public void saveJob(Job job);
	
	public Job findJobBySID(Long id);
	
	public void modSal(int sal, Long id);
	
	public void endContract(Long id);

}
