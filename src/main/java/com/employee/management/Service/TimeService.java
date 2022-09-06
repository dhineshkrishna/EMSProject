package com.employee.management.Service;

import java.util.List;

import com.employee.management.model.Time;

public interface TimeService {
	public abstract String entertime(Time t);
	public abstract String exittime(int emp_id);
	public abstract List<Time> gettimeData();
	public abstract String timedataupdate(Time t1);
}
