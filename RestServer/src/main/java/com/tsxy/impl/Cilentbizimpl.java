package com.tsxy.impl;

import java.util.List;

import com.tsxy.biz.Clientbiz;
import com.tsxy.dao.Clientdao;
import com.tsxy.domain.Client;

public class Cilentbizimpl implements Clientbiz{
	private Clientdao clientdao;

	public Cilentbizimpl() {
		clientdao=new Clientdaoimpl();
	}

	public String addClient(Client client) {
		// TODO Auto-generated method stub
		return clientdao.insertClient(client)?"添加成功":"添加失败";
	}

	public String changeClientMoney(Client client) {
		// TODO Auto-generated method stub
		return clientdao.updateClientMoney(client)?"充值成功":"充值失败";
	}

	public String changeClientStatus(Client client) {
		// TODO Auto-generated method stub
		return clientdao.updateClientStatus(client)?"挂失成功":"挂失失败";
	}

	public String changeClient(Client client) {
		// TODO Auto-generated method stub
		return clientdao.updateClient(client)?"修改成功":"修改失败";
	}

	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return clientdao.selectAllClient();
	}

	public Client findByIdClient(int id) {
		// TODO Auto-generated method stub
		return clientdao.selectByIdClient(id);
	}

	public String removeByIdClient(int id) {
		// TODO Auto-generated method stub
		return clientdao.deleteByIdClient(id)?"删除成功":"删除失败";
	}

}
