package com.employee.management.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import com.employee.management.Dao.EmployeeDao;
import com.employee.management.DaoImpl.EmployeeDaoImpl;
//import com.employee.management.Service.EmployeeService;
import com.employee.management.model.Employee;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@Component
public class EmpServiceImpl implements EmployeeDao{

	@Autowired
	EmployeeDaoImpl empDao;
	
	@Override
	public List<Employee> getData() {
		List<Employee> empList=empDao.getData();
		return empList;
		
	}
    
	public Employee postedValue(int emp_id) {
		List<Employee> empList=empDao.getData();
		Employee emp=empList.stream().filter(s->s.getEmp_id()==emp_id).findAny().get();
		return emp;
	}

	public String deletedValue(int emp_id) {
		return empDao.deletedValue(emp_id);
	}

	@Override
	public String updatedValue(Employee emp)  {
		
			if(emp.getEmp_id()==0) {
				throw new IllegalArgumentException("Invalid data input");
			  }
			 return empDao.updatedValue(emp);
		
		
	}

	@Override
	public String updatedData(Employee emp) {
		return empDao.updatedData(emp);
	}
	
	
	
	}

	

	
	

	
	

	

