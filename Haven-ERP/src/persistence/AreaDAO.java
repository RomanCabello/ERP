package persistence;

import java.util.List;

import bean.Area;;

public interface AreaDAO {
	
	public List<Area> findAll();
	public Area findArea(String name);
	
}
