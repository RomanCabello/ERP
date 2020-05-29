package persistence.Equip;

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

import bean.Equipment;
import persistence.Executable;

import util.DBUtils;

public class JdbcDAO implements EquipDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;

	@Override
	public List<Equipment> findAll() {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Equipment> elist = new ArrayList<Equipment>();

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("SELECT * FROM EQUIPMENT");
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Equipment equip = new Equipment();
				equip.setId(rs.getLong(1));
				equip.setName(rs.getString(2));
				equip.setBdate(rs.getString(3));
				equip.setPrice(rs.getInt(4));
				equip.setStatus(rs.getString(5));
				
				elist.add(equip);
			}

		});
		
		return elist;
	}
	
	
	public List<Equipment> findBroken() {
		// TODO Auto-generated method stub

		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Equipment> elist = new ArrayList<Equipment>();

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("SELECT * FROM EQUIPMENT WHERE STATUS = 'BROKEN'");
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Equipment equip = new Equipment();
				equip.setId(rs.getLong(1));
				equip.setName(rs.getString(2));
				equip.setBdate(rs.getString(3));
				equip.setPrice(rs.getInt(4));
				equip.setStatus(rs.getString(5));
				
				elist.add(equip);
			}

		});
		
		return elist;
	}
	
	
	@Override
	public void save(Equipment equip) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("INSERT INTO EQUIPMENT (NAME, ACQ, PRICE, STATUS) VALUES(?,?,?,?)");
			pst.setString(1, equip.getName());
			pst.setString(2, equip.getBdate());
			pst.setDouble(3, equip.getPrice());
			pst.setString(4, equip.getStatus());
			
			pst.executeUpdate();
			
			
		});
		
	}
	
	
	
	@Override
	public void use(Long id) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("UPDATE EQUIPMENT SET STATUS = 'Unavailable' WHERE ID = (?)");
			pst.setLong(1, id);
			
			
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
