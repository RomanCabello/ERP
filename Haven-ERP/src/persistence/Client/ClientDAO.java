package persistence.Client;

import java.util.List;

import bean.Client;

public interface ClientDAO {
	public List<Client> findAll();
	public void save(Client client);
}
