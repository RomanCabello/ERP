package service.Client;

import java.util.List;

import bean.Client;
import persistence.Client.ClientDAO;
import persistence.Client.JdbcDAO;

public class ClientService implements IClientService{

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		ClientDAO clientDAO = new JdbcDAO();
		return clientDAO.findAll();
	}

	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		
		ClientDAO clientDAO = new JdbcDAO();
		clientDAO.save(client);
		
	}

}
