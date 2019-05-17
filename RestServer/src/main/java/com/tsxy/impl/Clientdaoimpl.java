package com.tsxy.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsxy.dao.Clientdao;
import com.tsxy.domain.Client;
import com.tsxy.domain.MemberType;
import com.tsxy.util.DBUtil;

public class Clientdaoimpl implements Clientdao{
	private DBUtil dbUtil;
	public boolean insertClient(Client client) {
		this.dbUtil=new DBUtil();
		String sql="insert into client values(?,?,?,?,?,?,?,?,?)";
		try {
			int i = this.dbUtil.update(sql, client.getClientid(),
									client.getCliaccount(),
									client.getClipasswd(),
									client.getCliname(),
									client.getCliintegral(),
									client.getClitel(),
									client.getMemberType().getMembertypeid(),
									client.getStatus(),
									client.getMoney());
			dbUtil.closed();
			return i>0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据插入错误！");
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateClientMoney(Client client) {
		this.dbUtil=new DBUtil();
		String sql="update client set money=? where clientid=?";
		try {
			int i = this.dbUtil.update(sql, client.getMoney(),client.getClientid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("充值没更新");
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateClientStatus(Client client) {
		this.dbUtil=new DBUtil();
		String sql="update client set status=? where clientid=?";
		try {
			int i = this.dbUtil.update(sql, client.getStatus(),client.getClientid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
	}

	public boolean updateClient(Client client) {
		boolean deleteByIdClient = deleteByIdClient(client.getClientid());
		boolean insertClient = insertClient(client);
		return deleteByIdClient&&insertClient;
	}

	public List<Client> selectAllClient() {
		dbUtil=new DBUtil();
		try {
			ResultSet rs = this.dbUtil.query("select * from client c,membertype p where p.membertypeid=c.membertypeid");
			List<Client> list=new ArrayList<Client>();
			while (rs.next()) {
					list.add(new Client(rs.getInt("clientid"),  rs.getString("cliaccount"), rs.getString("clipasswd"),rs.getString("cliname"), rs.getInt("cliintegral"), rs.getString("clitel"), new MemberType(rs.getInt("membertypeid"), rs.getString("membertype")), rs.getInt("money"), rs.getString("status")));
			}
			dbUtil.closed();
			return list;
		} catch (SQLException e) {
			System.out.println("没有查询到");
			e.printStackTrace();
			return null;
		}
	}

	public Client selectByIdClient(int id) {
		List<Client> allClient = selectAllClient();
		for (Client client : allClient) {
			if (client.getClientid()==id) {
				return client;
			}
		}
		return null;
		
	}

	public boolean deleteByIdClient(int id) {
		dbUtil=new DBUtil();
		String sql="delete from client  where clientid=?";
		try {
			int i = dbUtil.update(sql, id);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}


}
