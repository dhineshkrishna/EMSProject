package com.employee.management.Service;

import java.util.*;

import com.employee.management.model.Employee;

public interface EmployeeService {
	public abstract List<Employee> getData();
	public abstract Employee postedValue(int emp_id);
	public abstract String deletedValue(int emp_id);
	public abstract String updatedValue(Employee emp);
	public abstract String updatedData(Employee emp);
}
