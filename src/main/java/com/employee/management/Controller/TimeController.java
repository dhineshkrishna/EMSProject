package com.employee.management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.management.ServiceImpl.TimeSerImpl;
import com.employee.management.model.Time;

@RestController
public class TimeController {

	@Autowired
	TimeSerImpl time;
	
	@RequestMapping(value="/timepost",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)	
	public String dataInsert(@RequestBody Time t) {
		return time.entertime(t);
	}
	
	@RequestMapping(value="/timedelete",method=RequestMethod.DELETE)
	public String dataget(@RequestParam("emp_id") int emp_id){
		return time.exittime(emp_id);
	}
	
	@RequestMapping(value="/timeget",method=RequestMethod.GET)
	public List<Time> getData(){
		List<Time> empList=time.gettimeData();
		return empList;
	}
	
	@RequestMapping(value="/timedataupdate",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public String dataupdate(@RequestBody Time t1) {
		return time.timedataupdate(t1);
	}
	
}
