package com.camilo.database;

import java.sql.SQLException;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DatabaseApplication {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}
	
	@PostConstruct
	private void initDb() {
		log.info("****** Creating and inserting into Users table ******");
	    String sqlStatements[] = {
				"drop table phones if exists",
				"drop table users if exists",

				"CREATE TABLE users ("
						+ "id UUID DEFAULT RANDOM_UUID() PRIMARY KEY ,"
						+ "name VARCHAR(255) NOT NULL,"
						+ "email VARCHAR(255) NOT NULL,"
						+ "password VARCHAR(255) NOT NULL,"
						+ "is_active BOOLEAN NOT NULL DEFAULT TRUE,"
						+ "last_login TIMESTAMP NOT NULL,"
						+ "created_at TIMESTAMP NOT NULL,"
						+ "updated_at TIMESTAMP NOT NULL)",

				"CREATE TABLE phones ("
						+ "id BIGINT AUTO_INCREMENT PRIMARY KEY,"
						+ "number VARCHAR(50) NOT NULL,"
						+ "city_code VARCHAR(10) NOT NULL,"
						+ "country_code VARCHAR(10) NOT NULL,"
						+ "user_id UUID NOT NULL,"
						+ "FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE)",

				"INSERT INTO users (id, name, email, password, is_active, last_login, created_at, updated_at)"
				+"VALUES (RANDOM_UUID(), 'John Doe', 'john.doe@example.com', '$2a$12$m6Lhnbj4BBUpzziv80gY.OIiobqM0eFaIXjLHz/tWM5JnceVEAWnC', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",

				"INSERT INTO users (id, name, email, password, is_active, last_login, created_at, updated_at)"
				+"VALUES (RANDOM_UUID(), 'Jane Smith', 'jane.smith@example.com', 'wrong1', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
		
				"INSERT INTO users (id, name, email, password, is_active, last_login, created_at, updated_at)"
				+"VALUES (RANDOM_UUID(), 'Alice Jones', 'alice.jones@example.com', 'wrong2', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
		
				"INSERT INTO users (id, name, email, password, is_active, last_login, created_at, updated_at)"
				+"VALUES (RANDOM_UUID(), 'Bob Brown', 'bob.brown@example.com', 'wrong3', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
		
				"INSERT INTO users (id, name, email, password, is_active, last_login, created_at, updated_at)"
				+"VALUES (RANDOM_UUID(), 'Carol White', 'carol.white@example.com', 'wrong4', TRUE, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",


		//PHONES

				// Phones for 'john'
				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('123456789', '010', '001', (SELECT id FROM users WHERE email = 'john.doe@example.com'))",

				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('987654321', '011', '001', (SELECT id FROM users WHERE email = 'john.doe@example.com'))",

				// Phones for 'jane.smith@example.com'
				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('555123456', '020', '002', (SELECT id FROM users WHERE email = 'jane.smith@example.com'))",

				// Phones for 'alice.jones@example.com'
				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('777888999', '030', '003', (SELECT id FROM users WHERE email = 'alice.jones@example.com'))",

				// Phones for 'bob.brown@example.com'
				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('333222111', '040', '004', (SELECT id FROM users WHERE email = 'bob.brown@example.com'))",

				// Phones for 'carol.white@example.com'
				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('444555666', '050', '005', (SELECT id FROM users WHERE email = 'carol.white@example.com'))",

				"INSERT INTO phones (number, city_code, country_code, user_id)"
						+"VALUES ('666777888', '051', '005', (SELECT id FROM users WHERE email = 'carol.white@example.com'))",
	    };

	    Arrays.asList(sqlStatements).forEach(sql -> {
			jdbcTemplate.execute(sql);
	    });
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server inMemoryH2DatabaseaServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
	}

}
