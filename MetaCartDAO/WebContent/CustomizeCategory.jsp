<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
#contentDiv{
		width:100%;
	}
	form{
		width:40%;
		margin-left:30%;
		margin-right:30%;
		padding:122px 0px;
	}	
	table{
		width:100%;
		border: 2px solid black;
		border-radius: 10px;
		padding:23px;
	}
	td{
		padding:10px;
		font-size: 20px;
		font-weight:bold;
	}
	input{
		padding:10px;
		font-size: 20px;
		width:100%;
		border-radius: 5px;
	}
	button{
		background-color: #3ec38cbd;
		color:white;
		border-radius: 6px;
		width:30%;
		padding:10px;
		font-size: 20px;
		margin-left: 33%;
	}
	#back{
		width:100%;
		background-color: #c2d1fbd4;
		padding:20px;
	}
	a{
		color:black;
		font-size: 20px;
	}
	.fa{
		font-size: 15px;
	}
	.fa-home{
		font-size:20px;
	}
	.backHome{
		width: 50%;
	}
	#adminHome{
		text-align: right;
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
	<div id="back">
		<div class="backHome"> <a href="AddCategory.jsp">Back <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></a> </div>
		<div class="backHome" id="adminHome"> <a href="ValidLogin.jsp"> <i class="fa fa-home" aria-hidden="true"></i> Home </a> </div>
	</div>
	<div id="contentDiv">
		<form action="SearchCategory.do">
			<table>
				<tr>
					<td>Category Id :</td><td><input type="text" value="" name="categoryId" placeholder="Enter the Category ID-"></td>
				</tr>
				<tr>
					<td>Category Name:</td><td><input type="text" value="" name="categoryName" placeholder="Enter the Category Name-"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Search</button></td>
				</tr>
			</table>
		</form>
	</div>
		<%@include file="Footer.jsp"%>
</body>
</html>