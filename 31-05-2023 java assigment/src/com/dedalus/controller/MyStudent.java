package com.dedalus.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dedalus.Model.MyModel;
import com.dal.dao.EmployeeDao;

public class MyStudent {
    Scanner sc = new Scanner(System.in);
    MyModel st = new MyModel();
    List<String> employees = new ArrayList<>();
    EmployeeDao empdao = new EmployeeDao();
    public void methodCall() {
        System.out.println("Enter the name:");
        String name = sc.next();
        st.setEname(name);
        employees.add(name);

        System.out.println("Enter the number:");
        int number = sc.nextInt();
        st.setE_num(number);

        System.out.println(st.getEname());
        System.out.println(st.getE_num());
        ///
       
        
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employees:");
            employees.forEach(System.out::println);
            }
        System.out.println("Dataas from DB:");
		empdao.showEmployee();
        }
    
    
    public void addEmployee() {
    	MyModel st = new MyModel();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String name = sc.nextLine();
        System.out.println("Enter employee number:");
        int num1=sc.nextInt();
        String num = sc.nextLine();
        st.setE_num(num1);
        st.setEname(name);
        employees.add(name);
        employees.add(num);
        
        empdao.insertEmployee(st);
		System.out.println("Employee Added Successfully");
    }

    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream("employees.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(employees);
            objectOut.close();
            fileOut.close();
            System.out.println("Serialization successful. Saved to employees.txt");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }
    
    public void deserialize() {
   	 try {
   	        FileInputStream fileIn = new FileInputStream("employees.ser");
   	        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
   	        employees = (List<String>) objectIn.readObject();
   	        objectIn.close();
   	        fileIn.close();
   	        System.out.println("Deserialization successful. Loaded employees from employees.ser");
   	        System.out.println("Employees:");
   	        for (String employee : employees) {
   	            System.out.println(employee);
   	        }
   	    } catch (IOException | ClassNotFoundException e) {
   	        System.out.println("Deserialization error: " + e.getMessage());
   	    }
   }
    public void Delet() {
    	
    	MyModel st = new MyModel();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee number:");
        int num1=sc.nextInt();
        st.setE_num(num1); 	
        empdao.DeletEmployee(st);
    }
    
  public void update() {
    	
	  MyModel st = new MyModel();
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter employee name:");
      String name = sc.nextLine();
      System.out.println("Enter employee number:");
      int num1=sc.nextInt();
      String num = sc.nextLine();
      st.setE_num(num1);
      st.setEname(name);
      empdao.UpdateEmployee(st);
    }
    
    
    
    	}