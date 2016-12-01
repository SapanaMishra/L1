package com.cg.appl.services;

import java.io.Serializable;
import java.util.List;

import com.cg.appl.dtos.Student;

public interface StudentServices extends Serializable{
	boolean insertNewStudent(Student std);
	Student getStudent(int studentId);
	List<Student> getAllStudents();
	boolean updateStudent(Student std);
}
