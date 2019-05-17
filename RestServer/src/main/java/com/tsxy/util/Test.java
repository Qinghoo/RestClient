package com.tsxy.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.tsxy.control.SControl;
import com.tsxy.dao.Clientdao;
import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.Emp;
import com.tsxy.domain.MemberType;
import com.tsxy.domain.Permission;
import com.tsxy.domain.ShoppingCar;
import com.tsxy.impl.Clientdaoimpl;
import com.tsxy.impl.Empdaoimpl;
import com.tsxy.service.Service;
import com.tsxy.service.Serviceimpl;


public class Test {
	public static void main(String[] args) {
		/*DishType dishtype=new DishType(01,"川菜");
		DishType dishtype2=new DishType(02,"粤菜");
		DishType dishtype3=new DishType(03,"鲁菜");
		Dish sDish=new Dish(12, "鱼香肉丝", "香的不行", 18.8, dishtype,1);
		Dish sDish1=new Dish(21, "清蒸鲈鱼", "上好的野生鲈鱼", 23.0, dishtype2,1);
		Dish sDish2=new Dish(32, "煎饼果子", "纯天然无公害", 9.0, dishtype3,1);
		ShoppingCar car=new ShoppingCar();
		car.addDish(sDish);
		car.addDish(sDish2,23);
		Service service=new Serviceimpl();
		service.findGoodFood()
		*/
		/*String uuid=UUID.randomUUID().toString().replace("-", "").toLowerCase();
		System.out.println(Integer.parseInt(uuid));*/
		new SControl().start();
		//new Empdaoimpl().insertEmp(new Emp(4,"李进","123","唐山市大学西道159号","18793140555","132582199803066666",new Permission(2,"普通员工")));
		/*new Serviceimpl().removeByIdEmp(4);
		List<Emp> selectAllEmp = new Serviceimpl().findAllEmp();
		System.out.println(selectAllEmp);*/
		
		
		/*MemberType memberType=new MemberType(1, "超级会员");
		Client client=new Client(1, "123", "123", "lqh", 5, "13293140469", memberType, 0, "持卡");
		//Client client1=new Client(2, "2", "123", "zxt", 5, "18732893231", memberType, 0, "持卡");
		Clientdao clientdao=new Clientdaoimpl();
	//	boolean insertClient = clientdao.insertClient(client);
		clientdao.insertClient(client);
		List<Client> selectAllClient = clientdao.selectAllClient();
		for (Client client2 : selectAllClient) {
			System.out.println(client2);
		}
		Clientdao clientdao=new Clientdaoimpl();
		System.out.println(clientdao.selectByIdClient(1));
		clientdao.deleteByIdClient(1);
		List<Client> AllClient = clientdao.selectAllClient();
		for (Client client3 : AllClient) {
			System.out.println(client3);
		}
		
		System.out.println("12323");
		//insert into client values(1, "123", "123", "lqh", 5, "13293140469", memberType, 0, "持卡");
		
		
		SControl control=new SControl();
		control.start();
		List< Dish> list=new ArrayList<Dish>();
		
		DishType dishtype=new DishType(01,"川菜");
		DishType dishtype2=new DishType(02,"粤菜");
		DishType dishtype3=new DishType(03,"鲁菜");
		Dish sDish=new Dish(12, "鱼香肉丝", "香的不行", 18, dishtype);
		Dish sDish1=new Dish(21, "清蒸鲈鱼", "上好的野生鲈鱼", 23, dishtype2);
		Dish sDish2=new Dish(32, "煎饼果子", "纯天然无公害", 9, dishtype3);
		ShoppingCar car=new ShoppingCar();
//		car.addDish(sDish);
		HashMap<Dish,Integer> addDish = car.addDish(sDish2,23);
		Object object=addDish;
		HashMap<Dish,Integer> qqq=(HashMap<Dish,Integer>)object;
		StringBuffer sb=new StringBuffer();
		sb.append("购物车箱单：\n");
		Set<Dish> dishs=qqq.keySet();
		Iterator<Dish> it=dishs.iterator();
		while (it.hasNext()) {
			Dish k=it.next();
			Integer v=qqq.get(k);
			sb.append("\t"+v.intValue()+"\t"+k+"\t"+v.intValue()*k.getDisprice()+"元\n");
		}
		sb.append("\t\t\t\t\t\t\t一共\t"+100+"元");
		System.out.println(sb+"dshf");
		//car.print();
		car.clear();
		car.print();
		DBUtil dbUtil=new DBUtil();
		dbUtil.closed();
	*/
	}
}
