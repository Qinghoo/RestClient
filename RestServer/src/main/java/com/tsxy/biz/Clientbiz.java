package com.tsxy.biz;

import java.util.List;

import com.tsxy.domain.Client;
import com.tsxy.domain.Emp;

public interface Clientbiz {
	//添加客户，即开卡//补卡直接将Id改变
	public String addClient(Client client);
	//更改客户中的金额  充值
	public String changeClientMoney(Client client);
	//改变卡的状态，挂失等根据Id
	public String changeClientStatus(Client client);
	//整体信息修改
	public String changeClient(Client client);
	//查询所有的客户
	public List<Client> findAllClient();
	//根据Id查询客户
	public Client findByIdClient(int id);
	//根据Id删除客户
	public String removeByIdClient(int id);
}
