package com.tsxy.dao;

import java.util.Map;

public interface Orderdao {
	//此处的object购物车
	public  boolean insertOrder(Object object);
	//通过分组函数
	// select rownum,t.* from (select  deptno,count(*) from emp group by deptno order by deptno desc) t where rownum=1;
	public Map<String, Integer> selectGoogFood();
	//月销售量
	public Map<String, Integer> selectMonth();
	//返回一个购物车类型
	public Object selectOrderById(int uuid);
}
