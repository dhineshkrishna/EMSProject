package com.employee.management.Dao;
import java.util.*;

import com.employee.management.model.Employee;

public interface EmployeeDao {
	public abstract List<Employee> getData();
	public abstract String deletedValue(int emp_id);
	public abstract String updatedValue(Employee emp);
	public abstract String updatedData(Employee emp);
}
