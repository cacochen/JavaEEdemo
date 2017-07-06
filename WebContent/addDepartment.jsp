<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wayne'help: ${username}</title>
</head>
<body>
<h1 style="color:blue">Wayne's user administration</h1>  
<br/>
<a href="login.html"><Strong>Login</Strong></a>
<a href="LogoutServlet"><Strong>Logout</Strong></a>  
<a href="ProfileServlet"><Strong>Profile</Strong></a>  
<a href="AddEmployeeServlet">addEmployee</a>
<a href="AddDepartmentServlet">addDepartment</a>
<br/>
<br/>
<div>
<form action="AddDepartmentServlet" method="post">
	<div>
	Name:  <input type="text" name="deptname"/><br/>
	Email: <input type="text" name="email"/><br/>
	</div>
	 			<tr>Employee:<td>	
			    	<c:forEach items="${empList}" var="emp">
				    <tr>
				    	<td><input type="checkbox" name="employee" value="${emp.id}"/>${emp.firstName} ${emp.lastName}</td>
				    </tr>
				    </c:forEach>
			    </td></tr>
	<br></br>
	<input type="submit" value="Submit"/>
	<a href="addDepartment.jsp">Cancel</a>
</form>
</div>
<div>
<c:if test="${not empty deptList}">
			    Existing Department
			    <table align="center">
				    <c:forEach items="${deptList}" var="dept">
				    <tr>
				    	<td>Dept Name:</td>
				    	<td>${dept.name}</td>
				    	<td>Email:</td>
				    	<td>${dept.email}</td>
				    	<c:forEach items="${dept.employeeList}" var="emp">
					    	<td>Employee:</td>
					    	<td>${emp.firstName} ${emp.lastName} ${emp.age}</td>
				    	</c:forEach>
				    </tr>
				    </c:forEach>
			    </table>
	    </c:if>
</div> 	

</body>
</html>