package com.dedalus.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserNotFoundException extends Exception {
  
}

public class Student {

    public static void main(String[] args) throws InterruptedException {
        String un = null;
        String pwd = null;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try {
            System.out.println("Enter Username");
            un = br.readLine();
            System.out.println("Enter Password");
            pwd = br.readLine();

            if (un.equals("shashi") && pwd.equals("pass")) {
            	System.out.println("Wait menu is loding......");
                Thread.sleep(3000);
                System.out.println("Welcome " + un);
                menu();
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException unf) {
            System.out.println("User not found!");
            unf.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
            e.printStackTrace();
        } finally {
            System.out.println("Finally .....");
        }
        System.out.println("Main Ends");
    }

    private static void menu() {
        MyStudent r1 = new MyStudent();
        Scanner sc = new Scanner(System.in);
        String yn = null;

        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Serialize");
            System.out.println("4. Deserialize");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    r1.addEmployee();
                    break;
                case 2:
                    r1.viewEmployees();
                    break;
                case 3:
                    r1.serialize();
                    break;
                case 4:
                    r1.deserialize();
                    break;
                default:
                    System.out.println("Enter a valid number.");
                    break;
            }

            System.out.println("Do you want to continue (y/n)?");
            yn = sc.next();
        } while (yn.equalsIgnoreCase("y"));
    }
}

class MyStudent {
    private List<String> employees;

    public MyStudent() {
        employees = new ArrayList<>();
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

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employees:");
            for (String employee : employees) {
                System.out.println(employee);
            }
        }
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