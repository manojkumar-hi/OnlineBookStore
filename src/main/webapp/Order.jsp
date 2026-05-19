<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Order Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f7ff; /* Light blue background */
            color: #333; /* Dark text color */
            margin: 0;
            padding: 0;
        }

        h1 {
            color: #0080ff; /* Blue heading color */
        }

        form {
            background-color: #fff; /* White background */
            width: 60%;
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            border: 2px solid #0080ff; /* Blue border */
        }

        label {
            color: #0080ff; /* Blue label color */
        }

        input[type="text"],
        input[type="number"],
        select,
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #0080ff; /* Blue border */
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #0080ff; /* Blue button background */
            color: #fff; /* White text color */
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #005cbf; /* Darker blue on hover */
        }

        .book {
            margin-bottom: 10px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th, td {
            padding: 8px;
            border-bottom: 1px solid #0080ff; /* Blue border */
        }

        th {
            background-color: #0080ff; /* Blue header background */
            color: #fff; /* White text color */
        }

        tr:nth-child(even) {
            background-color: #f2f2f2; /* Light gray background for even rows */
        }
    </style>
    <script>
        function selectBook(bookname) {
            // AJAX request to Viewcart servlet to select the book
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/Viewcart?bookname=" + encodeURIComponent(bookname), true);
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    // Handle the response here if needed
                    console.log(xhr.responseText);
                }
            };
            xhr.send();
        }
    </script>
</head>
<body>

<h1>User Order Page</h1>

<table>
    <tr>
        <th>Books</th>
        <th>Total Price</th>
    </tr>
    <%-- Insert code here to iterate over cart items and display in table --%>
</table>

<form action="ProcessOrderServlet" method="post">
    <label for="address">Address:</label><br>
    <textarea id="address" name="address" rows="4" cols="50" required></textarea><br><br>
    
    <label for="paymentMethod">Select Payment Method:</label><br>
    <select id="paymentMethod" name="paymentMethod" required>
        <option value="">Select Payment Method</option>
        <option value="Credit Card">Credit Card</option>
        <option value="PayPal">PayPal</option>
    </select><br><br>
    
    <input type="submit" value="Place Order">
</form>

</body>
</html>
    