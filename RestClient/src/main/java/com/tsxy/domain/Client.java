package com.tsxy.domain;

import java.io.Serializable;

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private int clientid;
	private String cliaccount;
	private String clipasswd;
	private String cliname;
	private int cliintegral;
	private String clitel;
	private MemberType memberType;
	private int money;
	private String status;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int clientid, String cliaccount, String clipasswd, String cliname, int cliintegral, String clitel,
			MemberType memberType, int money, String status) {
		super();
		this.clientid = clientid;
		this.cliaccount = cliaccount;
		this.clipasswd = clipasswd;
		this.cliname = cliname;
		this.cliintegral = cliintegral;
		this.clitel = clitel;
		this.memberType = memberType;
		this.money = money;
		this.status = status;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getCliaccount() {
		return cliaccount;
	}
	public void setCliaccount(String cliaccount) {
		this.cliaccount = cliaccount;
	}
	public String getClipasswd() {
		return clipasswd;
	}
	public void setClipasswd(String clipasswd) {
		this.clipasswd = clipasswd;
	}
	public String getCliname() {
		return cliname;
	}
	public void setCliname(String cliname) {
		this.cliname = cliname;
	}
	public int getCliintegral() {
		return cliintegral;
	}
	public void setCliintegral(int cliintegral) {
		this.cliintegral = cliintegral;
	}
	public String getClitel() {
		return clitel;
	}
	public void setClitel(String clitel) {
		this.clitel = clitel;
	}
	public MemberType getMemberType() {
		return memberType;
	}
	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return clientid + "\t"
				+ cliname + "\t" + cliintegral + "\t" + clitel + "\t" + memberType
				+ "\t" + money + "\t" + status ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliaccount == null) ? 0 : cliaccount.hashCode());
		result = prime * result + clientid;
		result = prime * result + cliintegral;
		result = prime * result + ((cliname == null) ? 0 : cliname.hashCode());
		result = prime * result + ((clipasswd == null) ? 0 : clipasswd.hashCode());
		result = prime * result + ((clitel == null) ? 0 : clitel.hashCode());
		result = prime * result + ((memberType == null) ? 0 : memberType.hashCode());
		result = prime * result + money;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Client other = (Client) obj;
		if (cliaccount == null) {
			if (other.cliaccount != null)
				return false;
		} else if (!cliaccount.equals(other.cliaccount))
			return false;
		if (clientid != other.clientid)
			return false;
		if (cliintegral != other.cliintegral)
			return false;
		if (cliname == null) {
			if (other.cliname != null)
				return false;
		} else if (!cliname.equals(other.cliname))
			return false;
		if (clipasswd == null) {
			if (other.clipasswd != null)
				return false;
		} else if (!clipasswd.equals(other.clipasswd))
			return false;
		if (clitel == null) {
			if (other.clitel != null)
				return false;
		} else if (!clitel.equals(other.clitel))
			return false;
		if (memberType == null) {
			if (other.memberType != null)
				return false;
		} else if (!memberType.equals(other.memberType))
			return false;
		if (money != other.money)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
