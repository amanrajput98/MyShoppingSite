<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	span{
		color: red;
	}
	a{
		text-decoration: none;
		color: red;
		font-style: italic;
	}
</style>
</head>
<body>
	<%	
		response.setHeader("Cache-Control", "no-cache , no-store , must-revalidate");
	%>
	<h1><span>Oops Error !!</span></h1>
	<h1>Email Id or password is not Valid ...</h1>
	<h1>Kindly Please<a href="Login.jsp"> <span>Retry...</span></a></h1>
</body>
</html>