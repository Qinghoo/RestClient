package com.tsxy.biz;

import java.util.List;

import com.tsxy.domain.Client;
import com.tsxy.domain.Emp;

public interface Empbiz {
	public String addEmp(Emp emp);
	//查询所有的员工
	public List<Emp> findAllEmp();
	//根据Id查询员工
	public Emp findByIdEmp(int id);
	//根据Id删除员工
	public String removeByIdEmp(int id);
	//根据对象来更改员工
	public String changeEmp(Emp emp);
		
}
