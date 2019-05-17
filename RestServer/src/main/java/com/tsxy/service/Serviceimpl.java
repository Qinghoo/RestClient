package com.tsxy.service;

import java.util.List;
import java.util.Map;

import com.tsxy.biz.Clientbiz;
import com.tsxy.biz.Dishbiz;
import com.tsxy.biz.Empbiz;
import com.tsxy.biz.Orderbiz;
import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.Emp;
import com.tsxy.impl.Cilentbizimpl;
import com.tsxy.impl.Dishbizimpl;
import com.tsxy.impl.Empbizimpl;
import com.tsxy.impl.Orderbizimpl;

public class Serviceimpl implements Service {
	private Clientbiz clientbiz;
	private Empbiz empbiz;
	private Orderbiz orderbiz;
	private Dishbiz dishbiz;
	
	

	public Serviceimpl() {
		clientbiz=new Cilentbizimpl();
		dishbiz=new Dishbizimpl();
		orderbiz=new Orderbizimpl();
		empbiz=new Empbizimpl();
	}

	public String addClient(Client client) {
		return clientbiz.addClient(client);
	}

	public String changeClientMoney(Client client) {
		// TODO Auto-generated method stub
		return clientbiz.changeClientMoney(client);
	}

	public String changeClientStatus(Client client) {
		// TODO Auto-generated method stub
		return clientbiz.changeClientStatus(client);
	}

	public String changeClient(Client client) {
		// TODO Auto-generated method stub
		return clientbiz.changeClient(client);
	}

	public List<Client> findAllClient() {
		// TODO Auto-generated method stub
		return clientbiz.findAllClient();
	}

	public Client findByIdClient(int id) {
		// TODO Auto-generated method stub
		return clientbiz.findByIdClient(id);
	}

	public String removeByIdClient(int id) {
		// TODO Auto-generated method stub
		return clientbiz.removeByIdClient(id);
	}

	public List<Emp> findAllEmp() {
		// TODO Auto-generated method stub
		return empbiz.findAllEmp();
	}

	public Emp findByIdEmp(int id) {
		// TODO Auto-generated method stub
		return empbiz.findByIdEmp(id);
	}

	public String removeByIdEmp(int id) {
		// TODO Auto-generated method stub
		return empbiz.removeByIdEmp(id);
	}

	public String changeEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empbiz.changeEmp(emp);
	}

	public void addDish(Dish dish) {
		dishbiz.addDish(dish);
		
	}

	public void addDishType(DishType dishType) {
		dishbiz.addDishType(dishType);
		
	}

	public List<Dish> findAllDish() {
		// TODO Auto-generated method stub
		return dishbiz.findAllDish();
	}

	public Dish findByIdDish(int id) {
		// TODO Auto-generated method stub
		return dishbiz.findByIdDish(id);
	}

	public List<DishType> findAllDishType() {
		// TODO Auto-generated method stub
		return dishbiz.findAllDishType();
	}

	public DishType findByIdDishType(int id) {
		// TODO Auto-generated method stub
		return dishbiz.findByIdDishType(id);
	}

	public String removeByIdDish(int id) {
		// TODO Auto-generated method stub
		return dishbiz.removeByIdDish(id);
	}

	public String removeByIdDishType(int id) {
		// TODO Auto-generated method stub
		return dishbiz.removeByIdDishType(id);
	}

	public String changeDish(Dish dish) {
		// TODO Auto-generated method stub
		return dishbiz.changeDish(dish);
	}

	public String changeDishType(DishType dishType) {
		// TODO Auto-generated method stub
		return dishbiz.changeDishType(dishType);
	}

	public String addOrder(Object object) {
		// TODO Auto-generated method stub
		return orderbiz.addOrder(object);
	}

	public Map<String, Integer> findGoodFood() {
		// TODO Auto-generated method stub
		return orderbiz.findGoodFood();
	}

	public Map<String, Integer> findMonth() {
		// TODO Auto-generated method stub
		return orderbiz.findMonth();
	}

	public Object findOrderById(int id) {
		// TODO Auto-generated method stub
		return orderbiz.findOrderById(id);
	}

	public String addEmp(Emp emp) {
		// TODO Auto-generated method stub
		return empbiz.addEmp(emp);
	}

}
