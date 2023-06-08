package com.dedalus.View;
import com.dedalus.*;
import com.dedalus.controller.MyStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;

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
            BiPredicate<String, String> res = (username, password) -> username.equals("shashi") && password.equals("pass");

            if (res.test(un, pwd)) {
                System.out.println("Wait menu is loading...");
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
            System.out.println("Finally...");
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
            System.out.println("5. delet");
            System.out.println("6. update");
            System.out.println("7. sort by number");
            System.out.println("8. sort by name"); 
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
                case 5:
                    r1.Delet();
                    break;
                case 6:
                    r1.update();
                    break; 
                case 7:
                	r1.sortbyno();
                	break;
                case 8:
                	r1.sortbyname();
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

