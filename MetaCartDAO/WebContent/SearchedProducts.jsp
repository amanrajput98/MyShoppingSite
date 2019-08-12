<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="mz.beans.Products"%>
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
	table{
		width:70%;
		border: 2px solid black;
		border-radius: 10px;
		padding:23px;
		margin:3% 15% 3% 15%;
	}
	table,td{
		border-spacing: 0;
	}
	td{
		padding:10px;
		font-size: 18px;
		text-align: center;
	}
	th{
		font-size: 20px;
		background: #c2d1fbd4;
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
	button{
		padding:5px;
		font-size: 15px;
		width:80px;
		border-radius: 6px;		
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
		<div class="backHome"> <a href="CustomizeProducts.jsp">Back <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></a> </div>
		<div class="backHome" id="adminHome"> <a href="ValidLogin.jsp"> <i class="fa fa-home" aria-hidden="true"></i> Home </a> </div>
	</div>
	<div id=contentDiv>
	<%
		ArrayList<Products> productsList= (ArrayList)(request.getAttribute("productlist"));
		if(!productsList.isEmpty()){
		%>
		<table border=1>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Category Name</th>
				<th>Price</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<%
			for(Products product:productsList){
		%>
			<tr>
				<td><%=product.getProductId()%></td><td><%=product.getProductName()%></td>
				<td><%=product.getCategoryName()%></td><td><%=product.getProductPrice()%></td>
				<td><a href="Editproduct.do?productId=<%=product.getProductId()%>"><button type="button">Edit</button></a></td>
				<td><a href="DeleteProduct.do?productId=<%=product.getProductId()%>"><button type="submit">Delete</button></a></td>
			</tr>
			<%
			}
		 }
		else{%>
			<h1>Record Not Found..</h1>
			<%} %>
		</table>
		</div>
		<%@include file="Footer.jsp"%>
</body>
</html>