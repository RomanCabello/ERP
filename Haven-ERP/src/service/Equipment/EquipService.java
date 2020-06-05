package service.Equipment;

import java.util.List;

import bean.Equipment;
import bean.Ticket;
import persistence.Equip.EquipDAO;
import persistence.Equip.JdbcDAO;

public class EquipService implements IEquipService{

	@Override
	public List<Equipment> findAll() {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		return equipDAO.findAll();
	}

	@Override
	public void save(Equipment equip) {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		equipDAO.save(equip);
		
	}

	@Override
	public List<Equipment> findBroken() {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		return equipDAO.findBroken();
	}

	@Override
	public void changeto(Long id, String status) {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		equipDAO.changeto(id,status);
	}

	@Override
	public void createTicket(Long sid, Long eid, String date, String note) {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		equipDAO.createTicket(sid, eid, date, note);
		
	}

	@Override
	public void endticket(Long tid) {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		equipDAO.endticket(tid);
		
	}

	@Override
	public List<Ticket> AllTickets() {
		// TODO Auto-generated method stub
		EquipDAO equipDAO = new JdbcDAO();
		return equipDAO.AllTickets();
	}

	
	
	

}
