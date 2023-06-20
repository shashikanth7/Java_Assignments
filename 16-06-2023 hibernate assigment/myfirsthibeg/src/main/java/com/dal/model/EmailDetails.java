package com.dal.model;

import java.util.jar.Attributes.Name;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

@Entity

@NamedQueries(
		{ 
			@NamedQuery(name = "GET_EMP_BY_ID", query = "from Employee e where e.eid=:id"),
		    @NamedQuery(name = "GET_EMP_BY_DEPTNO", query = "from Employee e where e.did=:did") 
		})
public class EmailDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;

	@Column
	@Embedded
	private Name ename;
	private String email;
	private String password;
	private String gender;

	@OneToOne
	@JoinColumn(name = "DEPTID")
	private Department did;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Address> address;

	public EmailDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDetails(int eid, Name ename, String email, String password, String gender, Department did) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.did = did;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public Name getEname() {
		return ename;
	}

	public void setEname(Name ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Department getDid() {
		return did;
	}

	public void setDid(Department did) {
		this.did = did;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", did=" + did + ", address=" + address + "]";
	}

}
