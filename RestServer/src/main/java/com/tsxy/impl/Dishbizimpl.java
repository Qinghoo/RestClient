package com.tsxy.impl;

import java.util.List;

import com.tsxy.biz.Dishbiz;
import com.tsxy.dao.Dishdao;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;

public class Dishbizimpl implements Dishbiz{
	private Dishdao dishdao;
	

	public Dishbizimpl() {
		dishdao=new Dishdaoimpl();
	}

	public void addDish(Dish dish) {
		dishdao.insertDish(dish);
		
	}

	public void addDishType(DishType dishType) {
		// TODO Auto-generated method stub
		dishdao.insertDishType(dishType);
	}

	public List<Dish> findAllDish() {
		// TODO Auto-generated method stub
		return dishdao.selectAllDish();
	}

	public Dish findByIdDish(int id) {
		// TODO Auto-generated method stub
		return dishdao.selectByIdDish(id);
	}

	public List<DishType> findAllDishType() {
		// TODO Auto-generated method stub
		return dishdao.selectAllDishType();
	}

	public DishType findByIdDishType(int id) {
		// TODO Auto-generated method stub
		return dishdao.selectByIdDishType(id);
	}

	public String removeByIdDish(int id) {
		// TODO Auto-generated method stub
		return dishdao.deleteByIdDish(id)?"删除成功":"删除失败";
	}

	public String removeByIdDishType(int id) {
		// TODO Auto-generated method stub
		return dishdao.deleteByIdDishType(id)?"删除成功":"删除失败";
	}

	public String changeDish(Dish dish) {
		// TODO Auto-generated method stub
		return dishdao.updateDish(dish)?"修改成功":"修改失败";
	}

	public String changeDishType(DishType dishType) {
		// TODO Auto-generated method stub
		return dishdao.updateDishType(dishType)?"修改成功":"修改失败";

	}

}
