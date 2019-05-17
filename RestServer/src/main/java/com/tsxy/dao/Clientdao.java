package com.tsxy.dao;

import java.util.List;

import com.tsxy.domain.Client;

public interface Clientdao {
	public boolean insertClient(Client client);
	public boolean updateClientMoney(Client client);
	public boolean updateClientStatus(Client client);
	public boolean updateClient(Client client);
	public List<Client> selectAllClient();
	public Client selectByIdClient(int id);
	public boolean deleteByIdClient(int id);
}
