package com.tsxy.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tsxy.dao.Dishdao;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.util.DBUtil;

public class Dishdaoimpl implements Dishdao{
	private DBUtil dbUtil;
	public boolean insertDish(Dish dish) {
		dbUtil=new DBUtil();
		String sql="insert into dish values (?,?,?,?,?,?)";
		try {
			int i = this.dbUtil.update(sql, dish.getDishid(),
									dish.getDishname(),
									dish.getDishdepict(),
									dish.getDisprice(),
									dish.getDishtype().getDishtypeid(),
									dish.getDishstatus());
			dbUtil.closed();
			return i>0; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("菜单添加错误");
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertDishType(DishType dishType) {
		dbUtil=new DBUtil();
		String sql="insert into dishtype values (?,?)";
		try {
			int i = this.dbUtil.update(sql, dishType.getDishtypeid(),
					dishType.getDishtypename());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("菜品类别添加错误");
			e.printStackTrace();
			return false;
		}
	}

	public List<Dish> selectAllDish() {
		dbUtil=new DBUtil();
		String sql="select * from dish d,dishtype dt where d.dishtypeid=dt.dishtypeid";
		try {
			ResultSet rs = this.dbUtil.query(sql);
			List<Dish> list=new ArrayList<Dish>();
			while (rs.next()) {
				list.add(new Dish(rs.getInt("dishid"), 
								  rs.getString("dishname"), 
								  rs.getString("dishdepict"), 
								  rs.getDouble("dishprice"), 
								  new DishType(rs.getInt("dishtypeid"),rs.getString("dishtypename")), 
								  rs.getInt("dishstatus")));
				
			}
			dbUtil.closed();
			return list;
		} catch (SQLException e) {
			System.out.println("查询所有的菜品错误");
			e.printStackTrace();
			return null;
		}
	}

	public Dish selectByIdDish(int id) {
		List<Dish> selectAllDish = selectAllDish();
		for (Dish dish : selectAllDish) {
			if (dish.getDishid()==id) {
				return dish;
			}
		}
		return null;
	}

	public List<DishType> selectAllDishType() {
		dbUtil=new DBUtil();
		try {
			ResultSet resultSet = this.dbUtil.query("select * from dishtype");
			List<DishType> list=new ArrayList<DishType>();
			while (resultSet.next()) {
				list.add(new DishType(resultSet.getInt("dishtypeid"),resultSet.getString("dishtypename")));
			}
			dbUtil.closed();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("查询菜品类别错误");
			e.printStackTrace();
			return null;
		}
		
	}

	public DishType selectByIdDishType(int id) {
		List<DishType> selectAllDishType = selectAllDishType();
		for (DishType dishType : selectAllDishType) {
			if (dishType.getDishtypeid()==id) {
				return dishType;
			}
		}
		return null;
	}

	public boolean updateDish(Dish dish) {
		dbUtil = new DBUtil();
		String sql="update dish set dishname=?,dishdepict=?,dishprice=?,dishtypeid=?,dishstatus=? where dishid=?";
		try {
			int i = this.dbUtil.update(sql, dish.getDishname(),dish.getDishdepict(),dish.getDisprice(),dish.getDishtype().getDishtypeid(),dish.getDishstatus(),dish.getDishid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("菜品修改失败");
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteByIdDish(int id) {
		dbUtil=new DBUtil();
		String sql="delete from dish where dishid=?";
		try {
			int i = this.dbUtil.update(sql, id);
			dbUtil.closed();
			return i>1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("删除菜失败");
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean updateDishType(DishType dishType) {
		dbUtil = new DBUtil();
		String sql="update dishtype set dishtypename=? where dishtypeid=?";
		try {
			int i = this.dbUtil.update(sql, dishType.getDishtypename(),dishType.getDishtypeid());
			dbUtil.closed();
			return i>0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("菜类别修改失败");
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteByIdDishType(int dishtypeid) {
		dbUtil=new DBUtil();
		String sql="delete from dishtype where dishtypeid=?";
		try {
			int i = this.dbUtil.update(sql, dishtypeid);
			dbUtil.closed();
			return i>1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("修改菜类别失败");
			e.printStackTrace();
			return false;
		}
	}

}
