package com.cg.appl.services;

import java.util.List;


import javax.annotation.Resource;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.appl.daos.StudentDao;
import com.cg.appl.dtos.Student;


@Service("studentServices")
@Transactional
public class StudentServicesImpl implements StudentServices {
	private static final long serialVersionUID = 1L;
	@Resource(name="studentDao")
	private StudentDao studentDao;

	@Override
	public boolean insertNewStudent(Student std) {
		
		return studentDao.insertNewStudent(std);

	}

	@Override
	public Student getStudent(int studentId) {
		
		return studentDao.getStudent(studentId);
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		return studentDao.getAllStudents();
	}
	
	@Override
	public boolean updateStudent(Student std) {
		
		return studentDao.updateStudent(std);

	}

}
