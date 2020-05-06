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

}
