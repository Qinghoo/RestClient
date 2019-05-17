package com.tsxy.impl;

import java.util.List;

import com.tsxy.biz.Empbiz;
import com.tsxy.dao.Empdao;
import com.tsxy.domain.Emp;

public class Empbizimpl implements Empbiz{
	private Empdao empdao;
	public Empbizimpl() {
		empdao=new Empdaoimpl();
	}

	public List<Emp> findAllEmp() {
		// TODO Auto-generated method stub
		return empdao.selectAllEmp();
	}

	public Emp findByIdEmp(int id) {
		// TODO Auto-generated method stub
		return empdao.selectByIdEmp(id);
	}

	public String removeByIdEmp(int id) {
		// TODO Auto-generated method stub
		return empdao.deleteByIdEmp(id)?"删除成功":"删除失败";
	}

	public String changeEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empdao.updateClient(emp)?"更新成功":"更新失败";
	}

	public String addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empdao.insertEmp(emp)?"添加成功":"添加失败";
	}

}
