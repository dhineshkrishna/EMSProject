package com.employee.management.Controller;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.management.ServiceImpl.SalarySerImpl;
import com.employee.management.model.Salary;

@RestController 
public class SalaryController {
	@Autowired
	SalarySerImpl ser;
	
	@RequestMapping(value="/salarypost",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String dataInsert(@RequestBody Salary sal) {
		return ser.dataenter(sal);
	}
	
	@RequestMapping(value="/salarydelete",method=RequestMethod.DELETE)
	public String dataget(@RequestParam("emp_id") int emp_id){
		return ser.dataexit(emp_id);
	}
	
	@RequestMapping(value="/salaryget",method=RequestMethod.GET)
	public List<Salary> getData(){
		List<Salary> empList=ser.getsalaryData();
		return empList;
	}
	
	@RequestMapping(value="/salarydataupdate",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String dataupdate(@RequestBody Salary sala) {
		return ser.salarydataupdate(sala);
	}
}
