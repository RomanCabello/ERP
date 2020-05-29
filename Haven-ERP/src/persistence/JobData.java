package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import bean.Job;
import util.DBUtils;

public class JobData implements JobDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    
    
    
	@Override
	public void saveJob(Job job) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

        execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("INSERT INTO JOBS(SCON, SID, RID, SALARY) VALUES(?, ?, ?, ?)");
            pst.setString(1, job.getSdate());
            pst.setLong(2, job.getSid());
            pst.setLong(3, job.getRid());
            pst.setInt(4, job.getSalary());
            pst.executeUpdate();
            
            
            
        });
		
	}
	
	
	@Override
	public Job findJobBySID(Long id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Job job = new Job();
		
		execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("SELECT * FROM JOBS WHERE SID = (?) AND ECON IS NULL");
            pst.setLong(1, id);
            
            rs = pst.executeQuery();
           
            
            if(rs.next())
            {
            	job.setId(rs.getLong(1));
            	job.setSdate(rs.getString(2));
            	job.setSid(rs.getLong(4));
            	job.setSalary(rs.getInt(5));
            	job.setRid(rs.getLong(6));
            	
            }
            
            
            
        });
		
		return job;
		
	}
	
	@Override
	public void modSal(int sal, Long id) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("UPDATE JOBS SET SALARY = (?) WHERE SID = (?)");
            pst.setInt(1, sal);
            pst.setLong(2, id);
            
            pst.executeUpdate();
    
            
        });
		
		
		
	}
	
	@Override
	public void endContract(Long id) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		String edate = date.toString(); 
		
		execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("UPDATE JOBS SET ECON = (?) WHERE SID = (?)");
            pst.setString(1, edate);
            pst.setLong(2, id);
            
            pst.executeUpdate();
    
            
        });
		
		
		
	}
	
	
	
	
	
	private void execute(Executable executable) {

        try {
            executable.exec();
        } catch (NamingException | SQLException e) {

            Logger lgr = Logger.getLogger(JdbcDAO.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);

        } finally {
            
            DBUtils.closeResultSet(rs);
            DBUtils.closeStatement(pst);
            DBUtils.closeConnection(con);
        }
    }


	





	

}
