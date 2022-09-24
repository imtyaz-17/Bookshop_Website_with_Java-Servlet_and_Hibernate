<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Categories- Aamar Boi Administration</title>
<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div align="center">
		<h2>Category Management </h2>
		<h3><a href="category_form.jsp">Create New Category</a></h3>
		
	</div>
	<c:if test="${message != null}">
	<div align="center">
		<h4 class="message">${message}</h4>
	</div>
	</c:if>
	<div align="center">
	
	<table border="1">
		<tr>
			<th>Index</th>
			<th>Id</th>
			<th>Category Name</th>
			<th>Action</th>
		</tr>
		<c:forEach var="category" items="${listCategory}" varStatus="status">
			<tr>
				<td>${status.index+1}</td>	
				<td>${category.categoryId}</td>
				<td>${category.name}</td>	
				<td>
				<a href="edit_category?id=${category.categoryId}">Edit</a> &nbsp;&nbsp;
				<a href="javascript:confirmDelete(${category.categoryId })">Delete</a>
				</td>			
			</tr>
		</c:forEach>
		
	</table>
	
	</div>
	

	<jsp:directive.include file="footer.jsp" />
	
	<script type="text/javascript">
		function confirmDelete(categoryId){
			
			if(confirm('Are you Sure you want to Delete the Category with ID ' + categoryId + ' ??')){
				window.location = 'delete_category?id=' + categoryId;
			}
		}
	</script>

</body>
</html>