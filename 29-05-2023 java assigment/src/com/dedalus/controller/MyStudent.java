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


public class MyStudent {
    Scanner sc = new Scanner(System.in);
    MyModel st = new MyModel();
    List<String> employees = new ArrayList<>();

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
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employees:");
            employees.forEach(System.out::println);
            }
            
        }
    
    
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String name = sc.nextLine();
        System.out.println("Enter employee number:");
        String num = sc.nextLine();
        employees.add(name);
        employees.add(num);
        System.out.println("Employee added successfully!");
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
    
    
    	}