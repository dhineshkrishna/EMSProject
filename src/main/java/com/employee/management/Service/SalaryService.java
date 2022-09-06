package com.employee.management.Service;

import java.util.List;

import com.employee.management.model.Salary;

public interface SalaryService {
	public abstract String dataenter(Salary sal);
	public abstract String dataexit(int emp_id);
	public abstract List<Salary> getsalaryData();
	public abstract String workdataupdate(Salary sala);
}
