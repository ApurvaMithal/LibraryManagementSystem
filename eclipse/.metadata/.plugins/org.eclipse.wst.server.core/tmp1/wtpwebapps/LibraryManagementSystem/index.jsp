<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Book Search and Availability</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style>
		a:link {
    color: green;
    background-color: transparent;
    text-decoration: none;
}
a:visited {
    color: blue	;
    background-color: transparent;
    text-decoration: none;
}
a:hover {
    color: red;
    background-color: transparent;
    text-decoration: underline;
}
a:active {
    color: yellow;
    background-color: transparent;
    text-decoration: underline;
}
</style>
	</head>

	<body>

		<div class="container">
			<h1><font color = "red">Welcome to the Online Library Management System</font></h1>
			</br></br>
			<ul class="nav nav-pills">
				<li class="active"><a data-toggle="pill" href="#BookSearch">Book Search and Availability</a></li>
				<li><a data-toggle="pill" href="#BookLoans">Book Loans</a></li>
				<li><a data-toggle="pill" href="#BorrowerManagement">Borrower Management</a></li>
				<li><a data-toggle="pill" href="#Fines">Fines</a></li>
			</ul>
			</br>

			<div class="tab-content">
				<div id="BookSearch" class="tab-pane fade in active">
				<h3><font color = "green"><strong>Book Search and Availability</strong></font></h3></br>
				<h4>Searches for a book, given any combination of ISBN, title, and/
				or Author(s)</h4></br>
				<h4><a href="BookSearch.jsp" target="_blank">Visit Book Search Page</a> </h4>
				
				</div>
			<div id="BookLoans" class="tab-pane fade">
				<h3><font color = "green"><strong>Book Loans</strong></font></h3></br>
				<h4>Facilitates Checking in and Checking out of books.</h4></br>
				<h4><a href="CheckOutIn.jsp" target="_blank">Visit Check Out Page</a> </h4></br>
				<h4><a href="CheckIn.jsp" target="_blank">Visit Check In Page</a> </h4>
			</div>
			<div id="BorrowerManagement" class="tab-pane fade">
				<h3><font color = "green"><strong>Borrower Management</strong></font></h3></br>
				<h4>Create new borrowers in the system</h4></br>
				<h4><a href="BorrowerEntry.jsp" target="_blank">Visit Borrower Entry Page</a> </h4>
			</div>
			<div id="Fines" class="tab-pane fade">
				<h3><font color = "green"><strong>Fines</strong></font></h3></br>
				<h4>Handles fine management</h4></br>
				<h4><a href="Fines.jsp" target="_blank">Visit Fine Update Page</a> </h4></br>
				<h4><a href="FinePay.jsp" target="_blank">Visit Fine Pay / Display Page</a> </h4>
			</div>
			</div>
		</div>

	</body>
</html>
