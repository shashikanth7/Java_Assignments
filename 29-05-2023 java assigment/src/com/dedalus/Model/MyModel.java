package com.dedalus.Model;

import java.io.Serializable;

public class MyModel implements Serializable {

	private String ename;
	
	
	
	

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}
	private int e_num;

	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	@Override
	public String toString() {
		return "MyModel [ename=" + ename + ", e_num=" + e_num + "]";
	}
	
	
	
}
