package com.farkalit.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

//import com.datastax.driver.core.LocalDate;

@Table("emp")
public class Employee {

	@PrimaryKey(value = "emp_id")
	private Integer empId;

	@NonNull
	private String name;

	private String city;

	private Long phone;

	private Double salary;

	@Column(value = "dobirth")
	private LocalDate dobirth;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Column(value = "created_time")
	private LocalDateTime createdTime = LocalDateTime.now();

	public Employee() {
	}

	public Employee(Integer empId, String name, String city, Long phone, Double salary, LocalDate dobirth,
			LocalDateTime createdTime) {
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

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDobirth() {
		if (dobirth != null)
			return dobirth.toString();
		else
			return "";
	}

	public void setDobirth(LocalDate dobirth) {
		this.dobirth = dobirth;
	}

	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", city=" + city + ", phone=" + phone + ", salary="
				+ salary + ", dobirth=" + dobirth + ", createdTime=" + createdTime + "]";
	}

//	Comparator sortingByName = new Comparator() {
//	
//		   @Override
//		   public int compare(Employee s1, Employee s2) {
//			return s1.getEmpId().compareTo(s2.getEmpId());
//		   }
//		};
}
