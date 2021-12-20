<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    if (session.getAttribute("mySession") != null) {
    	//not the samething
    	//response.sendRedirect("login");
    	
    	RequestDispatcher rd = request.getRequestDispatcher("login");
    	rd.forward(request, response);// this lands on the GET in the servlet
    }
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>


<h3>Login Form</h3>
<form action="login" method="POST">
Username: <input type="text" name="uname"><br>
Password: <input type="password" name="pword"><br>
<input type="submit" value="login">
</form>

</body>
</html>