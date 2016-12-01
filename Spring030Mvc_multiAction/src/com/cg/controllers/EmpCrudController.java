package com.cg.controllers;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.daos.EmpCrudDao;
import com.cg.dto.Emp;
import com.cg.service.EmpCrudServices;

//http://localhost:8081/Spring030Mvc_multiAction/empCrudOper/enterEmpId
@Controller
@RequestMapping("/empCrudOper")
public class EmpCrudController {
	
	@Resource(name="empServices")
	private EmpCrudServices services;
	
	
	//get a page for excepting empId
	@RequestMapping("/enterEmpId")
	public ModelAndView getEmpIdPage(){
		ModelAndView model  =  new ModelAndView("empId");
		return model;
	}
//	@RequestMapping("/postEmpId")
//	public ModelAndView postEmpId(HttpServletRequest request){
//		int empId= Integer.parseInt(request.getParameter("empId"));
//		System.out.println(empId);
//		
//		Emp emp = new Emp(empId,"abc",2000);
//		ModelAndView model = new ModelAndView("empDetails");
//		model.addObject("emp", emp);
//		return model;
//	}

	@RequestMapping("/postEmpId")
	public ModelAndView postEmpId(@RequestParam("empId") int empId){
//		int empId= Integer.parseInt(request.getParameter("empId"));
		System.out.println(empId);
		
		Emp emp = services.getEmpOnEmpId(empId);
		ModelAndView model = new ModelAndView("empDetails");
		model.addObject("emp", emp);
		return model;
	}
	//http://localhost:8081/Spring030Mvc_multiAction/empCrudOper/getNewEmpDetails
	@RequestMapping("/getNewEmpDetails")
	public ModelAndView enterEmpDetails(){
		
		ModelAndView model = new ModelAndView("newEmpDetails");
		model.addObject("newEmp", new Emp());
		return model;
	}

	@RequestMapping("/postNewEmpDetails")
	public ModelAndView postEmpDetails(@ModelAttribute("newEmp") @Valid Emp emp, BindingResult result){
		System.out.println(emp);
		ModelAndView model = null;
		if(result.hasErrors()){
			model = new ModelAndView("newEmpDetails");
		}
		else{
		boolean isSucc = services.insertEmp(emp);
		
		if(isSucc)
		model = new ModelAndView("success");
		else
			model = new ModelAndView("newEmpDetails");
		}
		return model;
	}
}
