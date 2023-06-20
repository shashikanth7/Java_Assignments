package com.dal.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int did;
	private String dname;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + "]";
	}
	

}
