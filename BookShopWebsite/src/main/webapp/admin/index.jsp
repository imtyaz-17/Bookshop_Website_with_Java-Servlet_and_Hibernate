<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aamar Boi - Administration</title>

<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h1 class="pageheading">Administrative Dashboard</h1>
		<br/><br/>
	</div>
	<div align="center">
	<hr width="60%"/>
	<h2 class="pageheading">Quick Actions:</h2>
	<b>
		<a href="create_book">New Book</a> &nbsp;
		<a href="create_user">New User</a>&nbsp;
		<a href="create_category">New Category</a>&nbsp;
		<a href="create_customer">New Customer</a>
	</b>
	</div>
	
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading">Recent Sales:</h2>
	</div>
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading">Recent Reviews:</h2>
	</div>
	<div align="center">
	<hr width="60%"/>
		<h2 class="pageheading">Statistics:</h2>
	<hr width="60%"/>
	</div>

	<jsp:directive.include file="footer.jsp" />


</body>
</html>