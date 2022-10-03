<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<div>
		<a href="${pageContext.request.contextPath}/admin/">
			<img alt="" src="../images/AmarBoiAdminLogo.png">
		</a>
	</div>
	<div>
		<b>Welcome, <c:out value="${sessionScope.useremail }"></c:out></b>| <a href="logout">Logout</a> <br /> <br />
	</div>
	<div id="headermenu" >
			<div>
				<a href="list_users"> <img src="../images/users.png"><br/>Users</a>|
			</div>
			<div>
				<a href="list_category"><img src="../images/categories.png"><br/>Categories</a>
			</div>
			<div>
				<a href="list_books"><img src="../images/books.png"><br/>Books</a>
			</div>
			<div>
				<a href="list_customer"><img src="../images/customer.png"><br/>Customers</a>
			</div>
			<div>
				<a href="list_review"><img src="../images/reviews.png"><br/>Reviews</a>
			</div>
			<div>
				<a href="list_order"><img src="../images/orders.png"><br/>Orders</a>
			</div>
		</div>
</div>