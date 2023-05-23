package sample;
import java.util.Scanner;
class Employee {
    int empo = 23;
    String name = "shahsi";
    Salary sal;
    public Employee() {
  	  System.out.println("From Employee Constructor");
  	}
  	public Employee(int x) {
  		  this("Moni");
  		  this.empo=x;
  		  System.out.println("From Employee Constructor" + x);
  	}
  	public Employee(String str) {	  
  		  System.out.println("From Employee Constructor" + str);
  	}
  	public String getDetails() {
  		return (empo + " -- " + name + " --- " + sal);
  	}  
}

class Manager extends Employee {
String dept = "fullstack";
	public Manager() {
		super(21); 
		System.out.println("From Mgr Constr");
		
	}
	public String getDetails() {
		 return super.getDetails()+ "--  " + dept;
	}
}

public class MainClass {

    public static void main(String[] args) {
        Manager sr = new Manager();
        Employee emp = new Employee();
		System.out.println(emp.getDetails());	
		System.out.println(sr.getDetails());
        sr.sal = new Salary();
        System.out.println("enter the basic pay");
        Scanner sc = new Scanner(System.in);
        double ba=sc.nextInt();
        sr.sal.setBasic(ba);
        sr.sal.setGross(sr.sal.getBasic() + sr.sal.getDa());
        sr.sal.setNet(sr.sal.getGross() - sr.sal.getPf());

        System.out.println("Net Salary: " + sr.sal.getNet());
    }

}
