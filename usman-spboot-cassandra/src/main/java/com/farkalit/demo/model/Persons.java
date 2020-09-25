package com.farkalit.demo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.lang.NonNull;

import com.datastax.driver.core.utils.UUIDs;

@Table("persons")
public class Persons {

	@PrimaryKeyColumn(value = "person_id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private UUID personId = UUIDs.timeBased();

	@NonNull
	private String name;

	private String city;
	
	private String email;
	
	private Long phone;

	@Column(value = "dobirth")
	private LocalDateTime dobirth;
	
	@Column(value = "creation_date")
	private LocalDateTime creationDate= LocalDateTime.now();

	public Persons() {
	}

	public Persons(UUID personId, String name, String city, String email, Long phone, LocalDateTime dobirth,
			LocalDateTime creationDate) {
		this.personId = personId;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.dobirth = dobirth;
		this.creationDate = creationDate;
	}


	public UUID getPersonId() {
		return personId;
	}

	public void setPersonId(UUID personId) {
		this.personId = personId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDobirth() {
		return dobirth.toString().substring(0, 10);
	}

	public void setDobirth(LocalDateTime dobirth) {
		this.dobirth = dobirth;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Persons [personId=" + personId + ", name=" + name + ", city=" + city + ", email=" + email + ", phone="
				+ phone + ", dobirth=" + dobirth + ", creationDate=" + creationDate + "]";
	}

}
