package com.dal.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class User {
	@Value("shashi")
	private String userName;
	@Autowired
	private Car car;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", car=" + car + "]";
	}

}
