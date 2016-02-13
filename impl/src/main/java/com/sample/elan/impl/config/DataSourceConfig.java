package com.sample.elan.impl.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

import com.mchange.v2.c3p0.DriverManagerDataSource;
@Configuration
public class DataSourceConfig {
	
	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClass(env.getProperty("jdbc.driverClassName"));
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		/*Properties properties = new Properties();
		properties.setProperty("maxPoolSize", env.getProperty("jdbc.maxPoolSize"));
		properties.setProperty("testConnectionOnCheckin", env.getProperty("jdbc.testConnectionOnCheckin"));
		properties.setProperty("idleConnectionTestPeriod", env.getProperty("jdbc.idleConnectionTestPeriod"));
		properties.setProperty("numHelperThreads", env.getProperty("jdbc.numHelperThreads"));
		properties.setProperty("preferredTestQuery", env.getProperty("jdbc.preferredTestQuery"));
		
		dataSource.setProperties(properties);*/
				
		return dataSource;
	}

	@Bean
	  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	    return new PersistenceExceptionTranslationPostProcessor();
	  }

}
