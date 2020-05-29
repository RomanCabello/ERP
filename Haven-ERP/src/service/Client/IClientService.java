package service.Client;

import java.util.List;

import bean.Client;

public interface IClientService {
	
	public List<Client> findAll();
	public void save (Client client);

}
