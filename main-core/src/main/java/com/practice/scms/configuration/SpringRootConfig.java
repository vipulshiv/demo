package com.practice.scms.configuration;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages= {"com.practice.scms.daoimpl"})

public class SpringRootConfig {

	
	private String JDBCclassname;
	
	
	
	@Bean
	public BasicDataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(JDBCclassname);
		ds.setUrl("jdbc:mysql://localhost:3306/coursemgmtsystem?useSSL=true");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxTotal(2);
		ds.setInitialSize(1);
		ds.setTestOnBorrow(true);
		ds.setValidationQuery("Select 1");
		ds.setDefaultAutoCommit(true);
		return ds;
	}
	
	
}
