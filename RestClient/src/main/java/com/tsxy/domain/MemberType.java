package com.tsxy.domain;

import java.io.Serializable;

public class MemberType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1111;
	private int membertypeid;
	private String membertype;
	
	public MemberType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberType(int membertypeid, String membertype) {
		super();
		this.membertypeid = membertypeid;
		this.membertype = membertype;
	}

	public int getMembertypeid() {
		return membertypeid;
	}

	public void setMembertypeid(int membertypeid) {
		this.membertypeid = membertypeid;
	}

	public String getMembertype() {
		return membertype;
	}

	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}

	@Override
	public String toString() {
		return membertype ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((membertype == null) ? 0 : membertype.hashCode());
		result = prime * result + membertypeid;
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
		MemberType other = (MemberType) obj;
		if (membertype == null) {
			if (other.membertype != null)
				return false;
		} else if (!membertype.equals(other.membertype))
			return false;
		if (membertypeid != other.membertypeid)
			return false;
		return true;
	}
	
}
