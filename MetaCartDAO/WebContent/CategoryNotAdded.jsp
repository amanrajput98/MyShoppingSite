<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style type="text/css">
	span{
		color:red;
		font-style: italic;
	}
</style>
</head>
<body>	
	<%	
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
		if(session.getAttribute("email")==null){	
			response.sendRedirect("Login.jsp");
		}
	%>
	<h1>Category not Added Successfully..</h1>
	<h1>Please make sure all fields were Correctly filled..</h1>
	<h1> Please check and <a href="AddCategory.jsp"><span>Retry..</span></a></h1>
</body>
</html>