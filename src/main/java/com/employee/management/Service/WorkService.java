package com.employee.management.Service;

import java.util.List;

import com.employee.management.model.WorkHistory;

public interface WorkService {
	public abstract String datainserted(WorkHistory w);
	public abstract String datadelete(int emp_id);
	public abstract List<WorkHistory> getworkData();
	public abstract String workdataupdate(WorkHistory w1);
}
