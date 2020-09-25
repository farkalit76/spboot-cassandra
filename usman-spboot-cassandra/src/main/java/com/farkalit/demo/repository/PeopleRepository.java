package com.farkalit.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.farkalit.demo.model.People;
import com.farkalit.demo.model.PeopleKey;

@Repository
public interface PeopleRepository extends CassandraRepository<People, PeopleKey> {

	List<People> findByKeyFirstName(final String firstName);

	List<People> findByKeyFirstNameAndKeyDateOfBirthGreaterThan(final String firstName,
			final LocalDateTime dateOfBirth);

	// Don't do this!!
	@Query(allowFiltering = true)
	List<People> findByLastName(final String lastName);
}
