<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
	
<script  src="https://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js" type="text/javascript"></script>

<script>
$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );

function deleteConfirm() {
	return confirm("are you sure? You want to delete");
}
</script>
	
	

</head>
<body>
<h3>View Contacts here</h3>
	<a href="addContact">+Add Contacts</a>
	<table border="1"  id="example">
		<thead>
			<tr>
				<th>Sl No.</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone Number</th>
				<th>Action</th>
			<tr/>
			</thead>
		
		<tbody>
			<c:forEach items="${contact}" var="c" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${c.contactName}</td>
					<td>${c.contactEmail}</td>
					<td>${c.contactNumber}</td>
					<td><a href="editContact?id=${c.contactId}">Edit</a> | | <a
						href="deleteContact?id=${c.contactId}"
						onclick="return deleteConfirm()">Delete</a> 
					</td>

				</tr>


			</c:forEach>

		</tbody>
	</table>

</body>
</html>