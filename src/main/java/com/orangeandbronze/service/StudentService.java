package com.orangeandbronze.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.orangeandbronze.dao.StudentDao;
import com.orangeandbronze.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	@Qualifier("jdbc")
	private StudentDao studentDao;
	
	public Collection<Student> getAllStudents() {
		return this.studentDao.getAllStudents();
	}
	
	public Student getStudentById(int id) {
		return this.studentDao.getStudentById(id);
	}

	public void removeStudentById(int id) {
		this.studentDao.removeStudentById(id);
		
	}
	
	public void updateStudent(Student student) {
		this.studentDao.updateStudent(student);
	}

	public void createStudent(Student student) {
		this.studentDao.createStudent(student);
		
	}
}
