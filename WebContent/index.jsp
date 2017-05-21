
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!--  <%@ taglib prefix="c" uri="htt://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<% String errMsg =null; %>
  <%if ( "POST".equalsIgnoreCase(request.getMethod()) && request.getParameter("submit")!=null ) {%>
  
	  <jsp:useBean id="loginBean" class="com.EWServlet.servlets.LoginBean">
	  <jsp:setProperty name="loginBean" property="*"/>
	  </jsp:useBean>
	  <%
	   if (loginBean.isValidAdmin() | loginBean.isValidUser() )
	   {
		   if (loginBean.isValidAdmin())
		   {
			   out.println("<h2>Welcome admin!</h2>");
			   
		   }
		   if (loginBean.isValidUser())
		   {
			   out.println("<h2>Welcome user!</h2>");
		   }
		   out.println("You are successfully logged in");
		  
	   }  else {
	     errMsg="Invalid user id or password. Please try again";
	   }
	  %>
	 
<%} %>

<body>

<h2>Login:</h2>
<!-- Check error message, if it is set, then display it -->
<%if (errMsg!=null) { %>
  <span style="color: red;"><%out.print(errMsg); %>
  </span>
<%} %>

<form method="post">
  User Name: <input type="text" name="userName"><br>
  Password: <input type="password" name="password"><br>
  <button type="submit" name="submit">Submit</button>
  <button type="reset">Reset</button>
</form>

</body>

</html>