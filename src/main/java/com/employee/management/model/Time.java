package com.employee.management.model;

public class Time {
	int emp_id;
	String work_hour;
	String off_hour;
	String days_off;
	String over_time;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getWork_hour() {
		return work_hour;
	}
	public void setWork_hour(String work_hour) {
		this.work_hour = work_hour;
	}
	public String getOff_hour() {
		return off_hour;
	}
	public void setOff_hour(String off_hour) {
		this.off_hour = off_hour;
	}
	public String getDays_off() {
		return days_off;
	}
	public void setDays_off(String days_off) {
		this.days_off = days_off;
	}
	public String getOver_time() {
		return over_time;
	}
	public void setOver_time(String over_time) {
		this.over_time = over_time;
	}
}
