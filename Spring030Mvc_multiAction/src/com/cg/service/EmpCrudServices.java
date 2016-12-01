package com.cg.service;

import java.io.Serializable;
import java.util.List;

import com.cg.dto.Emp;

public interface EmpCrudServices extends Serializable{
	Emp getEmpOnEmpId(int empId);
	List<Emp> getAllEmps();
	boolean insertEmp(Emp emp);

}
