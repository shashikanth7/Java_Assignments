package com.dal.controller;

import java.util.Scanner;

import javax.persistence.Query;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dal.model.Employee;

import com.dal.model.Address;
import com.dal.model.Department;
import com.dal.model.EmailDetails;

public class EmployeeController {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Transaction txn;
	Employee emp;
	EmailDetails emp1;
	Department dept;
	Scanner sc = new Scanner(System.in);
	
	
	
	public void addEmployee() {
		
		txn = session.beginTransaction();
		emp = new Employee();
		emp1 = new EmailDetails();
		
		
		System.out.println("Enter your First Name:");
		String fname = sc.next();
		System.out.println("Enter your Last Name:");
		String lname = sc.next();
		emp.setEname(fname);
		emp.setLname(lname);
		session.save(emp);
		
        
		
		System.out.println("Enter your Email:");
		emp1.setEmail(sc.next());
		System.out.println("Enter your Password:");
		emp1.setPassword(sc.next());
		System.out.println("Enter your Gender:");
		emp1.setGender(sc.next());
		
		
		
		dept = new Department();
		System.out.println("Enter your Department Name:");
		String dname = sc.next();
		dept.setDname(dname);
		List<Address> addrList = new ArrayList<Address>();
		
		
		
		System.out.println("Enter Your Address");
		Address addr = new Address();
		System.out.println("Enter Address ID");
		int addrId = sc.nextInt();		
		addr.setAddrId(addrId);
		
		System.out.println("Enter Door No");
		int doorno = sc.nextInt();
		addr.setDoorNo(doorno);
		System.out.println("Enter Street");
		String street = sc.next();
		addr.setStreet(street);
		System.out.println("Enter City");
		String city = sc.next();
		addr.setCity(city);
		System.out.println("Enter Pincode");
		int pincode = sc.nextInt();
		addr.setPincode(pincode);

		addr.setEmployee(emp);
		addrList.add(addr);

		emp.setAddress(addrList);
		session.save(addr);

		session.save(dept);
		emp.setDid(dept);
		session.save(emp);

		
		txn.commit();
		System.out.println("Employee Successfully Created... :)");
		
		
	}
	
	
	public void viewEmployee() {
		Query qry = session.createQuery("from Employee");
		List<Employee> elist = ((org.hibernate.query.Query) qry).list();
		Iterator<E> i = elist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
	
	public void updateEmployee() {
		txn = session.beginTransaction();
		System.out.println("Enter your ID:");
		int veid = sc.nextInt();

		System.out.println("Enter your Email:");
		String vmail = sc.next();

		Query qry = session.createQuery("update Employee set email =:mail where eid=:emid").setString("mail", vmail)
				.setInteger("emid", veid);
		int noofrows = qry.executeUpdate();

		txn.commit();
		System.out.println("Updated " + noofrows + "  Successfully ");
	}
	
	public void searchEmpByIDusingNamedQuery()
	{
		System.out.println("Enter your ID:");
		int veid = sc.nextInt();

		Query qry = session.createNamedQuery("GET_EMP_BY_ID").setInteger("id", veid);
		Employee    emp =(Employee) ((org.hibernate.query.Query) qry).uniqueResult();
		System.out.println("Emp fetched using Named Query " + emp);
	}
	
	
	public void searchUsingCriteriaQuery()
	{
		System.out.println("Enter your Email ID:");
		String vemail = sc.next();

		Criteria c = session.createCriteria(Employee.class);
		c.add(Restrictions.eq("email", vemail));
		Employee    emp =(Employee) c.uniqueResult();
		System.out.println("Emp fetched using Criteria Query " + emp);

	
	}
	
	
	
	
	
	
	
	
}
