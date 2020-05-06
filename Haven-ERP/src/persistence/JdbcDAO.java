package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import java.sql.SQLException;
import javax.sql.DataSource;

import bean.Job;
import bean.Staff;
import util.DBUtils;

public class JdbcDAO implements StaffDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    
    
    @Override
    public void saveStaff(Staff staff) {
    	
    	try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	pst = con.prepareStatement("SELECT * FROM STAFF WHERE Id = (?)");
//        pst.setLong(1, id);
//        rs = pst.executeQuery();
//        
//        if (rs.next()) {
//            
//            staff.setId(rs.getLong(1));
//            staff.setFname(rs.getString(2));
//            staff.setLname(rs.getString(3));
//            staff.setSalary(rs.getInt(4));

        execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("INSERT INTO STAFF(FNAME, LNAME, SALARY) VALUES(?, ?, ?)" , 
            	      new String[] { "ID"});
            pst.setString(1, staff.getFname());
            pst.setString(2, staff.getLname());
            pst.setInt(3, staff.getSalary());
            pst.executeUpdate();
            
            ResultSet rs = pst.getGeneratedKeys();
            
            if (rs.next()) {
                
                staff.setId(rs.getLong(1));
            }
            
        });
    }
    
    @Override
    public void updateStaff(Staff staff) {
    	
    	try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("UPDATE STAFF SET FNAME = (?), LNAME = (?), SALARY = (?) WHERE ID = (?)" );
            pst.setString(1, staff.getFname());
            pst.setString(2, staff.getLname());
            pst.setInt(3, staff.getSalary());
            pst.setLong(4, staff.getId());
            pst.executeUpdate();
        });
    }
    
    @Override
    public void deleteStaff(Long id) {
    	
    	try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        execute(() -> {
            
        	con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("DELETE FROM STAFF WHERE Id = (?)");
            pst.setLong(1, id);
            pst.executeUpdate();
        });
    }
    
    
    @Override
    public Staff findStaff(Long id) {
    	
    	try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	

        Staff staff = new Staff();

        execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            
            pst = con.prepareStatement("SELECT * FROM STAFF WHERE Id = (?)");
            pst.setLong(1, id);
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                staff.setId(rs.getLong(1));
                staff.setFname(rs.getString(2));
                staff.setLname(rs.getString(3));
                staff.setSalary(rs.getInt(4));
            }
        });

        return staff;
    }
    
    

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Staff> staffList = new ArrayList<>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM STAFF");
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setId(rs.getLong(1));
                staff.setFname(rs.getString(2));
                staff.setLname(rs.getString(3));
                staff.setSalary(rs.getInt(4));
                staffList.add(staff);
            }
        });

        return staffList;
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
