package com.farkalit.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

public class CassandraConfigBean extends AbstractCassandraConfiguration {

	//@Value("${cassandra.contactpoints}")
	private String CASSANDRA_CONTACTPOINT;

	//@Value("${cassandra.port}")
	private Integer CASSANDRA_PORT;

	//@Value("${cassandra.keyspace}")
	private String CASSANDRA_KEYSPACE;

	//@Value("${cassandra.username}")
	private String CASSANDRA_USERNAME;

	//@Value("${cassandra.password}")
	private String CASSANDRA_PASSWORD;

	@Override
	protected String getKeyspaceName() {
		return CASSANDRA_KEYSPACE;
	}

	@Bean
	public CassandraClusterFactoryBean cluster() {
		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(CASSANDRA_CONTACTPOINT);
		cluster.setPort(CASSANDRA_PORT);
		cluster.setUsername(CASSANDRA_USERNAME);
		cluster.setPassword(CASSANDRA_PASSWORD);
		return cluster;
	}

	@Bean
	public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
		return new BasicCassandraMappingContext();
	}
}
