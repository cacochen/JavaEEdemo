package net.antra.will.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.antra.will.entity.*;

public class jdbcConnector {
	
	final static String DB_URL = "jdbc:mysql://localhost:3306/antra";
	final static String USER = "cacochen";
	final static String PASS = "Wayne695656";

	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
	
	
	
/*	public static void queryDeptExec(String sql) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/antra";
		int rows = 0;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "cacochen", "Wayne695656");
		
			Statement stt = conn.createStatement();
//	        String sql = "select dept_id,dept_name from department";
	        rows = stt.executeUpdate(sql);
//	        while(rset.next()) {
//	        	Integer deptid = rset.getInt("dept_id");
//	        	String deptemail = rset.getString("dept_email");
//	        	String deptname = rset.getString("dept_name");
//	        	System.out.println(deptid + " - " + deptname);
//	        }
	        conn.close();
	    } catch (ClassNotFoundException|SQLException e) {
		// catch (SQLException e) {
			e.printStackTrace();
		} 
	    if (rows == 1) {
	    	System.out.println("Department Data added.");
	    }
	}
	
	public static List<Department> queryDeptFetch(String sql) {
		Connection conn = null;
		List<Department> deptlist = new ArrayList<Department>();
		String url = "jdbc:mysql://localhost:3306/antra";
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "cacochen", "Wayne695656");
		
			Statement stt = conn.createStatement();
//	        String sql = "select dept_id,dept_name from department";
	        ResultSet rset = stt.executeQuery(sql);
	        
	        while(rset.next()) {
	        	Integer deptid = rset.getInt("dept_id");
	        	String deptemail = rset.getString("dept_email");
	        	String deptname = rset.getString("dept_name");
	        	Department d = new Department();
	        	d.setId(deptid);
	        	d.setEmail(deptemail);
	        	d.setName(deptname);
	        	deptlist.add(d);
	        }
	        conn.close();
	    } catch (ClassNotFoundException|SQLException e) {
		// catch (SQLException e) {
			e.printStackTrace();
		} 
		return deptlist;
		
	}
	
	public static void queryEmpExec(String sql) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/antra";
		int rows = 0;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "cacochen", "Wayne695656");
		
			Statement stt = conn.createStatement();
//	        String sql = "select dept_id,dept_name from department";
	        rows = stt.executeUpdate(sql);

	        conn.close();
	    } catch (ClassNotFoundException|SQLException e) {
		// catch (SQLException e) {
			e.printStackTrace();
		} 
	    if (rows == 1) {
	    	System.out.println("Employee Data added.");
	    }
	}
	
	
	public static List<Employee> queryEmpFetch(String sql) {
		Connection conn = null;
		List<Employee> emplist = new ArrayList<Employee>();
		String url = "jdbc:mysql://localhost:3306/antra";
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, "cacochen", "Wayne695656");
		
			Statement stt = conn.createStatement();
//	        String sql = "select dept_id,dept_name from department";
	        ResultSet rset = stt.executeQuery(sql);
	        
	        while(rset.next()) {
	        	Integer empid = rset.getInt("emp_id");
	        	String fname = rset.getString("first_name");
	        	String lname = rset.getString("last_name");
	        	Integer age = rset.getInt("age");
	        	Integer deptid = rset.getInt("dept_id");
	        	Employee e = new Employee();
	        	e.setId(empid);
	        	e.setFirstName(fname);
	        	e.setLastName(lname);
	        	e.setAge(age);
	        	e.setDeptId(deptid);
	        	emplist.add(e);
	        }
	        conn.close();
	    } catch (ClassNotFoundException|SQLException e) {
		// catch (SQLException e) {
			e.printStackTrace();
		} 
		return emplist;
		
	} 
*/
		
	
}
