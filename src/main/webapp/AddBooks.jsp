<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book Form</title>
<link rel="stylesheet" href="css/Addbook.css">

</head>
<body>
	<div class="container">
		<h1>Add Book</h1>
		<form action="AddBookServlet" method="post">
			<!-- Replace "addBookServlet" with your actual servlet URL -->
			<label for="category">Select a Book Category:</label> <select
				name="category" id="category">
				<option value="fiction">Fiction</option>
				
				<option value="fantasy">Fantasy</option>
				
				
				<option value="biography">Biography</option>

				

				<!-- Add more options as needed -->
			</select> <br>
			<br> <label for="bookName">Book Name:</label> <input type="text"
				id="bookName" name="bookName" required> <br>
			<br> <label for="price">Price:</label> <input type="number"
				id="price" name="price" min="0.01" step="0.01" required> <br>
			<br> <label for="quantity">Quantity:</label> <input
				type="number" id="quantity" name="quantity" min="1" required>
			<br>
			<br> <label for="authorName">Author Name:</label> <input
				type="text" id="authorName" name="authorName" required> <br>
			<br> <input type="submit" value="Add Book">
		</form>
	</div>
</body>
</html>
