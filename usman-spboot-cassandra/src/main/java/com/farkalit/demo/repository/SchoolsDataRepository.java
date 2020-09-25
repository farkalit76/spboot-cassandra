package com.farkalit.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.farkalit.demo.model.SchoolsData;

@Repository
public interface SchoolsDataRepository extends CassandraRepository<SchoolsData, UUID>{
	
	
	//SchoolsData findByIdAndUser(final UUID id, final String user);
	
	@Query(allowFiltering = true)
	List<SchoolsData> findByUser(final String user);

}
