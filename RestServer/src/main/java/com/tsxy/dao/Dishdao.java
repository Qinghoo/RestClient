package com.tsxy.dao;

import java.util.List;

import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;

public interface Dishdao {
	//添加菜
	public boolean insertDish(Dish dish);
	//添加菜品种类
	public boolean insertDishType(DishType dishType);
	//查询所有菜
	public List<Dish> selectAllDish();
	//根据Id查询菜
	public Dish selectByIdDish(int id);
	//查询所有菜种类
	public List<DishType> selectAllDishType();
	//根据Id查询菜种类
	public DishType selectByIdDishType(int id);
	//更新菜
	public boolean updateDish(Dish dish);
	//根据Id删除菜
	public boolean deleteByIdDish(int id);
	//更新菜品种类
	public boolean updateDishType(DishType dishType);
	//根据Id删除菜种类
	public boolean deleteByIdDishType(int dishtypeid);
}
