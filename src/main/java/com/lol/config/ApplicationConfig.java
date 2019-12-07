package com.lol.config;


import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
/*<tx:annotation-driven/>		트랜잭션 설정*/
@EnableTransactionManagement
public class ApplicationConfig {
	@Bean
	public DataSource dataSource() { //javax.sql.DataSource;
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
		ds.setUsername("root");
		ds.setPassword("ssafy");
		ds.setMaxActive(20);
		return ds;
	}
}
