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
		font-style: italic;
	}
	h1{
		margin-left: 20px;
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
	<h1>Image Successfully Added..</h1>
	<h1><a href="UploadImage.jsp"><span>Add More..</span></a></h1>
</body>
</html>