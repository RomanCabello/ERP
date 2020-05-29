package persistence.Equip;

import java.util.List;

import bean.Equipment;

public interface EquipDAO {
	
	public List<Equipment> findAll();
	public void save(Equipment equip);
	public List<Equipment> findBroken();

}
