<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wayne'help:${username}</title>
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
<form action="AddEmployeeServlet" method="post">
	<div>
	First Name:	<input type="text" name="firstname"/>
	<br/>
	Last  Name: <input type="text" name="lastname"/>
	<br/>
	Age       : <input type="text" name="age"/>
	</div>
	
	<tr><td>Department:</td><td>
			    	<select name="department" required="required">
			            <option value="">Please select</option>
			          <c:forEach var="item" items="${deptList}">
			            <option value="${item.id}">${item.name}</option>
			          </c:forEach>
			        </select>
	</td></tr>
	
	<br></br>
	<input type="submit" value="Submit"/>
	<a href="addEmployee.jsp" type="button">Cancel</a>
</form>
</div>
<div>
		<c:if test="${not empty empList}">
			    Existing Employee
			    <table align="center">
				    <c:forEach items="${empList}" var="emp">
				    <tr>
				    	<td>First Name:</td>
				    	<td>${emp.firstName}</td>
				    	<td>Last Name:</td>
				    	<td>${emp.lastName}</td>
				    	<td>Age:</td>
				    	<td>${emp.age}</td>
				    </tr>
				    </c:forEach>
			    </table>
	    </c:if>
</div>
</body>
</html>