package persistence;

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

import bean.Area;

import util.DBUtils;

public class DataA implements AreaDAO{
	
	private static final String DATA_SOURCE = "jdbc:derby://localhost:1527/Haven;";
    private Connection con;
    private ResultSet rs;
    private PreparedStatement pst;

	@Override
	public List<Area> findAll() {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Area> areaList = new ArrayList<>();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM AREA");
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Area area = new Area();
                area.setId(rs.getLong(1));
                area.setName(rs.getString(2));
                areaList.add(area);
            }
        });

        return areaList;
	}

	@Override
	public Area findArea(String name) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Area area = new Area();

		execute(() -> {
            con = DriverManager.getConnection(DATA_SOURCE);
            pst = con.prepareStatement("SELECT * FROM AREA WHERE ANAME = (?)");
            pst.setString(1, name);
            
            rs = pst.executeQuery();
            
            if (rs.next()) {
                
                area.setId(rs.getLong(1));
                area.setName(rs.getString(2));
                
            }
        });

        return area;
		
		
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
