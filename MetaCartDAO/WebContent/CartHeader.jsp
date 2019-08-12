<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList"%>
    <%@page import="mz.beans.Products"%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
    	#home{
    		width:50%;
    		
    	}
    	.fa-home{
			font-size:25px;
			color:black;
		}
    	#cart{
    		width:50%;
    		text-align: right;
    	}
    </style>
	 <%
   		ArrayList<Products> cartList=null;
    	int noOfProducts=0;
    	if(session.getAttribute("productList")!=null){
    		cartList=(ArrayList)session.getAttribute("productList");
    		noOfProducts=cartList.size();
    	}
    	
    %> 
<div id=cartHeader>
<div id="home"><h2><i class="fa fa-home" aria-hidden="true"></i> <a href="Welcome.jsp">Home</a></h2></div><div id=cart><h2><a href="Cart.jsp"><i class="fa fa-cart-arrow-down" aria-hidden="true"></i> Cart : <%=noOfProducts %> </a></h2></div>
</div>