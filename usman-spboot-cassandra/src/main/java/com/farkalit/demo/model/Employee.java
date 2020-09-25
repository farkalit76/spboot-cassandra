package com.farkalit.demo.model;


import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

import com.datastax.driver.core.LocalDate;

@Table("emp")
public class Employee {

	@PrimaryKey(value ="emp_id")
	private Integer empId;
	
	@NonNull
	private String name;
	
	private String city;
	
	private String phone;
	
	private Double salary;
	
	@Column(value= "dobirth")
	private Date dobirth= new java.util.Date();
	
	@Column(value= "created_time")
	private Date createdTime= new java.util.Date();

	public Employee() {}
	
	public Employee(Integer empId, String name, String city, String phone, Double salary, Date dobirth,
			Date createdTime) {
		super();
		this.empId = empId;
		this.name = name;
		this.city = city;
		this.phone = phone;
		this.salary = salary;
		this.dobirth = dobirth;
		this.createdTime = createdTime;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDobirth() {
		if( dobirth != null)
			return dobirth.toString();
		else
			return "";
	}

	public void setDobirth(Date dobirth) {
		this.dobirth = dobirth;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", city=" + city + ", phone=" + phone + ", salary="
				+ salary + ", dobirth=" + dobirth + ", createdTime=" + createdTime + "]";
	}
	
}
