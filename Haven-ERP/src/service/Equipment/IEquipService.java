package service.Equipment;

import java.util.List;

import bean.Equipment;

public interface IEquipService {
	public List<Equipment> findAll();
	public void save(Equipment equip);
	public List<Equipment> findBroken();
	
	public void use(Long id);
	
}
