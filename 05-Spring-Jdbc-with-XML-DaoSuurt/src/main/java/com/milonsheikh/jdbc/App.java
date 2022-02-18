package com.milonsheikh.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.milonsheikh.jdbc.dao.EmployeeDaoSupport;
import com.milonsheikh.jdbc.model.Employee;


public class App {
	public static void main(String[] args) {

		//Spring jdbc ==>> JdbcTemplate
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		EmployeeDaoSupport employeeDao = context.getBean("employeeDaoSupport",EmployeeDaoSupport.class);	
		
		// Insert Data
//		int result = employeeDao.saveEmployee(new Employee("Mamun Sheikh", 3000));
//		System.out.println("Insert ==>> "+result);
		// Insert Data by prepared statement
//		int result = employeeDao.saveEmployeeByPS(new Employee("Amir Sheikh", 5000));
//		System.out.println("Insert ==>> "+result);
		
		
		//Select single row single value
//		String result = employeeDao.getEmployeeNameById(1);
//		System.out.println("getEmployeeNameById ==>> "+result);
		
		//Select single row Multiple value
//		Employee emp= employeeDao.getEmployeeAllDataById(1);
//		System.out.println("getEmployeeAllDataById ==>> "+emp);
		
		
		//Select Multiple row Multiple value
		List <Employee> allEmp= employeeDao.getAllEmployeeAllData();
		for(Employee e:allEmp) {
			System.out.println(e);
		}
	}
}
