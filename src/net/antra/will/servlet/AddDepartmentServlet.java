package net.antra.will.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.antra.will.service.DepartmentService;


public class AddDepartmentServlet extends HttpServlet {
	public  List<String> departments = new ArrayList<String>();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String dname = request.getParameter("deptname");
		String email = request.getParameter("email");
		String[] employee = request.getParameterValues("employee");
		if(dname !=""&& dname!=null) {
			departments.add(dname);
		} else {
			out.println("Invalid name!");
		}
		DepartmentService ds = new DepartmentService();
		request.getSession().setAttribute("deptList", ds.addNewDepartment(dname, email, employee,request.getSession().getAttribute("deptList"),request.getSession().getAttribute("empList")));
		
//		request.getSession().setAttribute("departments", departments);
		response.sendRedirect("AddDepartmentServlet");
	}
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		request.getRequestDispatcher("addDepartment.jsp").include(request, response);
		
//		out.println("<h3>Department List:</h3>");
//		for (String name :departments) {
//			out.println(name);
//			out.println("<br/>");
//		}
	}

}
