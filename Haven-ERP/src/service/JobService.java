package service;

import bean.Job;
import persistence.JobDAO;
import persistence.JobData;

public class JobService implements IJobService{

	@Override
	public void saveJob(Job job) {
		
		JobDAO jobDAO = new JobData();
		jobDAO.saveJob(job);
		
	}

	@Override
	public Job findJobBySID(Long id) {
		// TODO Auto-generated method stub
		JobDAO jobDAO = new JobData();
		return jobDAO.findJobBySID(id);
	}

	@Override
	public void modSal(int sal, Long id) {
		// TODO Auto-generated method stub
		JobDAO jobDAO = new JobData();
		jobDAO.modSal(sal, id);
	}

	@Override
	public void endContract(Long id) {
		// TODO Auto-generated method stub
		JobDAO jobDAO = new JobData();
		jobDAO.endContract(id);
		
	}

}
