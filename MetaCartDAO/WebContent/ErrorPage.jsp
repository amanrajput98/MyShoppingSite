<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%	
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		if(session.getAttribute("email")==null){	
			response.sendRedirect("Login.jsp");
		}
	%> --%>
	<% if(response.getStatus() == 500){ %>
		<h1><font color="red">Process Failed : <%=exception.getMessage() %></font></h1><br>
		<%-- include login page --%>
		<%-- <%@ include file="AddCategory.jsp"%>--%> 
		<%}else {%>
			Hi There, error code is <%=response.getStatus() %><br>
			Please go to <a href="/ValidLogin.jsp">home page</a>
		<%} %>
</body>
</html>