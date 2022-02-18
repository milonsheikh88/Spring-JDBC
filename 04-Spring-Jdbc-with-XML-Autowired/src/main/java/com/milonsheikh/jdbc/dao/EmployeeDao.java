package com.milonsheikh.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.milonsheikh.jdbc.model.Employee;

@Component
public class EmployeeDao {
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate =new JdbcTemplate(dataSource);
	}
	
	//Insert data
	public int saveEmployee(Employee employee) {
		String sql="insert into employee (name, salary) values('"+employee.getName()+"','"+employee.getSalary()+"')";
		return jdbcTemplate.update(sql);	
	}
	
	//Insert data by prepared statement
	public int saveEmployeeByPS(Employee employee) {
		String sql = "insert into employee (name, salary) values(?,?)";
		int r =jdbcTemplate.update(sql,employee.getName(), employee.getSalary());
		return r;
	}
	
	//Select single row single value
	public String getEmployeeNameById(int id) {
		String sql = "select name from employee where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},String.class);
	}
	
	//Select single row Multiple value
	public Employee getEmployeeAllDataById(int id) {
		String sql = "select * from employee where id=?";
		return jdbcTemplate.queryForObject(sql,new Object[] {id},new EmployeeRowMapper());	
	}
	
	
	//Select Multiple row Multiple value
	public List <Employee> getAllEmployeeAllData() {
		String sql = "select * from employee";
		return jdbcTemplate.query(sql,new EmployeeRowMapper());	
	}
	
	public class EmployeeRowMapper implements RowMapper<Employee>{

		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee= new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setSalary(rs.getDouble("salary"));
			return employee;
		}
		
		
	}
	
}
