package com.employee.management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.DaoImpl.SalaryDaoImpl;
import com.employee.management.model.Salary;

@Component
public class SalarySerImpl {
	@Autowired
	SalaryDaoImpl salDao;
	
	
	public String dataenter(Salary sal) {
		return salDao.dataenter(sal);
	}

	
	public String dataexit(int emp_id) {
		
		return salDao.dataexit(emp_id);
	}



	public List<Salary> getsalaryData() {
		List<Salary> empList=salDao.getsalaryData();
		return empList;
	}


	
	public String salarydataupdate(Salary sala) {
		return salDao.datasalaryupdate(sala);
	}
    
}
