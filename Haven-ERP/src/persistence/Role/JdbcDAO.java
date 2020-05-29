package persistence.Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import bean.Role;
import persistence.Executable;
import util.DBUtils;


public class JdbcDAO implements RoleDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
    
    
    
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Role> roleList = new ArrayList<>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM ROLES");
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong(1));
                role.setName(rs.getString(2));
                role.setAid(rs.getLong(3));
   
                roleList.add(role);
            }
        });

        return roleList;
	}
	
	
	@Override
	public List<Role> semiAll(String name) {
		// TODO Auto-generated method stub
		
		String filter = name;
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Role> roleList = new ArrayList<>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT ROLES.ROLEID, ROLES.RNAME FROM ROLES LEFT JOIN AREA ON ROLES.AID = AREA.ID WHERE AREA.ANAME = (?)");
            pst.setString(1, filter);
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getLong(1));
                role.setName(rs.getString(2));
   
                roleList.add(role);
            }
        });

        return roleList;
	}
	
	@Override
	public Role findRole(String name) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Role role = new Role();
		
		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM ROLES WHERE RNAME = (?)");
            pst.setString(1, name);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                role.setId(rs.getLong(1));
                role.setName(rs.getString(2));
                role.setAid(rs.getLong(3));
   
            }
        });
		
		return role;
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
