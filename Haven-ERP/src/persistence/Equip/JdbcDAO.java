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
import bean.Ticket;
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
	public void changeto(Long id, String status) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("UPDATE EQUIPMENT SET STATUS = (?) WHERE ID = (?)");
			pst.setString(1, status);
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


	@Override
	public void createTicket(Long sid, Long eid, String date, String note) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("INSERT INTO TICKET (SID, EID, NOTE, SDATE) VALUES(?,?,?,?)");
			pst.setLong(1,sid);
			pst.setLong(2,eid);
			pst.setString(3,note);
			pst.setString(4, date);
			
			pst.executeUpdate();
			
			
		});
		
	}


	@Override
	public void endticket(Long tid) {
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

			pst = con.prepareStatement("UPDATE  TICKET SET EDATE = (?) WHERE TID = (?)");
			pst.setString(1,edate);
			pst.setLong(2, tid);
			
			
			pst.executeUpdate();
			
			
		});
		
	}


	@Override
	public List<Ticket> AllTickets() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		execute(() -> {
			
			con = DriverManager.getConnection(DATA_SOURCE);

			pst = con.prepareStatement("SELECT * FROM TICKET");
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				Ticket ticket = new Ticket();
				ticket.setTid(rs.getLong(1));
				ticket.setSid(rs.getLong(2));
				ticket.setEid(rs.getLong(3));
				ticket.setNote(rs.getString(4));
				ticket.setSdate(rs.getString(5));
				ticket.setEdate(rs.getString(6));
				
				tickets.add(ticket);
			}
			
			
		});
		
		return tickets;
		
		
	}



	

}
