package com.tsxy.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;


public class ShoppingCar implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private String uuid;
	private Map<Dish, Integer> dishMaps;
	private double sumPrice;
	private double shouPrice;
	private double zhaoPrice;
	private int empId;
	private String Rest;
	
	
	
	
	public ShoppingCar() {
	this.dishMaps = new HashMap<Dish, Integer>();
	sumPrice=0;
	uuid=UUID.randomUUID().toString().replace("-", "").toLowerCase();
	this.Rest="天津科技园店";
	
	}
	
	public Map<Dish, Integer> getDishMaps() {
		return dishMaps;
	}

	

	public double getShouPrice() {
		return shouPrice;
	}

	public void setShouPrice(double shouPrice) {
		this.shouPrice = shouPrice;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getUuid() {
		return uuid;
	}


	public double getSumPrice() {
		return sumPrice;
	}

	public double getZhaoPrice() {
		return zhaoPrice;
	}
	
	public String getRest() {
		return Rest;
	}

	public void setRest(String rest) {
		Rest = rest;
	}

	//添加商品
	public HashMap<Dish, Integer> addDish(Dish d){
		HashMap<Dish,Integer> addDish = addDish(d,1);
		return addDish;
	}
	//添加指定数量的商品
	public HashMap<Dish, Integer> addDish(Dish d, int i) {
		if (!dishMaps.containsKey(d)) {
			dishMaps.put(d, i);
		}else {
			int before = dishMaps.get(d).intValue();
			int after = before + i;
			dishMaps.put(d, after);
		}
		sumPrice+=d.getDisprice()*i;
		return (HashMap<Dish, Integer>) dishMaps;
	}
	
	//删除商品
	public HashMap<Dish, Integer> deleteDish(Dish d){
		
		return deleteDish(d,1);
	}
	//删除指定数量的商品
	public HashMap<Dish, Integer> deleteDish(Dish d, int i) {
		int before = this.dishMaps.get(d).intValue();
		if (before==i) {
			this.dishMaps.remove(d);
		}else {
			int after=before-i;
			this.dishMaps.put(d, after);
		}
		sumPrice-=d.getDisprice()*i;
		
		return (HashMap<Dish, Integer>) dishMaps;
		
	}
	//清空购物车
	public void clear() {
		dishMaps.clear();
		sumPrice=0;
	}
	//输出购物车详单
	public void print() {
		StringBuffer sb=new StringBuffer();
		DecimalFormat df = new DecimalFormat("#.00");
		sb.append("购物车箱单：\n");
		Set<Dish> dishs=dishMaps.keySet();
		Iterator<Dish> it=dishs.iterator();
		sb.append("\t数量\t菜品id\t菜名\t单价\t菜品种类\t库存\t总价\n");
		while (it.hasNext()) {
			Dish k=it.next();
			Integer v=dishMaps.get(k);
			sb.append("\t"+v.intValue()+"\t"+k+"\t"+df.format(v.intValue()*k.getDisprice())+"元\n");
		}
		this.zhaoPrice= this.shouPrice -sumPrice;
		sb.append("\t\t\t\t\t\t\t一共\t"+df.format(sumPrice)+"元");
		System.out.println(sb);
	}
	public void printxiaopiao() {
		StringBuffer sb=new StringBuffer();
		DecimalFormat df = new DecimalFormat("#.00");
		sb.append("小票详单：\n");
		Set<Dish> dishs=dishMaps.keySet();
		Iterator<Dish> it=dishs.iterator();
		sb.append("菜名\t数量\t单价\n");
		while (it.hasNext()) {
			Dish k=it.next();
			Integer v=dishMaps.get(k);
			sb.append(k.getDishname()+"\t"+v.intValue()+"\t"+k.getDisprice()+"元\n");
		}
		this.zhaoPrice= this.shouPrice -sumPrice;
		sb.append("总价：\t"+df.format(sumPrice)+"元");
		System.out.println(sb);
	}
}
