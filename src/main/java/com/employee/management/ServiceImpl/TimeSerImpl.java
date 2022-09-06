package com.employee.management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.DaoImpl.TimeDaoImpl;
import com.employee.management.Service.TimeService;
import com.employee.management.model.Time;

@Component
public class TimeSerImpl implements TimeService{

	@Autowired
	TimeDaoImpl obj;
	

	
	
	public List<Time> gettimeData() {
		return obj.gettimeData();
	}

	
	public String timedataupdate(Time t1) {
		return obj.timedataupdate(t1);
	}

	public String entertime(Time t) {
		return obj.entertime(t);
	}

	public String exittime(int emp_id) {
		return obj.exittime(emp_id);
	}

}
