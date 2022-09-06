package com.employee.management.Dao;

import java.util.List;

import com.employee.management.model.Salary;

public interface SalaryDao {
	public abstract String dataenter(Salary sal);
	public abstract String dataexit(int emp_id);
	public abstract List<Salary> getsalaryData();
	public abstract String salarydataupdate(Salary sala);
}
