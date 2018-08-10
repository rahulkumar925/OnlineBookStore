<!-- Books Cart -->

<!-- cart detail page will be displayed(cartdetails.jsp), 
this page will show the list of all products added to the cart in tabular format. 
every row will have a single product with "Remove from cart" button/hyperlink 
for every row(like you saw in class of EMS project, where every employee was in tabular format
and each employee was occupying a row of a table and each row had "Delete" and "Edit" button/hyperlink). -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center"><jsp:include page="header.jsp"></jsp:include></div>
	<div align="center">
		<h3>
			<b>Books added in the Cart</b>
		</h3>
	</div>
	<div align="left">
		<a href="homePage.app"><h2>
				<b>Home</b>
			</h2></a>
	</div>
	<div align="right">
		<a href="cart.app">Cart: ${sessionScope.count.size()}</a>
	</div>
	<div align="center">
		<jstl:if test="${sessionScope.count.size() == 0 }">
			<h3>
				<b>Cart Empty "Add Books First"</b>
			</h3>
		</jstl:if>
	</div>
	<jstl:if test="${sessionScope.count.size() > 0 }">
		<table border="1" align="center">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Cost</th>
			</tr>
			<jstl:forEach var="book" items="${requestScope.book}">
				<tr>
					<td>${book.productId}</td>
					<td>${book.productName}</td>
					<td>${book.productDescription}</td>
					<td>${book.cost}</td>
					<td><a href="delete.app?productId=${book.productId}">Remove
							Book</a></td>
				</tr>
			</jstl:forEach>
		</table>
	</jstl:if>
	<div align="right">Total: ${sessionScope.sum}</div>
	<div align="center"><jsp:include page="footer.jsp"></jsp:include></div>
</body>
</html>