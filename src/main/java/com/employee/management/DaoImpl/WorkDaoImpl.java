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

import com.employee.management.Dao.WorkDao;
import com.employee.management.model.WorkHistory;
@Component
public class WorkDaoImpl implements WorkDao{

	@Autowired
	JdbcTemplate temp;


	public String datainserted(WorkHistory w) {
		String sql="insert into ems.work_history(Emp_id,Company_name,Employer_name,Comp_Address,Comp_phone) "
				+ "values("+w.getEmp_id()+",'"+w.getCompany_name()+"','"+w.getEmployer_name()+"','"+w.getComp_address()+"','"+w.getComp_phone()+"')";
		temp.execute(sql);
		return "Data posted succesfully";
	}

   
	public String datadelete(int emp_id) {
		String sql="delete from ems.work_history where emp_id="+emp_id+"";
		temp.execute(sql);
		return "Deleted succesfully!!";
	}



	public List<WorkHistory> getworkData() {

		List<WorkHistory>  liste = temp.query("select * from ems.work_history", new ResultSetExtractor<List<WorkHistory>>() {

			List<WorkHistory>  empList = new ArrayList<>();

			@Override
			public List<WorkHistory> extractData(ResultSet s) throws SQLException, DataAccessException {

				while(s.next()) {
					WorkHistory w = new WorkHistory();
					w.setEmp_id(s.getInt("emp_id"));
					w.setCompany_name(s.getString("company_name"));
					w.setEmployer_name(s.getString("employer_name"));

					w.setComp_address(s.getString("comp_address"));
					w.setComp_phone(s.getString("comp_phone"));
					empList.add(w);
				}
				return empList;
			}
		});

		return liste;
	}



	public String dataworkupdate(WorkHistory w1) {
		String status="Data failed!!";
		String sql="update ems.work_history set emp_id="+w1.getEmp_id()+",company_name='"+w1.getCompany_name()+"',employer_name='"+w1.getEmployer_name()+"',comp_address='"+w1.getComp_address()+"',comp_phone='"+w1.getComp_phone()+"'"+" where emp_id="+w1.getEmp_id();

		temp.execute(sql);
		status="Upadted";
		return status;
	}



}
