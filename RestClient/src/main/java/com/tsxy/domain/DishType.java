package com.tsxy.domain;

import java.io.Serializable;

public class DishType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private int dishtypeid;
	private String dishtypename;
	public DishType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DishType(int dishtypeid, String dishtypename) {
		super();
		this.dishtypeid = dishtypeid;
		this.dishtypename = dishtypename;
	}
	public int getDishtypeid() {
		return dishtypeid;
	}
	public void setDishtypeid(int dishtypeid) {
		this.dishtypeid = dishtypeid;
	}
	public String getDishtypename() {
		return dishtypename;
	}
	public void setDishtypename(String dishtypename) {
		this.dishtypename = dishtypename;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return   dishtypeid+"\t"+dishtypename ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dishtypeid;
		result = prime * result + ((dishtypename == null) ? 0 : dishtypename.hashCode());
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
		DishType other = (DishType) obj;
		if (dishtypeid != other.dishtypeid)
			return false;
		if (dishtypename == null) {
			if (other.dishtypename != null)
				return false;
		} else if (!dishtypename.equals(other.dishtypename))
			return false;
		return true;
	}
	
}
