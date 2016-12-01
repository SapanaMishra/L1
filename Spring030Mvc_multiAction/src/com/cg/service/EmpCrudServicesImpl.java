package com.cg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cg.daos.EmpCrudDao;
import com.cg.dto.Emp;

@Service("empServices")
public class EmpCrudServicesImpl implements EmpCrudServices{
	
	private EmpCrudDao empDao;
	
	@Resource(name="empDao")
	public void setEmpDao(EmpCrudDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public Emp getEmpOnEmpId(int empId) {
		Emp emp = empDao.getEmpOnId(empId);
		return emp;
	}

	@Override
	public List<Emp> getAllEmps() {
		
		return empDao.getAllEmps();
	}

	@Override
	public boolean insertEmp(Emp emp) {
		
		return empDao.insertEmp(emp);
	}
	

}
