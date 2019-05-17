package com.tsxy.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.sql.Time;
import java.text.SimpleDateFormat;

import com.tsxy.dao.Orderdao;
import com.tsxy.domain.Dish;
import com.tsxy.domain.ShoppingCar;
import com.tsxy.util.DBUtil;


public class Orderdaoimpl implements Orderdao{
	private DBUtil dbUtil;
	public boolean insertOrder(Object object) {
		//Object是一个购物车
		ShoppingCar car;
		Map<Dish, Integer> maps;
		if (object instanceof ShoppingCar) {
			car=(ShoppingCar)object;
			Date date=new Date();
			java.sql.Time c = new java.sql.Time(date.getTime());
			
			maps= car.getDishMaps();
			dbUtil=new DBUtil();
			String sql1="insert into order01 values (?,?,?,?,?,?,?)";
			String sql2="insert into ordertype values(?,?,?)";
			
			try {
				dbUtil.update(sql1, car.getUuid(),car.getEmpId(),c,car.getSumPrice(),car.getShouPrice(),car.getZhaoPrice(),car.getRest());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("插入订单错误");
				e1.printStackTrace();
			}
			
			Set<Dish> keys = maps.keySet();
			Iterator<Dish> it = keys.iterator();
			while(it.hasNext()){
				Dish k = it.next();
				Integer v = maps.get(k);
				try {
					int i = dbUtil.update(sql2,k.getDishid(),v.intValue(),car.getUuid());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("插入订单行中的商品有误");
					e.printStackTrace();
				}
				
				
			}
			return true;
		}
		
		
		return false;
	}

	public Map<String, Integer> selectGoogFood() {
		// select rownum,t.* from (select  deptno,sum(sal) from emp group by deptno order by deptno desc) t where rownum=1;
		dbUtil=new DBUtil();
		Map<String, Integer> maps=new HashMap<String, Integer>();
		String sql="select rownum,t.* from (select  d.dishname,sum(dishvalues)  from ordertype o,dish d where d.dishid=o.dishid group by d.dishname order by sum(dishvalues) desc) t where rownum<4";
		try {
			ResultSet resultSet = dbUtil.query(sql);
			while (resultSet.next()) {
				StringBuffer sb=new StringBuffer();
				sb.append(resultSet.getString("rownum"));
				sb.append("\t");
				sb.append(resultSet.getString("DISHNAME"));
				
				
				maps.put(sb.toString(), new Integer(resultSet.getString("SUM(DISHVALUES)")));
				//输出数据库中查到的数据
			}
			return maps;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("没查出来热销");
			e.printStackTrace();
			return null;
		}
	}

	public Map<String, Integer> selectMonth() {
		
		//月销量
		this.dbUtil=new DBUtil();
		Map<String, Integer> maps=new HashMap<String, Integer>();
		/*select  d.dishname,sum(dishvalues)  
		from ordertype o,dish d,order01 oo
		where d.dishid=o.dishid and oo.orderid=o.orderid and oo.orderdate between sysdate-30 and sysdate
		group by d.dishname 
		order by sum(dishvalues) desc;
		进30天的销量
		*/

		
		String sql="select  d.dishname,sum(dishvalues) from ordertype o,dish d,order01 oo "
				+ "where d.dishid=o.dishid and oo.orderid=o.orderid and oo.orderdate "
				+ "between sysdate-30 and sysdate group by d.dishname order by sum(dishvalues) desc";//加上月的限制
		try {
			ResultSet resultSet = this.dbUtil.query(sql);
			int i=0;
			//map集合存储键值对
			while (resultSet.next()) {
				i++;
				StringBuffer sb=new StringBuffer();
				sb.append(i+"\t");
				sb.append(resultSet.getString("DISHNAME"));
				maps.put(sb.toString(), new Integer(resultSet.getString("SUM(DISHVALUES)")));
			}
			return maps;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("没有查询出来");
			e.printStackTrace();
			return null;
		}
		
		
	}

	public Object selectOrderById(int uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	/*public Object selectOrderById(int uuid) {
		//查询订单
		//两个list 集合嵌套
		this.dbUtil=new DBUtil();
		String sql="";
		try {
			ResultSet resultSet = this.dbUtil.query(sql, uuid);
			//遍历只有一个
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return null;
	}*/

}
