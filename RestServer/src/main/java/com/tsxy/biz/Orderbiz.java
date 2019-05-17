package com.tsxy.biz;

import java.util.Map;

import com.tsxy.domain.ShoppingCar;

public interface Orderbiz {//对订单和订单表的操作
	//打印小票订单存入数据库、将购物车传过来、加入到数据库表头和数据库订单行中
	public String addOrder(Object object);	
	//利用分组函数查出来第一个
	public Map<String, Integer> findGoodFood();
	//月销售量通过where条件截取30天之间
	public Map<String, Integer> findMonth();
	//集合
	public Object findOrderById(int uuid);
}
