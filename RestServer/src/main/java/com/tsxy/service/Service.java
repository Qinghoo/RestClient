package com.tsxy.service;

import java.util.List;
import java.util.Map;

import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.Emp;


public interface Service {
	//------------------>客户操作
	//添加客户，即开卡//补卡直接将Id改变
	public String addClient(Client client);
	//更改客户中的金额  充值
	public String changeClientMoney(Client client);
	//改变卡的状态，挂失等根据Id
	public String changeClientStatus(Client client);
	//整体信息修改
	public String changeClient(Client client);
	//查询所有的客户
	public List<Client> findAllClient();
	//根据Id查询客户
	public Client findByIdClient(int id);
	//根据Id删除客户
	public String removeByIdClient(int id);
	//-------------->员工操作
	public String addEmp(Emp emp);
	//查询所有的员工
	public List<Emp> findAllEmp();
	//根据Id查询员工
	public Emp findByIdEmp(int id);
	//根据Id删除员工
	public String removeByIdEmp(int id);
	//根据对象来更改员工
	public String changeEmp(Emp emp);
	//------------------>菜单数据操作
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
	
	//-------------------->订单统计数据库操作
	//打印小票订单存入数据库、将购物车穿过来、加入到数据库表头和数据库订单行中
	public String addOrder(Object object);	
	//利用分组函数查出来第一个
	public Map<String, Integer> findGoodFood();
	//月销售量通过where条件截取30天之间
	public Map<String, Integer> findMonth();
	//集合
	public Object findOrderById(int id);
}


