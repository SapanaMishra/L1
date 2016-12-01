package com.cg.appl.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cg.appl.dtos.Student;
import com.cg.appl.services.StudentServices;

//http://localhost:8081/SpringMVC100StudentProj/admitNewStudent.html
//http://localhost:8081/SpringMVC100StudentProj/listStudents.html
//http://localhost:8081/SpringMVC100StudentProj/studentDetails.html?id=xxx

@Controller
//@RequestMapping(name="/students")
public class StudentWebController {
	
	@Resource(name="studentServices")
	private StudentServices services;
	
	
	@RequestMapping("/listStudents")
	public String seeAllRecords(Model model){
		
		
		List<Student> list = services.getAllStudents();
		
		model.addAttribute("listStudents", list);
		return "listStudents";
		
	}
	
	@RequestMapping(value="/studentDetails")
	public String getStudentDetails(@RequestParam("id") int studentId, Model model){
		
		System.out.println(studentId);
		Student student = services.getStudent(studentId);
		System.out.println(student);
		//model attribute
		model.addAttribute("student", student);
		return "updateStdForm";
		
	}
	@RequestMapping(value="/updateStudent", method=RequestMethod.POST)
	public String updateStudentData(@ModelAttribute @Valid Student student,BindingResult result,Model model){
		
		if(result.hasErrors()){
		return "updateStdForm"; 
		}
		else{
		boolean isUpdated = services.updateStudent(student);
		System.out.println("Is student updated"+isUpdated);
		return isUpdated?"success":"updateStdForm";
		
	}
	}
	
	
	
	//insert Function
		//action 1. get entry form
		//action2. post entry form
		
		//action1
		@RequestMapping(name="/admitNewStudent",method=RequestMethod.GET)
		public String getEntryForm(Model model){
			Student student = new Student();
			model.addAttribute("student", student);
//			model.addAttribute("category", "home,electronics");
			return "entryForm";
			
		}
		
		//action2
		
		@RequestMapping(name="/admitNewStudent", method=RequestMethod.POST)
		public String postStudentData(@ModelAttribute Student student,Model model){
			
			
			boolean isInserted = services.insertNewStudent(student);
			
			return isInserted?"success":"entryForm";
			
		}
		//get a single record on studentId
		//action 3. get form form studentId
		//action 4. see student details with the given id
		
		//view all students
		//action 5. seeAll students
		

}
