package com.milonsheikh.jdbc.dao;

import java.util.List;

import com.milonsheikh.jdbc.entities.Student;

public interface StudentDao {
	public int inser(Student student);
	public int change(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getAllStudent();
}
