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

import com.employee.management.Dao.TimeDao;
import com.employee.management.model.Time;


@Component
public class TimeDaoImpl implements TimeDao{

	@Autowired
	JdbcTemplate temp;

	
	public String entertime(Time t) {
		String sql="insert into ems.time_info(Emp_id,Work_hour,Off_hour,Days_off,Over_time) "
				+ "values("+t.getEmp_id()+",'"+t.getWork_hour()+"','"+t.getOff_hour()+"','"+t.getDays_off()+"','"+t.getOver_time()+"')";
		temp.execute(sql);
		return "Data posted succesfully";
	}

	
	public String exittime(int emp_id) {
		String sql="delete from ems.time_info where emp_id="+emp_id+"";
		temp.execute(sql);
		return "Deleted succesfully!!";
	}

	public List<Time> gettimeData() {
		List<Time>  liste = temp.query("select * from ems.time_info", new ResultSetExtractor<List<Time>>() {

			List<Time>  empList = new ArrayList<>();

			@Override
			public List<Time> extractData(ResultSet s) throws SQLException, DataAccessException {

				while(s.next()) {
					Time t = new Time();
					t.setEmp_id(s.getInt("emp_id"));
					t.setWork_hour(s.getString("work_hour"));
					t.setOff_hour(s.getString("off_hour"));
					t.setDays_off(s.getString("days_off"));
					t.setOver_time(s.getString("over_time"));
					empList.add(t);
				}
				return empList;
			}
		});

		return liste;
	}

	

	public String timedataupdate(Time t1) {
		String status="Data failed!!";
		String sql="update ems.salary_info set emp_id="+t1.getEmp_id()+",work_hour='"+t1.getWork_hour()+"',off_hour='"+t1.getOff_hour()+"',days_off='"+t1.getDays_off()+"',over_time='"+t1.getOver_time()+"'"+" where emp_id="+t1.getEmp_id();

		temp.execute(sql);
		status="Upadted";
		return status;
	}
}
