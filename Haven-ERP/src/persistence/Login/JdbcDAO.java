package persistence.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;

import bean.Login;
import persistence.Executable;
import util.DBUtils;

public class JdbcDAO implements LoginDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;
	

	@Override
	public util.auth auth(String user, String pass) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		util.auth auth = new util.auth();
		
		execute(() -> {
			
			

			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("SELECT * FROM LOGIN WHERE MAIL=(?) AND PASS = (?)");
			pst.setString(1, user);
			pst.setString(2, pass);
			
			rs = pst.executeQuery();
			
			if (rs.next())
			{
				Login login = new Login();
				login.setUsername(rs.getString(2));
				login.setPassword(rs.getString(3));
				login.setAccess(rs.getInt(4));
				
				auth.setFlag(true);
				auth.setLogin(login);
				
			}else {
				auth.setFlag(false);
			}

		});
		
		return auth;
	}

	@Override
	public void save(Login login) {
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("INSERT INTO LOGIN (MAIL,PASS,ACCESS) VALUES(?,?,?)");
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getPassword());
			pst.setInt(3, login.getAccess());
			
			pst.executeUpdate();
			
		});
		

		
	}

	@Override
	public void chpass(String pass) {
		// TODO Auto-generated method stub
		
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
