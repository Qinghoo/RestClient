package com.tsxy.domain;

import java.io.Serializable;

public class Permission implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private int perid;
	private String pername;
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permission(int perid, String pername) {
		super();
		this.perid = perid;
		this.pername = pername;
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getPername() {
		return pername;
	}
	public void setPername(String pername) {
		this.pername = pername;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Permission [perid=" + perid + ", pername=" + pername + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + perid;
		result = prime * result + ((pername == null) ? 0 : pername.hashCode());
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
		Permission other = (Permission) obj;
		if (perid != other.perid)
			return false;
		if (pername == null) {
			if (other.pername != null)
				return false;
		} else if (!pername.equals(other.pername))
			return false;
		return true;
	}
	
}
