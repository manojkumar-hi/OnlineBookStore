<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Users</title>
     <link rel="stylesheet" type="text/css" href="css/Sales.css">
</head>
<body>
   
    <!-- Include the servlet to retrieve and display the user data -->
    <table border="1">
        <%
            // Include the servlet to retrieve and display the user data
            request.getRequestDispatcher("/RetrieveUserDataServlet").include(request, response);
        %>
    </table>
</body>
</html>
