package com.cg.daos;

import java.io.Serializable;
import java.util.List;

import com.cg.dto.Emp;

public interface EmpCrudDao extends Serializable{
	Emp getEmpOnId(int empId);
	List<Emp> getAllEmps();
	boolean insertEmp(Emp emp);
	

}
