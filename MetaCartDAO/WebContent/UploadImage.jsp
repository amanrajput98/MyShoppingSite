<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		width:50%;
		margin-left:25%;
		margin-right:25%;
		padding:105px 0px;
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
	button{
		background-color: #09a7658c;
		border-radius: 6px;
		width:30%;
		padding:10px;
		font-size: 20px;
		margin-left:33%;
	}
	.fa{
		font-size: 15px;
	}
	.fa-home{
		font-size:20px;
	}
	a{
		color:black;
		font-size: 20px;
	}
	.backHome{
		width: 50%;
	}
	#adminHome{
		text-align: right;
	}
	#customize{
		width:100%;
		background-color: #c2d1fbd4;
		padding:20px;
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
		<div class="backHome"> <a href="CustomizeImage.do">Customize <i class="fa fa-chevron-circle-right" aria-hidden="true"></i></a> </div>
		<div class="backHome" id="adminHome"> <a href="ValidLogin.jsp"> <i class="fa fa-home" aria-hidden="true"></i> Home </a> </div>
	</div>
	<div id="content">
		<form action="UploadImage.do" enctype="multipart/form-data" method="post">
			<table>
				<tr>
					<td>Product Name :</td><td><input type="text" value="" name="productName" placeholder="Enter the product Name-"></td>
				</tr>
				<tr>
					<td>Choose Image :</td><td><input id="fileInput" type="file" value="" name="image"></td>
				</tr>	
				<tr>
					<td colspan="2"><button type="submit" onclick="return noFileChoosen()">Add</button></td>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
</body>
<script type="text/javascript"> 
	function noFileChoosen(){
		var inputs=document.getElementsByTagName("input");
		var productName=inputs[0].value;
		var fileName=inputs[1].value;
		if(fileName.endsWith(".jpg")||fileName.endsWith(".png")||fileName.endsWith(".jpeg")){
			return true;
		}else if(productName==""){
			alert("please Enter the Product Name...");
			return false;
		}else{
			alert("Please choose the image...");
			return false;
		}
	}
</script>
</html>