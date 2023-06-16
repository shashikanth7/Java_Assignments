package com.dedalus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstMethod {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("mxsel.xml");
		SubClass wel = (SubClass)context.getBean("wel");
		System.out.println(wel.print());

	}

}
