package com.orangeandbronze.dao;

import java.util.Collection;

import com.orangeandbronze.entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void removeStudentById(int id);

	void updateStudent(Student student);

	void createStudent(Student student);

}