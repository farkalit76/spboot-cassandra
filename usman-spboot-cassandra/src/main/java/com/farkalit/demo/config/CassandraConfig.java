package com.farkalit.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	public static final String KEYSPACE = "usmankeysp";

	@Override
	protected String getKeyspaceName() {
		return KEYSPACE;
	}

//	@Override
//	public SchemaAction getSchemaAction() {
//		return SchemaAction.CREATE_IF_NOT_EXISTS;
//	}
//
//	@Override
//	protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
//		CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSPACE);
//
//		return Arrays.asList(specification);
//	}
//
//	@Override
//	protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
//		return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
//	}
//
//	@Override
//	protected String getKeyspaceName() {
//		return KEYSPACE;
//	}
//
//	@Override
//	public String[] getEntityBasePackages() {
//		return new String[] { "com.farkalit.demo.model" };
//	}

}
