package persistence.Equip;

import java.util.List;

import bean.Equipment;
import bean.Ticket;

public interface EquipDAO {
	
	public List<Equipment> findAll();
	public void save(Equipment equip);
	public List<Equipment> findBroken();
	public void changeto(Long id, String status);
	
	public void createTicket(Long sid, Long eid, String date, String note);
	public void endticket(Long tid);
	public List<Ticket> AllTickets();

}
