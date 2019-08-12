 <%@page import="mz.dbservice.UsersDbService"%>
  <%@page import="mz.beans.Products"%>
  <%@page import="java.util.ArrayList"%>
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
	#imageDiv{
		width:50%;
		padding:27px;
		margin-bottom :5%;
	}
	#detailsDiv{
		width:50%;
	}
	p{
		margin:5px;
	}
	button{
		color:white;
		background: #f3ac41;
		padding: 10px;
		margin-right: 20px;
		width:15%;
		border-radius: 8px;
	}
	#buyBtn{
		background: #7db77d;
		margin:0;
	}
	table{
		width:100%;
	}
	td{
		padding:5px;
	}
	input{
		width:7%;
	}
</style>
</head>
<body>
	<div id=container>
	<%@include file="Header.jsp"%>
		<%@include file="CartHeader.jsp" %>
			<div id="content">
				<div id=imageDiv>
					<%
						String imgName=request.getParameter("imageName");
					
					%>
					<img alt="" src="Images/<%=imgName%>" height="300px" width="350px">
				</div>
				<div id="detailsDiv">
					<%
						int productId=Integer.parseInt(request.getParameter("productId"));
						Products product=UsersDbService.getProduct(productId);
					%>
					<table>
						<tr><td><h2><%=product.getProductName()%></h2></td></tr>
						<tr><td><p><strong>Product Description:: </strong><br><br><%=product.getDescription() %></p></td></tr>
						<tr><td><p><strong>Price:: </strong><%=product.getProductPrice() %></p></td></tr>
						<tr><td><p><strong>Qty:: </strong><input id="qtyInput" name="quantity" type="number" value="1" onclick="quantity(this.value)"></p></td></tr>
						<tr><td><p><a href="" onclick="this.href='AddToCart.do?productName=<%=product.getProductName() %> &price=<%=product.getProductPrice()%> &quantity='+document.getElementById('qtyInput').value">
						<button>Add to Cart</button></a><a href="Buy.do"><button id="buyBtn">Buy</button></a></p></td></tr>
					</table>
				</div>
			</div>
	<%@include file="Footer.jsp"%>
	</div>
			
</body>
<script type="text/javascript">
	function quantity(value){
		if(value<1){
			document.getElementById("qtyInput").value=1;
		}
	}
</script>
</html>