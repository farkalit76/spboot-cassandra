### For Employee : POST URL http://192.168.43.22:8081/api/employees
	Payload request:
	{
	    "empId": 7,
	    "name": "Sarwar",
	    "city": "Pune",
	    "phone": 7948022331,
	    "salary": 22000.0,
	    "dobirth": "1990-03-15"
	}

### For Student data : POST URL: http://192.168.43.22:8081/api/student_data
	Payload request:
	{
		"user": "MSaghir",
		"greet": "Its Fun learning How to Insert, Delete and Select Data in Cassandra's Using Spring Data"
	}

### For Persons: POST URL http://192.168.43.22:8081/api/persons
	Payload request:
	{
	    "name": "Sarwar",
	    "city": "Delhi",
	    "email": "sarwar@abc.com",
	    "phone": 98887773433,
	    "dobirth" : "2000-09-25T00:00:00.000"
	}

### For Peoples POST URL: http://192.168.43.22:8081/api/peoples
	Payload request:
	{
	    "key": {
	        "firstName": "Amit",
	        "dateOfBirth": "2000-03-15T00:00:00.000"
	    },
	    "lastName": "Hamid",
	    "salary": 23000.0
	}

# For Tutorial POST URL: http://192.168.43.22:8081/api/tutorials
	Payload request:
	{
	    "title" :"Spring boot with Cassandra 3.11",
	    "description" :"Spring boot tutorial.",
	    "published" : false
	}

# Apache Cassandra
-------------------
1. Need to Install Java 8u251 and Paython 2.7 (go to command prompt and type python, it will open python shell for you)
2. Install Cassandra 3.11
3. Install Install Datastax DevCenter for Data Management With GUI or DBeaver (include Java-driver-wrapper) or RazorSQL

#Create Keyspace
	 CREATE KEYSPACE usmankeysp WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

# CREATE TABLE emp
	CREATE TABLE emp(
	   emp_id int PRIMARY KEY,
	   name text,
	   city text,
	   salary decimal,
	   phone varint,
	   dobirth date,
	   created_time timestamp
	);
   
### -->Insertion of table data
	  INSERT INTO emp (emp_id, city, name, salary, phone, dobirth, created_time) values(  1,'Pune','rajeev',30000, 9848022331, '2000-10-05','2020-09-24 10:23:33' );
	  INSERT INTO emp (emp_id, city, name, salary, phone, dobirth, created_time) values(  2,'Pune','Rajako',40000, 9948022331, '2001-11-05','2020-09-24 10:23:33' );
	  INSERT INTO emp (emp_id, city, name, salary, phone, dobirth, created_time) values(  3,'Pune','Shakil',55000, 9748022331, '2002-10-15','2020-09-24 10:23:33' );
	  INSERT INTO emp (emp_id, city, name, salary, phone, dobirth, created_time) values(  4,'Pune','Jamili',35000, 8948022331, '1990-12-01','2020-09-24 10:23:33' );
	  INSERT INTO emp (emp_id, city, name, salary, phone, dobirth, created_time) values(  5,'Pune','Sarwar',22000, 7948022331, '1995-03-10','2020-09-24 10:23:33' );
 
 
### -->Selection of data
	SELECT * from emp;
	SELECT * from emp where emp_id=2;
	
### -->Filtering with column which is not primary key, then create index for that key.
	CREATE index on emp(salary);
	SELET * from emp where salary >= 40000 allow filtering;
   
### -->Delete table row from table
	DELETE from emp where emp_id=6;
	DELETE salary FROM emp WHERE emp_id=3; (It will delete data of salary from the table)

#  CREATE TABLE schools
	CREATE TABLE schools(
	   id uuid PRIMARY KEY,
	   user text,
	   greet text,
	   creation_date timestamp
   );
   

#   CREATE TABLE persons
	 CREATE TABLE persons(
	   person_id uuid PRIMARY KEY,
	   name text,
	   city text,
	   email text,
	   phone varint,
	   dobirth timestamp,
	   creation_date timestamp
   );
   
 
# 	CREATE TABLE people_in_name
	CREATE TABLE people_in_name(
	  first_name TEXT,
	  date_of_birth TIMESTAMP,
	  person_id UUID,
	  last_name TEXT,
	  salary DOUBLE,
	  PRIMARY KEY ((first_name), date_of_birth, person_id)
	) WITH CLUSTERING ORDER BY (date_of_birth ASC, person_id DESC);

# CREATE TABLE tutorial
	CREATE TABLE tutorial(
	   id timeuuid PRIMARY KEY,
	   title text,
	   description text,
	   published boolean
	);
	
	Here one of the method executes SELECT * FROM tutorial WHERE tutorial 
	LIKE '%title%'; in Cassandra.

	So we need the to create a custom index that has options with mode: 
	CONTAINS along with analyzer_class to make case_sensitive effective.
	Run the command:

	CREATE CUSTOM INDEX idx_title ON usmankeysp.tutorial (title) 
	USING 'org.apache.cassandra.index.sasi.SASIIndex' 
	WITH OPTIONS = {
	'mode': 'CONTAINS', 
	'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.NonTokenizingAnalyzer', 
	'case_sensitive': 'false'};
	
