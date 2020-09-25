package com.farkalit.demo.model;

import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

import com.datastax.driver.core.LocalDate;
import com.datastax.driver.core.utils.UUIDs;

@Table("persons")
public class Persons {

	@PrimaryKeyColumn(value = "per_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID perId = UUIDs.timeBased();

	@NonNull
	private String name;

	private String city;

	@Column(value = "dobirth")
	private LocalDate dobirth = LocalDate.fromYearMonthDay(2010, 03, 28);

	public Persons() {
	}

	public Persons(UUID perId, String name, String city, LocalDate dobirth) {
		this.perId = perId;
		this.name = name;
		this.city = city;
		this.dobirth = dobirth;
	}

	public UUID getPerId() {
		return perId;
	}

	public void setPerId(UUID perId) {
		this.perId = perId;
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

	public String getDobirth() {
		return dobirth.toString();
	}

	public void setDobirth(LocalDate dobirth) {
		this.dobirth = dobirth;
	}

	@Override
	public String toString() {
		return "Person [perId=" + perId + ", name=" + name + ", city=" + city + ", dobirth=" + dobirth + "]";
	}

}
