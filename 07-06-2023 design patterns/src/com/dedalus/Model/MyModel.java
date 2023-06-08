package com.dedalus.Model;

import java.io.Serializable;
import java.util.Comparator;

public class MyModel  implements Serializable {
	 private static MyModel instance = null;

	public MyModel() {
		//constructor
	}
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

	//method 
	 public static MyModel getInstance() {
	        if (instance == null) {
	            instance = new MyModel();
	        }
	        return instance;
	    }
	

	@Override
	public String toString() {
		return "MyModel [ename=" + ename + ", e_num=" + e_num + "]";
	}
	
	public int compareTo(MyModel st) {
		return this.e_num - st.e_num;
	}
	
	public static Comparator<MyModel> nameComparator =new Comparator<MyModel>() {
		
		public int compare(MyModel st1,MyModel st2) {
			return st1.getEname().compareTo(st2.getEname());
		}
	};
	
	

}
