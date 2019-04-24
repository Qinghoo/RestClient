package com.tsxy.domain;

import java.io.Serializable;

public class Dish implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private int dishid;
	private String dishname;
	private String dishdepict;
	private Double disprice;
	private DishType dishtype;
	private int dishstatus;
	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dish(int dishid, String dishname, String dishdepict, Double disprice, DishType dishtype, int dishstatus) {
		super();
		this.dishid = dishid;
		this.dishname = dishname;
		this.dishdepict = dishdepict;
		this.disprice = disprice;
		this.dishtype = dishtype;
		this.dishstatus = dishstatus;
	}
	public int getDishid() {
		return dishid;
	}
	public void setDishid(int dishid) {
		this.dishid = dishid;
	}
	public String getDishname() {
		return dishname;
	}
	public void setDishname(String dishname) {
		this.dishname = dishname;
	}
	public String getDishdepict() {
		return dishdepict;
	}
	public void setDishdepict(String dishdepict) {
		this.dishdepict = dishdepict;
	}
	public double getDisprice() {
		return disprice;
	}
	public void setDisprice(Double disprice) {
		this.disprice = disprice;
	}
	public DishType getDishtype() {
		return dishtype;
	}
	public void setDishtype(DishType dishtype) {
		this.dishtype = dishtype;
	}
	public int getDishstatus() {
		return dishstatus;
	}
	public void setDishstatus(int dishstatus) {
		this.dishstatus = dishstatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return dishid+"\t"+dishname  + "\t"
				+ disprice + "\t" + dishtype.getDishtypename()+ "\t" + dishdepict  ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dishdepict == null) ? 0 : dishdepict.hashCode());
		result = prime * result + dishid;
		result = prime * result + ((dishname == null) ? 0 : dishname.hashCode());
		result = prime * result + dishstatus;
		result = prime * result + ((dishtype == null) ? 0 : dishtype.hashCode());
		result = prime * result + ((disprice == null) ? 0 : disprice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dish other = (Dish) obj;
		if (dishdepict == null) {
			if (other.dishdepict != null)
				return false;
		} else if (!dishdepict.equals(other.dishdepict))
			return false;
		if (dishid != other.dishid)
			return false;
		if (dishname == null) {
			if (other.dishname != null)
				return false;
		} else if (!dishname.equals(other.dishname))
			return false;
		if (dishstatus != other.dishstatus)
			return false;
		if (dishtype == null) {
			if (other.dishtype != null)
				return false;
		} else if (!dishtype.equals(other.dishtype))
			return false;
		if (disprice == null) {
			if (other.disprice != null)
				return false;
		} else if (!disprice.equals(other.disprice))
			return false;
		return true;
	}
	
	
}
