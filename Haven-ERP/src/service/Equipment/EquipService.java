package service.Equipment;

import java.util.List;

import bean.Equipment;
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

}
