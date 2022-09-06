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

import com.employee.management.Dao.EmployeeDao;
//import com.employee.management.EmployeeDao;
import com.employee.management.model.Employee;
/**
 * 
 * @author Dhinesh
 *
 */
@Component
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Employee> getData() {

		List<Employee>  empDataList = template.query("select * from ems.employee", new ResultSetExtractor<List<Employee>>() {

			List<Employee>  empList = new ArrayList<>();

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

				while(rs.next()) {
					Employee employee = new Employee();
					employee.setEmp_id(rs.getInt("emp_id"));
					employee.setF_name(rs.getString("f_name"));
					employee.setL_name(rs.getString("l_name"));

					employee.setDob(rs.getString("dob"));
					employee.setPhone(rs.getString("phone"));
					employee.setAddress(rs.getString("address"));
					empList.add(employee);
				}
				return empList;
			}
		});

		return empDataList;
	}
	
    @Override
	public String deletedValue(int emp_id) {
        String sql="delete from ems.employee where emp_id="+emp_id+"";
        template.execute(sql);
		return "Deleted successfully";
	}

	@Override
	public String updatedValue(Employee emp) {

		String status="Data putting failed!";
		String sql="insert into ems.employee (emp_id,f_name,l_name,dob,phone,address)"+"values("+emp.getEmp_id()+",'"+emp.getF_name()+"','"+emp.getL_name()+"','"+emp.getDob()+"','"+emp.getPhone()+"','"+emp.getAddress()+"')";
		
		try {
		template.execute(sql);
		status="Data putting succesfully";
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public String updatedData(Employee emp) {
		String status="Data failed!!";
		String sql="update ems.employee set emp_id="+emp.getEmp_id()+",f_name='"+emp.getF_name()+"',l_name='"+emp.getL_name()+"',dob='"+emp.getDob()+"',phone='"+emp.getPhone()+"',address='"+emp.getAddress()+"'"+" where emp_id="+emp.getEmp_id();
		
		template.execute(sql);
		status="Upadted";
		return status;
	}



}