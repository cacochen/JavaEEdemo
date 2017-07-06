package net.antra.will.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.will.entity.Employee;
import net.antra.will.service.EmployeeService;

public class AddEmployeeServlet extends HttpServlet {
	public static List<String> employees = new ArrayList<String>();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		Integer age  = Integer.valueOf(request.getParameter("age"));
		Integer deptid = Integer.valueOf(request.getParameter("department"));
//		String czship = request.getParameter("citizenship");
		
		if(fname !=""&& fname!=null &&lname!=null&&lname!="") {
			employees.add(fname);
		} else {
			out.println("Invalid name!");
		}
		// request.getSession().setAttribute("employees", employees);
		EmployeeService es = new EmployeeService();
		try {
		request.getSession().setAttribute("empList", es.addNewEmployee(fname, lname, age, deptid,request.getSession().getAttribute("empList")));
		response.sendRedirect("AddEmployeeServlet");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("addEmployee.jsp").include(request, response);
		List<Employee> employees = (ArrayList<Employee>)request.getSession().getAttribute("empList");
		
//		ArrayList<String> dlist = (ArrayList<String>) request.getSession().getAttribute("departments");
		

		
//		out.println("<h3>Employee List:</h3>");
//		for (Employee e : employees) {
//			out.println(e.getFirstName());
//			out.println("<br/>");
//		}
	}

}

