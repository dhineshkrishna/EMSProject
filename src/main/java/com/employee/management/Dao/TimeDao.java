package com.employee.management.Dao;

import java.util.List;

import com.employee.management.model.Time;

public interface TimeDao {
	public abstract String entertime(Time t);
	public abstract String exittime(int emp_id);
	public abstract List<Time> gettimeData();
	public abstract String timedataupdate(Time t1);
}
