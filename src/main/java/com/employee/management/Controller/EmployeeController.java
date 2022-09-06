package com.employee.management.Controller;
import java.util.*;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.ServiceImpl.EmpServiceImpl;
import com.employee.management.model.Employee;

/**
 * 
 * @author Dhinesh
 *
 */
@Controller
public class EmployeeController {
		
	@Autowired
	private EmpServiceImpl obj;
	
	@GetMapping("/home")
	public String index() {
		return "home";
	}
	
	/**
	 * 
	 * @return list of Employee
	 */
	@RequestMapping(value="/data",method=RequestMethod.GET) 
	public List<Employee> getDatas() {
			List<Employee> empList=obj.getData();
			return empList;
		}
	
	/**
	 * 
	 * @param emp_id
	 * @return employee object
	 */
	@RequestMapping(value="/datapost",method=RequestMethod.POST)
	public Employee postValue(@RequestParam("emp_id")int emp_id) {
		Employee emp=obj.postedValue(emp_id);
		return emp;	
	}
	
	/**
	 * 
	 * @param emp_id
	 * @return "deleted"
	 */
	@RequestMapping(value="/datadelete",method=RequestMethod.DELETE)
	public String delValue(@RequestParam("emp_id")int emp_id) {
		return obj.deletedValue(emp_id);
		
	}
	
	/**
	 * 
	 * @param emp
	 * @return "Updated successfully"
	 */
	@RequestMapping(value="/dataput",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateValue(@RequestBody Employee emp ) {
		return obj.updatedValue(emp);
	}
	
	
	@RequestMapping(value="/dataupdate",method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateData(@RequestBody Employee emp) {
		return obj.updatedData(emp);
	}
	
	
}
