<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style type="text/css">
	#content{
			background: url("./Images/virtual-reality-technology-shopping-website-on-white-back.jpg") no-repeat center;
			background-size:contain;
	}
	.btn{
	width:100%;
	text-align:center;
	font-size:30px;
	padding:40px;
	border-radius: 20px;
	background-color: #d0dae8ad;;
	color: black;
	}
	table{
	
		width:40%;
		margin:90px 30%;
	}
	td{
		padding:20px;
	}
</style>
</head>
<body>
	<div id=container>
		<%@include file="Header.jsp"%>
		<div id=content>
			<table>
			<tr><td><a href="Login.jsp"><button class="btn">Admin</button></a></td></tr>
			<tr><td><a href="ShowProducts.do?categoryName=soft Toys"><button class="btn">User</button></a></td></tr>
			</table>
		</div>
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>