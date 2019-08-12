<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
	#contentDiv{
		width:100%;
	}
	form{
		width:45%;
		margin-left:28%;
		margin-right:28%;
		padding:70px 0px;
	}	
	table{
		width:100%;
		border: 2px solid black;
		border-radius: 10px;
		padding:23px;
	}
	td{
		padding:15px;
		font-size: 20px;
		font-weight:bold;
	}
	input{
		padding:10px;
		font-size: 20px;
		width:100%;
		border-radius: 5px;
	}
	textarea{
		height: 150px;
		width: 100%;
		resize: none;
		border-radius: 10px;
		padding:10px;
		font-size:18px;
	}
	button{
		background-color: #09a7658c;
		color:white;
		border-radius: 6px;
		width:30%;
		padding:10px;
		font-size: 20px;
		margin-left:33%;
	}
	#customize{
		width:100%;
		background-color: #c2d1fbd4;
		padding:20px;
	}
	.fa{
		font-size: 15px;
	}
	a{
		color:black;
		font-size: 20px;
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
	<div id="customize">
		<div class="backHome"> <a href="CustomizeProducts.jsp">Customize <i class="fa fa-chevron-circle-right" aria-hidden="true"></i></a> </div>
		<div class="backHome" id="adminHome"> <a href="ValidLogin.jsp"> <i class="fa fa-home" aria-hidden="true"></i> Home </a> </div>
	</div>
	<div id="contentDiv">
		<form action="addProduct.do">
			<table>
				<tr>
					<td>Product Id :</td><td><input type="text" value="" name="productId" placeholder="Enter the Product ID-"></td>
				</tr>
				<tr>
					<td>Product Name :</td><td><input type="text" value="" name="productName" placeholder="Enter the product Name-"></td>
				</tr>
				<tr>
					<td>Category :</td><td><input type="text" value="" name="category" placeholder="Category Name-"></td>
				</tr>
				<tr>
					<td>Product Description :</td><td><textarea name="description" placeholder="Description about Product-"></textarea></td>
				</tr>
				<tr>
					<td>Price :</td><td><input type="text" value="" name="price" placeholder="Enter the Price-"></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit">Add</button></td>
				</tr>
			</table>
		</form>
	</div>
		<%@include file="Footer.jsp"%>
</body>
</html>