package com.tsxy.domain;

import java.io.Serializable;

public class Emp implements Serializable{
	private int empid;
	private String ename;
	private String epasswd;
	private String eaddress;
	private String etel;
	private String enum1;
	private Permission permission;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int empid, String ename, String epasswd, String eaddress, String etel, String enum1,
			Permission permission) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.epasswd = epasswd;
		this.eaddress = eaddress;
		this.etel = etel;
		this.enum1 = enum1;
		this.permission = permission;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEpasswd() {
		return epasswd;
	}
	public void setEpasswd(String epasswd) {
		this.epasswd = epasswd;
	}
	public String getEaddress() {
		return eaddress;
	}
	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}
	public String getEtel() {
		return etel;
	}
	public void setEtel(String etel) {
		this.etel = etel;
	}
	public String getEnum1() {
		return enum1;
	}
	public void setEnum1(String enum1) {
		this.enum1 = enum1;
	}
	public Permission getPermission() {
		return permission;
	}
	public void setPermission(Permission permission) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return empid + "\t" + ename + "\t" + epasswd 
				+ "\t" + etel + "\t" + enum1 + "\t" + permission+ "\t" + eaddress;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eaddress == null) ? 0 : eaddress.hashCode());
		result = prime * result + empid;
		result = prime * result + ((ename == null) ? 0 : ename.hashCode());
		result = prime * result + ((enum1 == null) ? 0 : enum1.hashCode());
		result = prime * result + ((epasswd == null) ? 0 : epasswd.hashCode());
		result = prime * result + ((etel == null) ? 0 : etel.hashCode());
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
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
		Emp other = (Emp) obj;
		if (eaddress == null) {
			if (other.eaddress != null)
				return false;
		} else if (!eaddress.equals(other.eaddress))
			return false;
		if (empid != other.empid)
			return false;
		if (ename == null) {
			if (other.ename != null)
				return false;
		} else if (!ename.equals(other.ename))
			return false;
		if (enum1 == null) {
			if (other.enum1 != null)
				return false;
		} else if (!enum1.equals(other.enum1))
			return false;
		if (epasswd == null) {
			if (other.epasswd != null)
				return false;
		} else if (!epasswd.equals(other.epasswd))
			return false;
		if (etel == null) {
			if (other.etel != null)
				return false;
		} else if (!etel.equals(other.etel))
			return false;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		return true;
	}
	
	
}
