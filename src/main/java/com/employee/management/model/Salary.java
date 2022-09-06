package com.employee.management.model;

public class Salary {
	int emp_id;
	int mon_sal;
	int week_sal;
	String mon_insurance;
	String mon_deduction;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getMon_sal() {
		return mon_sal;
	}
	public void setMon_sal(int mon_sal) {
		this.mon_sal = mon_sal;
	}
	public int getWeek_sal() {
		return week_sal;
	}
	public void setWeek_sal(int week_sal) {
		this.week_sal = week_sal;
	}
	public String getMon_insurance() {
		return mon_insurance;
	}
	public void setMon_insurance(String mon_insurance) {
		this.mon_insurance = mon_insurance;
	}
	public String getMon_deduction() {
		return mon_deduction;
	}
	public void setMon_deduction(String mon_deduction) {
		this.mon_deduction = mon_deduction;
	}
}
