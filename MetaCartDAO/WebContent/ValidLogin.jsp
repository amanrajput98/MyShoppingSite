<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style type="text/css">
	ul{
		padding:25px;
		padding-bottom: 0;
		margin-bottom: 0;
	}
	
	li{
		font-size:35px;
		font-weight:bold;
		padding:50px;
	}
	#content{
		text-align: center;
		background: url("./Images/ValidLoginBg.jpg") no-repeat center;
		background-size: cover;
	}
	button{
		background-color: red;
		width:100px;
		padding:10px;
		border-radius: 5px;
		color:white;
		margin-bottom:20px;
	}
	a{
		color:#402727;
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
	<%@include file="Header.jsp"%>
	<div id="content">
	<ul type="none">
		<li><a href="AddCategory.jsp">Category</a></li>
		<li><a href="AddProduct.jsp">Product</a></li>
		<li><a href="UploadImage.jsp">Product Image</a></li>
	</ul>
	<a href="AdminLogout"><button type="submit">Logout</button></a>
	</div>
		<%@include file="Footer.jsp"%>
</body>
</html>