package com.dedalus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dedalus.Model.MyModel;

public class MyStudent {
	Scanner sc = new Scanner(System.in);
	MyModel st=new MyModel();

	public void Methodcall() {
		List emplist=new ArrayList<>();
		
		System.out.println("enter the name");
		String  enam=sc.next();
		st.setEname(enam);
		emplist.add(enam);
		System.out.println("enter the number");
		int nu=sc.nextInt();
		st.setE_num(nu);
		System.out.println(st.getEname());
		System.out.println(st.getE_num());
	}
    	public void viewMethod() {
 		System.out.println(st);
		
	}
    	 public void serialize() {
    	        try {
    	            FileOutputStream fileOut = new FileOutputStream("employees.ser");
    	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
    	            Object employees = null;
					objectOut.writeObject(employees);
    	            objectOut.close();
    	            fileOut.close();
    	            System.out.println("Serialization successful. Saved to employees.txt");
    	        } catch (IOException e) {
    	            System.out.println("Serialization error: " + e.getMessage());
    	        }
    	    }
    	}