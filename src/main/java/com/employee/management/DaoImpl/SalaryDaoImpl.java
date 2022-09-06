package com.employee.management.DaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.employee.management.model.Salary;

@Component
public class SalaryDaoImpl {
@Autowired
JdbcTemplate temp;
	

		public List<Salary> getsalaryData() {

			List<Salary>  liste = temp.query("select * from ems.salary_info", new ResultSetExtractor<List<Salary>>() {

				List<Salary>  empList = new ArrayList<>();

				@Override
				public List<Salary> extractData(ResultSet s) throws SQLException, DataAccessException {

					while(s.next()) {
						Salary sal = new Salary();
						sal.setEmp_id(s.getInt("emp_id"));
						sal.setMon_sal(s.getInt("mon_sal"));
						sal.setWeek_sal(s.getInt("week_sal"));

						sal.setMon_insurance(s.getString("mon_insurance"));
						sal.setMon_deduction(s.getString("mon_deduction"));
						empList.add(sal);
					}
					return empList;
				}
			});

			return liste;
		}
	

	
	
	
	public String dataexit(int emp_id) {
		String sql="delete from ems.salary_info where emp_id="+emp_id+"";
		temp.execute(sql);
		return "Deleted succesfully!!";
	}

	public String dataenter(Salary sal) {
		String sql="insert into ems.salary_info(Emp_id,mon_sal,week_sal,mon_insurance,mon_deduction) "
				+ "values("+sal.getEmp_id()+","+sal.getMon_sal()+","+sal.getWeek_sal()+",'"+sal.getMon_insurance()+"','"+sal.getMon_deduction()+"')";
		temp.execute(sql);
		return "Data posted succesfully";
	}

	public String datasalaryupdate(Salary sala) {
		String status="Data failed!!";
		String sql="update ems.salary_info set emp_id="+sala.getEmp_id()+",mon_sal='"+sala.getMon_sal()+"',week_sal='"+sala.getWeek_sal()+"',mon_insurance='"+sala.getMon_insurance()+"',mon_deduction='"+sala.getMon_deduction()+"'"+" where emp_id="+sala.getEmp_id();

		temp.execute(sql);
		status="Upadted";
		return status;
	}

}
