package com.mars.springjdbc.config;

import javax.sql.DataSource;

//import javax.activation.DataSource;

//import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan("com.mars.springjdbc")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	DataSource dataSource() {
		
		DriverManagerDataSource dmDataSource = new DriverManagerDataSource();
		dmDataSource.setUrl(env.getProperty("url"));
		dmDataSource.setDriverClassName(env.getProperty("driver"));
		dmDataSource.setUsername(env.getProperty("dbuser"));
		dmDataSource.setPassword(env.getProperty("dbpassword"));
		return dmDataSource;
		
		
		
	}
}
