import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);
		HttpSession session = request.getSession();
		
		System.out.println(username + ":" + password);
		// if UServalidate(name,password)
		
		if (username.equals("admin")&&password.equals("123456")) {
			out.print("Welcome, " + username);
			session.setAttribute("username", username);
			out.print("Successfully Log in.");
//			request.getRequestDispatcher("link.html").include(request, response);
		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
