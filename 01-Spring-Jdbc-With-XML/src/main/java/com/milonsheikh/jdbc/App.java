package com.milonsheikh.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import com.milonsheikh.jdbc.dao.StudentDao;
import com.milonsheikh.jdbc.entities.Student;


public class App {
	public static void main(String[] args) {
		System.out.println("My frist spring jdbc promram started...");
		
		//Spring jdbc ==>> JdbcTemplate
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		//Insert
//		Student student =new Student();
//		student.setId(15);
//		student.setName("Alamin");
//		student.setCity("Dhaka");
//		int result = studentDao.inser(student);
//		System.out.println("Number of record inserted= "+result);
		
		//Update
//		Student student =new Student();
//		student.setId(15);
//		student.setName("Alamin Matubber");
//		student.setCity("Madaripur");
//		int result = studentDao.change(student);
//		System.out.println("Number of record changed= "+result);
		
		//Delete
//		int result = studentDao.delete(15);
//		System.out.println("Number of record deleted= "+result);
		
		// Select single student query
//		Student student = studentDao.getStudent(11);
//		System.out.println(student);
		
		// Select Multiple student query
		List<Student> allStudent = studentDao.getAllStudent();
		for(Student s:allStudent) {
			System.out.println(s);
		}
		
		
	}
}
