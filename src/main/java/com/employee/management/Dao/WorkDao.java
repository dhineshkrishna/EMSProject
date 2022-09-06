package com.employee.management.Dao;

import java.util.List;

import com.employee.management.model.WorkHistory;

public interface WorkDao {
	public abstract String datainserted(WorkHistory w);
	public abstract String datadelete(int emp_id);
	public abstract List<WorkHistory> getworkData();
	public abstract String dataworkupdate(WorkHistory w1);
}
