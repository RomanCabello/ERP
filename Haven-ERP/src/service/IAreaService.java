package service;

import bean.Area;
import bean.Staff;
import java.util.List;

public interface IAreaService {
	
	public List<Area> findAllArea();
	public Area findArea(String name);

}
