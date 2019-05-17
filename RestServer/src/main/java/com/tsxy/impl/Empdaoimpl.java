package com.tsxy.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsxy.dao.Empdao;
import com.tsxy.domain.Dish;
import com.tsxy.domain.Emp;
import com.tsxy.domain.Permission;
import com.tsxy.util.DBUtil;

public class Empdaoimpl implements Empdao{
	private DBUtil dbUtil;
	public boolean insertEmp(Emp emp) {
		this.dbUtil=new DBUtil();
		String sql="insert into emp values(?,?,?,?,?,?,?)";
		try {
			int i = this.dbUtil.update(sql, emp.getEmpid(),
											emp.getEname(),
											emp.getEpasswd(),
											emp.getEaddress(),
											emp.getEtel(),
											emp.getEnum1(),
											emp.getPermission().getPerid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("插入员工错误");
			e.printStackTrace();
			return false;
		}
		
	}

	public List<Emp> selectAllEmp() {
		this.dbUtil=new DBUtil();
		String sql="select * from emp e,permission p where e.perid=p.perid";
		List<Emp> list=new ArrayList<Emp>();
		ResultSet rs;
		try {
			rs = dbUtil.query(sql);
			while (rs.next()) {
				list.add(new Emp(rs.getInt("empid"),
						rs.getString("ename"), 
						rs.getString("epasswd"), 
						rs.getString("eaddress"), 
						rs.getString("etel"), 
						rs.getString("enum"), 
						new Permission(rs.getInt("perid"),rs.getString("pername"))));
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询所有的员工错误");
			e.printStackTrace();
			return null;
		}
	}

	public Emp selectByIdEmp(int id) {
		List<Emp> emp = selectAllEmp();
		for (Emp emp2 : emp) {
			if (emp2.getEmpid()==id) {
				return emp2;
			}
		}
		return null;
	}

	public boolean deleteByIdEmp(int id) {
		this.dbUtil=new DBUtil();
		String sql="delete from emp where empid=?";
		try {
			int i = dbUtil.update(sql,id);
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除员工错误");
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateClient(Emp emp) {
		this.dbUtil=new DBUtil();
		String sql="update emp set ename=?,epasswd=?,eaddress=?,etel=?,enum=?,perid=? where empid=?";
		try {
			int i = this.dbUtil.update(sql, emp.getEname(),emp.getEpasswd(),emp.getEaddress(),emp.getEtel(),emp.getEnum1(),emp.getPermission().getPerid(),emp.getEmpid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("员工更新错误");
			e.printStackTrace();
			return false;
		}
	}

}
