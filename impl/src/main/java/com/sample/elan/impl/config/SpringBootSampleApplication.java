package com.sample.elan.impl.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.sample.elan.impl")
@EnableTransactionManagement
@EntityScan("com.sample.elan.impl.repository.model")
@EnableJpaRepositories("com.sample.elan.impl.repository")
@PropertySources({ @PropertySource("classpath:application.properties"),
		@PropertySource("classpath:global.config.properties") })
public class SpringBootSampleApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSampleApplication.class);
	}

	public static void main(String[] args) {
		new SpringBootSampleApplication().configure(new SpringApplicationBuilder(SpringBootSampleApplication.class))
				.run(args);
	}
}