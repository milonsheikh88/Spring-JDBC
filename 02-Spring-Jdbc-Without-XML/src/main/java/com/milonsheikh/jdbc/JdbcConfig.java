package com.milonsheikh.jdbc;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.milonsheikh.jdbc.dao.StudentDao;
import com.milonsheikh.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/spring_jdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jt= new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
	
	@Bean("studentDao")
	public StudentDao getStudentDao(){
		StudentDaoImpl sdi=new StudentDaoImpl();
		sdi.setJdbcTemplate(getTemplate());
		return sdi;	
	}

}
