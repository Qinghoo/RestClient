package com.tsxy.impl;

import java.util.Map;

import com.tsxy.biz.Orderbiz;
import com.tsxy.dao.Orderdao;

public class Orderbizimpl implements Orderbiz{
	private Orderdao orderdao;
	

	public Orderbizimpl() {
		orderdao=new Orderdaoimpl();
	}

	public String addOrder(Object object) {
		// TODO Auto-generated method stub
		return orderdao.insertOrder(object)?"插入成功":"插入失败";
	}

	public Map<String, Integer> findGoodFood() {
		// TODO Auto-generated method stub
		return orderdao.selectGoogFood();
	}

	public Map<String, Integer> findMonth() {
		// TODO Auto-generated method stub
		return orderdao.selectMonth();
	}

	public Object findOrderById(int id) {
		// TODO Auto-generated method stub
		return orderdao.selectOrderById(id);
	}

}
