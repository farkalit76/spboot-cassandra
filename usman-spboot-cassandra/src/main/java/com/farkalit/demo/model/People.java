package com.farkalit.demo.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("people_in_name")
public class People {

	@PrimaryKey
	private PeopleKey key;
	
	@Column("last_name")
	private String lastName;
	
	@Column
	private double salary;

	public People(final PeopleKey key, final String lastName, final double salary) {
		this.key = key;
		this.lastName = lastName;
		this.salary = salary;
	}

	public PeopleKey getKey() {
		return key;
	}

	public void setKey(PeopleKey key) {
		this.key = key;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "People [key=" + key + ", lastName=" + lastName + ", salary=" + salary + "]";
	}

}
