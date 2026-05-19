<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Cart</title>
    <style>
        /* Styling for table */
        table {
            width: 70%;
            border-collapse: collapse;
            margin: 20px auto; /* Center the table */
        }

        th, td {
            border: 1px solid #007bff; /* Blue border */
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #007bff; /* Blue background */
            color: white; /* White text */
        }

        /* Styling for back button */
        .back-btn, .select-button, .remove-button {
            background-color: #007bff; /* Blue background */
            color: white; /* White text */
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            text-decoration: none; /* Remove underline */
            display: inline-block; /* Ensure buttons appear side by side */
        }

        .back-btn:hover, .select-button:hover, .remove-button:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        /* Adjust positioning for the back button */
        .back-btn {
            margin: 20px 20px 20px auto; /* Right align and add margin to the top */
        }
    </style>
</head>
<body>
    <h2>Shopping Cart</h2>
    
    <table id="cartTable">
        <tr>
            <th>Book Name</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
    </table>

    <!-- Back button -->
    <a href="Books.jsp?username=<%= session.getAttribute("username") %>" class="back-btn">Check it for more</a>
      <a href="Order.jsp?username=<%= session.getAttribute("username") %>" class="back-btn">Order</a>
    
    

    <script>
        // Function to make AJAX call to retrieve cart data from servlet
        function loadCartData() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("cartTable").innerHTML = this.responseText;
                }
            };
            var username = "<%= request.getParameter("username") %>";
            xhttp.open("GET", "Viewcart?username=" + username, true); // Pass the username as a query parameter
            xhttp.send();
        }

        // Call the function to load cart data when the page loads
        window.onload = function() {
            loadCartData();
        };
    </script>
    <script>
        function selectBook(bookname) {
            // Implement logic to select the book
            console.log("Selected book: " + bookname);
        }

        function removeBook(bookname) {
            // Implement logic to remove the book
            console.log("Removed book: " + bookname);
        }
    </script>
</body>
</html>
