package com.cg.appl.daos;

import java.io.Serializable;
import java.util.List;

import com.cg.appl.dtos.Student;

public interface StudentDao extends Serializable{
	boolean insertNewStudent(Student std);
	Student getStudent(int studentId);
	List<Student> getAllStudents();
	boolean updateStudent(Student std);
}
