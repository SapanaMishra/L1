package com.cg.appl.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity(name="student")
@Table(name="students")
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int studentId;
	private String firstName;
	
	private String lastName;
	private Date dtJoin;
	public Student() {
		super();
	}
	
	
	public Student(int studentId, String firstName, String lastName ) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.dtJoin = dtJoin;
	}

	@Id
	@Column(name="studentId")
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	@Column(name="firstNm")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@NotNull(message="Last name is mandatory")
	@Size(min=3, max=10, message="minimum 3 and maximum 10 characters required")
	@Column(name="lastNm")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="dtJoin")
	public Date getDtJoin() {
		return dtJoin;
	}
	public void setDtJoin(Date dtJoin) {
		this.dtJoin = dtJoin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + studentId;
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (studentId != other.studentId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dtJoin=" + dtJoin + "]";
	}
	
	
	

}

/*
 create table students(
 studentId number(4),
 firstNm varchar2(10),
  lastNm varchar2(10),
  dtJoin Date
  )
  
  */
