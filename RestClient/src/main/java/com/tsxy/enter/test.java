package com.tsxy.enter;

import java.security.Provider.Service;

import com.tsxy.control.Control;
import com.tsxy.domain.Client;
import com.tsxy.domain.Dish;
import com.tsxy.domain.DishType;
import com.tsxy.domain.MemberType;
import com.tsxy.domain.ShoppingCar;

public class test {
	public static void main(String[] args) {
		/*DishType dishtype=new DishType(01,"川菜");
		DishType dishtype2=new DishType(02,"粤菜");
		DishType dishtype3=new DishType(03,"鲁菜");
		Dish sDish=new Dish(12, "鱼香肉丝", "香的不行", 18, dishtype);
		Dish sDish1=new Dish(21, "清蒸鲈鱼", "上好的野生鲈鱼", 23, dishtype2);
		Dish sDish2=new Dish(32, "煎饼果子", "纯天然无公害", 9, dishtype3);
		ShoppingCar car=new ShoppingCar();
		car.addDish(sDish);
		car.addDish(sDish2,23);
		car.print();*/
		new Control().Start();
		/*Client client=new Client(2, "1212", "123", "qwer", 0, "12312313213",new MemberType(1,"超级会员 "), 234, "持卡");
		new Control().name(client);*/
		
	}
}
