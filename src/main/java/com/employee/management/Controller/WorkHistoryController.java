package com.employee.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.ServiceImpl.WorkServiceImpl;
import com.employee.management.model.WorkHistory;

@RestController 
public class WorkHistoryController {
	@Autowired
	WorkServiceImpl work;
	
	@RequestMapping(value="/workpost",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String dataInsert(@RequestBody WorkHistory w) {
		return work.datainserted(w);
	}
	
	@RequestMapping(value="/workdelete",method=RequestMethod.DELETE)
	public String dataget(@RequestParam("emp_id") int emp_id){
		return work.datadelete(emp_id);
	}
	
	@RequestMapping(value="/workget",method=RequestMethod.GET)
	public List<WorkHistory> getData(){
		List<WorkHistory> empList=work.getworkData();
		return empList;
	}
	
	@RequestMapping(value="/workdataupdate",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String dataupdate(@RequestBody WorkHistory w1) {
		return work.workdataupdate(w1);
	}
}
