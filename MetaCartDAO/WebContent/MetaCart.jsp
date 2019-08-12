<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mz.dbservice.UsersDbService"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="mz.beans.Products"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<style>
	#choice{
		width:30%;
		padding:10px;
	}
	#displayItem{
		width:70%;
		padding:10px;
		display: table;
	}
	.row{
		display: table-row;
		width:100%;
		padding:30px;
	}
	.cell{
		display: table-cell;
	}
	.imageCell{
		width:30%;
	}
	.detailsCell{
		width:70%;
	}
	ul{
		padding:10px;
		margin-bottom: 175px;
	}
	
	li{
		font-size:25px;
		font-weight:bold;
		padding:20px;
	}
	li a:active{
		color:orange;
	} 
	/* li a:visited{
		color:grey;
	}  */
	li a:link{
		color:red;
	} 
</style>
</head>
<body>
	<div id=container>
	<%@include file="Header.jsp"%>
		<div id="content">
			<%@include file="CartHeader.jsp" %>
			<div id="choice">
				<ul type="none">
					<li><a href="ShowProducts.do?categoryName=Soft Toys" class="category" onclick="changeColor(this)">Soft Toys</a></li>
					<li><a href="ShowProducts.do?categoryName=Laptop" class="category" onclick="changeColor(this)">Laptops</a></li>
					<li><a href="ShowProducts.do?categoryName=Mobiles" class="category" onclick="changeColor(this)">Mobiles</a></li>
				</ul>
			</div>
			<div id="displayItem">
		 <%
		ArrayList<Products> displayList= (ArrayList)(request.getAttribute("MetaCartProducts"));
		%>
		<%
			for(Products product:displayList){
				String shortDescription=product.getDescription();
				String[] parts = shortDescription.split("-");
				String part1 = parts[0]; 
		%>
				<div class="row">
					<div class="cell imageCell">
						<%
						String imageName=UsersDbService.getImages(product.getProductName());
						%>
						<img src="Images/<%=imageName%>" width="220" height="150">
					</div>
					<div class="cell detailsCell">
						<h2><a href="DetailedProduct.jsp?imageName=<%=imageName %>&productId=<%=product.getProductId()%>"><%=product.getProductName() %></a></h2>
						<p style="margin-bottom: 5px"><%=part1%></p>
						<p><strong>Price::</strong> <%=product.getProductPrice() %></p>
					</div>
				</div>
				<%
				}
				%>  
			</div>
		</div>
	<%@include file="Footer.jsp"%>	
	</div>
</body>
<script>
	function changeColor(link){
		//var categories=document.getElementsByClassName('category');
		//link.st
	}
</script>
</html>