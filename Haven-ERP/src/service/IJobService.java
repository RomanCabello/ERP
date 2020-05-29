package service;

import bean.Job;

public interface IJobService {
	
	public void saveJob(Job job);
	public Job findJobBySID(Long id);
	public void modSal(int sal, Long id);
	public void endContract(Long id);

}
