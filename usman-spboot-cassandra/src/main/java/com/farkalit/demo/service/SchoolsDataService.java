package com.farkalit.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.mapping.BasicMapId;
import org.springframework.stereotype.Service;

import com.farkalit.demo.model.SchoolsData;
import com.farkalit.demo.repository.SchoolsDataRepository;

@Service
public class SchoolsDataService {

	@Autowired
	private SchoolsDataRepository repository;

	public SchoolsData save(final SchoolsData data) {
		return repository.save(data);
	}

	public List<SchoolsData> findByUser(final String user) {
		return repository.findByUser(user);
	}
	
//	public SchoolsData findOne(UUID id, final String user) {
//		return repository.findById(BasicMapId.id("id", id).with("user", user));
//	}
	
//	public SchoolsData findByIdAndByUser(final UUID id, final String user) {
//		return repository.findByIdAndUser(id, user);
//	}

	public List<SchoolsData> findAll() {
		List<SchoolsData> list = new ArrayList<>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

//	public void delete(final UUID id, final String user) {
//		repository.delete(BasicMapId.id("id", id).with("user", user));
//	}

	public long count() {
		return repository.count();
	}

//	public boolean exists(final String id) {
//		return repository.exists(BasicMapId.id("id", id));
//	}

	public void deleteAll() {
		repository.deleteAll();
	}
}
