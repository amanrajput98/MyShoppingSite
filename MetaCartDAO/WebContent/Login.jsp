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
	#loginDiv{
		width:100%;
		background: url("./Images/Login.jpg") no-repeat center;
		background-size: cover;
	}
	form{
		width:40%;
		margin-left:30%;
		margin-right:30%;
		padding:122px 0px;
	}	
	table{
		width:100%;
		border: 2px solid #c7c7c7;
		border-radius: 10px;
		padding:23px;
	}
	td{
		padding:10px;
		text-align: center;
		font-size: 20px;
		font-weight:bold;
		color: #c7c7c7;
	}
	input{
		padding:10px;
		font-size: 20px;
		width:100%;
		border-radius: 5px;
	}
	button{
		background-color: #09a798;
		border-radius: 6px;
		width:30%;
		padding:10px;
		font-size: 20px;
		color:white;
	}
	#back{
		width:100%;
		background-color: #c2d1fbd4;
		padding:20px;
		text-align: right;
		font-size: 20px;
	}
	.fa-home{
		font-size:20px;
	}
	a{
		color :black
	}
</style>
</head>
<body>	
	<div id=container>
		<%@include file="Header.jsp"%>
		<div id="back">
			<a href="Welcome.jsp"> <i class="fa fa-home" aria-hidden="true"> </i> Home</a>
		</div>
		<div id=loginDiv>
		<form action="login.do">
			<table>
				<tr><td>Email Id :</td><td><input type="text" placeholder="Enter your EmailId" value="" name="email"></td></tr>
				<tr><td>Password :</td><td><input type="Password" placeholder="Enter your Password" value="" name="password"></td></tr>
				<tr><td colspan="2"><button type="submit">Login</button></td></tr>
			</table> 
		</form>
		</div>
			<%@include file="Footer.jsp"%>
	</div>
</body>
</html>