package com.tsxy.dao;

import java.util.List;

import com.tsxy.domain.Client;
import com.tsxy.domain.Emp;

public interface Empdao {
	public boolean insertEmp(Emp emp);
	public List<Emp> selectAllEmp();
	public Emp selectByIdEmp(int id);
	public boolean deleteByIdEmp(int id);
	public boolean updateClient(Emp emp);
}
