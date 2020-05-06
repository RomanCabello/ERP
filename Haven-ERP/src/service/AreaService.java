package service;

import persistence.AreaDAO;
import persistence.DataA;

import java.util.List;

import bean.Area;

public class AreaService implements IAreaService{
	
	@Override
    public List<Area> findAllArea() {

        AreaDAO areaDAO = new DataA();
        return areaDAO.findAll();
    }
	
	@Override
    public Area findArea(String name) {

        AreaDAO staffDAO = new DataA();
        return staffDAO.findArea(name);
    }
	
	

}
