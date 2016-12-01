package com.cg.appl.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.appl.dtos.Student;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	


	@Override
	public Student getStudent(int studentId) {
		Student std = entityManager.find(Student.class, studentId);
		return std;
	}

	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> qry = entityManager.createQuery("Select s from student s", Student.class);
		List<Student> list = qry.getResultList();
		return list;
	}
	@Override
	public boolean updateStudent(Student std) {
		entityManager.merge(std);
		return true;
	}

	
	@Override
	public boolean insertNewStudent(Student std) {
		entityManager.persist(std);
		return true;
	}


}
