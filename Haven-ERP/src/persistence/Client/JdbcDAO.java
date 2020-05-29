package persistence.Client;

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

import bean.Client;
import bean.Staff;
import persistence.Executable;

import util.DBUtils;

public class JdbcDAO implements ClientDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Client> clientList = new ArrayList<Client>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM CLIENT");
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Client client  = new Client();
                client.setId(rs.getLong(1));
                client.setFname(rs.getString(2));
                client.setLname(rs.getString(3));
                client.setMail(rs.getString(4));
                client.setCc(rs.getInt(5));
                clientList.add(client);
            }
            
            
        });

        return clientList;
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Client> clientList = new ArrayList<Client>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("INSERT INTO CLIENT (NAME,LNAME,MAIL,CC) VALUES(?,?,?,?)");
            pst.setString(1, client.getFname());
            pst.setString(2, client.getLname());
            pst.setString(3, client.getMail());
            pst.setInt(4, client.getCc());
            
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
