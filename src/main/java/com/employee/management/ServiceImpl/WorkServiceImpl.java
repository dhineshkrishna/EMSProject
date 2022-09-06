package com.employee.management.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.management.DaoImpl.WorkDaoImpl;
import com.employee.management.Service.WorkService;
import com.employee.management.model.WorkHistory;


@Component
public class WorkServiceImpl implements WorkService{

	@Autowired
	WorkDaoImpl workDao;
	
	@Override
	public String datainserted(WorkHistory w) {
		return workDao.datainserted(w);
	}

	@Override
	public String datadelete(int emp_id) {
		return workDao.datadelete(emp_id);
	}

	public List<WorkHistory> getworkData() {
		List<WorkHistory> empList=workDao.getworkData();
		return empList;
	}

	public String workdataupdate(WorkHistory w1) {
		return workDao.dataworkupdate(w1);
	}	
}
