package dev.paie.config;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;




@Configuration
public class DataSourceMySQLConfig {

	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://bxitw9lvy-mysql.services.clever-cloud.com:3306/bxitw9lvy");
		dataSource.setUsername("ufxwkxtnuxed8eie");
		dataSource.setPassword("TdYsFVQ8rcQivYuYUa2");
		return dataSource;
	}
}