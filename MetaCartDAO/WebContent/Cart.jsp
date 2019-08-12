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
<style type="text/css">
	table{
		width:100%;
		margin: 30px 0;
	}	
	td{
		padding:10px;
		text-align: center;
		width:16%;
	}	
	th{
		background: #bdbdf7;
	}
	table,th,td{
		border:1px solid black;
	}
	#content{
		width:80%;
		margin-left: 10%;
		margin-bottom: 18%;
	}	
	#content p{
		margin:10px 0;
		font-size: 20px;
		color:red;
	}
	button{
		width:10%;
		padding:10px;
		border-radius:6px;
		background: #f3ac41;
		color:white;
	}
	#buyBtn{
		background: #7db77d;
	}
	#removeBtn{
		padding:8px;
		width:50%;
	}
</style>
</head>
<body>
	<%@include file="Header.jsp" %>
	<%@include file="CartHeader.jsp"%>
	<div id="content">
		<table id="productTable">
			<tr>
				<th>Sr.No.</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Qty.</th>
				<th>SubTotal</th>
				<th>Remove</th>
			</tr>
			  <%
			  ArrayList<Products> productList=null;
			  int totalPrice=0;
			  if(session.getAttribute("productList")!=null){
				productList=(ArrayList)(session.getAttribute("productList"));
				int sNo=1;
				System.out.print(productList);	
				for(int i=0;i<productList.size();i++){
					Products product = productList.get(i);
					totalPrice+=product.getProductPrice()*product.getQuantity();
			%>
			 <tr>
				<td><%=sNo++%></td>
				<td><%=product.getProductName() %></td>
				<td>&#8360;.<%=product.getProductPrice()%></td>
				<td><%=product.getQuantity() %></td>
				<td>&#8360;.<%=product.getProductPrice()*product.getQuantity()%></td>
				<td><a href="DeleteFromCart.do?indexPos=<%=i%>"><button id="removeBtn">Remove</button></a></td>
			</tr>
				<%
				}
			}
		//}
		%>
		</table>
		<p>Total Amount : <%=totalPrice %></p>
		
		<p><a href="ShowProducts.do?categoryName=soft Toys"><button>Continue</button></a>  <a href="Buy.do"><button id="buyBtn">Buy</button></a></p>
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>