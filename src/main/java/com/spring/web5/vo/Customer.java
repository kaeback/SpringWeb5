package com.spring.web5.vo;

public class Customer {
	private String custid;
	private String password;
	private String name;
	private String email;
	private String gender;
	private String ssn;
	private String address;
	
	public Customer() {}

	public Customer(String custid, String password, String name, String email, String gender, String ssn, String address) {
		super();
		this.custid = custid;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.ssn = ssn;
		this.address = address;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", gender=" + gender + ", ssn=" + ssn + ", address=" + address + "]";
	}
	
}
