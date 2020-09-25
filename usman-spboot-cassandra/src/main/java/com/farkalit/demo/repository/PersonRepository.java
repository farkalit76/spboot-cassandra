package com.farkalit.demo.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.farkalit.demo.model.Persons;

@Repository
public interface PersonRepository extends CassandraRepository<Persons, UUID>{

}
