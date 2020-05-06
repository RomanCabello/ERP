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
            
            pst = con.prepareStatement("INSERT INTO JOBS(SCON, SID, AID) VALUES(?, ?, ?)");
            pst.setString(1, job.getSdate());
            pst.setLong(2, job.getSid());
            pst.setLong(3, job.getAid());
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
