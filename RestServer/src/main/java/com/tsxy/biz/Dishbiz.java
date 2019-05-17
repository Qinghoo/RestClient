package com.tsxy.biz;

import java.util.List;

import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.Emp;

public interface Dishbiz {
	//添加菜
	public void addDish(Dish dish);
	//添加菜品种类
	public void addDishType(DishType dishType);
	//查询所有菜
	public List<Dish> findAllDish();
	//根据Id查询菜
	public Dish findByIdDish(int id);
	//查询所有的菜类别
	public List<DishType> findAllDishType();
	//根据Id查询菜类别
	public DishType findByIdDishType(int id);
	//根据Id删除菜
	public String removeByIdDish(int id);
	//根据id删除菜品
	public String removeByIdDishType(int id);
	//更新菜
	public String changeDish(Dish dish);
	//更新菜类别
	public String changeDishType(DishType dishType);
	
	
	
	
	

}
