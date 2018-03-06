package com.orangeandbronze.dao.jdbc;

import java.util.*;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.orangeandbronze.dao.StudentDao;
import com.orangeandbronze.entity.*;

@Repository
@Qualifier("jdbc")
public class StudentDaoJdbc implements StudentDao {
	
	private static Map<Integer, Student> students;
	
	static {
		
		students = new HashMap<Integer, Student>(){
		
			{
				put(1, new Student(1, "Patrick", "Computer Science"));
				put(2, new Student(2, "Lance", "Computer Engineering"));
				put(3, new Student(3, "Vince", "Mechanical Engineering"));
			}
			
		};
		
	}

	@Override
	public Collection<Student> getAllStudents() {
		return this.students.values();
	}	
	
	@Override
	public Student getStudentById(int id) {
		return this.students.get(id);
	}

	@Override
	public void removeStudentById(int id) {
		this.students.remove(id);
		
	}
	
	@Override
	public void updateStudent(Student student) {
		
		Student s = students.get(student.getStudentId());
		s.setSubject(student.getSubject());
		s.setName(student.getName());
		students.put(s.getStudentId(), s);
	}

	@Override
	public void createStudent(Student student) {
		this.students.put(student.getStudentId(), student);	
	}
	
	
}
