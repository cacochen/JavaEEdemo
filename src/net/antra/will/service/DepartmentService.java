package net.antra.will.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import net.antra.will.entity.Department;
import net.antra.will.entity.Employee;
import net.antra.will.jdbc.jdbcConnector;

public class DepartmentService {
	public List<Department> addNewDepartment(String name, String email, String[] employee, Object existingDeptList,
			Object existingEmpList) {

		List<Department> deptList;
		if (existingDeptList == null) {
			deptList = new ArrayList<Department>();
		} else {
			deptList = (ArrayList<Department>) existingDeptList;
		}
		Department newDept = new Department();
		newDept.setName(name);
		newDept.setEmail(email);
		List<Employee> empListTobeAdded = new ArrayList<Employee>();
		List<Employee> empList;
		if (existingEmpList != null) {
			empList = (ArrayList<Employee>) existingEmpList;
			for (String empIdstr : employee) {
				int empId = Integer.parseInt(empIdstr);
				for (Employee emp : empList) {
					if (empId == emp.getId()) {
						empListTobeAdded.add(emp);
					}
				}
			}
		}
		newDept.setEmployeeList(empListTobeAdded);
		deptList.add(newDept);
		// This is adding on DB
		try (Connection conn = jdbcConnector.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement("insert into department (dept_name, dept_email) values (?,?) ");
				){
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return getDeptList();
//		return deptList;
	}
	
	public List<Department> getDeptList() {
		List<Department> resList = new ArrayList<Department>();
		try(Connection conn = jdbcConnector.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from department");
				PreparedStatement stmt2 = conn.prepareStatement("select e.emp_id, e.first_name,e.last_name, e.age from employee e inner join department d on e.dept_id = d.dept_id where d.dept_id = ?");
				) {
			while (rs.next()) {
				int id = rs.getInt("dept_id");
				String name = rs.getString("dept_name");
				String email = rs.getString("dept_email");
				//load emplist
				List<Employee> empList = new ArrayList<Employee>();
				stmt2.setInt(1, id);
				ResultSet empRs = stmt2.executeQuery();
				while (empRs.next()) {
					int empId = empRs.getInt("emp_id");
					String first = empRs.getString("first_name");
					String last = empRs.getString("last_name");
					Integer age = empRs.getInt("age");
					if(empRs.wasNull()){
						age = null;
					}
					empList.add(new Employee(empId,first,last,age,null));
				}
				resList.add(new Department(id,name,email,empList));
			}
		} catch (Exception se) {
			se.printStackTrace();
		}
		return resList;
	}
	
	
}


