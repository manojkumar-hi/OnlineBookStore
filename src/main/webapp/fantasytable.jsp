<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Book Data</title>


<style>
    /* Optional: Add some margin to the bottom of the table */
    table {
        margin-bottom: 50px; /* Adjust as needed */
        position: relative;
    }

    /* Go to Cart button */
    .go-to-cart-btn {
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        position: absolute;
        bottom: 20px;
        right: 20px;
    }

    /* Back button */
    .back-btn {
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        position: absolute;
        bottom: 20px;
        right: 140px; /* Adjust as needed */
    }
</style>
</head>
<body>
    
    <table border="1">
        <%
        
        String username = request.getParameter("username");
        // Include the servlet to retrieve and display the data, passing the username as a request attribute
        request.setAttribute("username", username);
            // Include the servlet to retrieve and display the data
            request.getRequestDispatcher("/FantasyServlet").include(request, response);
        %>
    </table>

    <!-- Go to Cart button -->
    <form action="Viewcart.jsp" method="get">
     <input type="hidden" name="username" value="<%= username %>"> <!-- Pass the username to Viewcart.jsp -->
        <input type="submit" value="Go to Cart" class="go-to-cart-btn">
    </form>

    <!-- Back button -->
    <form action="Books.jsp" method="get">
        <input type="submit" value="Back" class="back-btn">
    </form>

</body>
</html>
