<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add to Cart Message</title>
    <style>
        .message {
            text-align: center;
            margin-top: 50px;
            font-size: 18px;
        }
        .success {
            color: green;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
    <div class="message">
        <% 
            String message = (String)request.getAttribute("message");
            if(message != null) {
                if(message.startsWith("Book successfully added")) { %>
                    <p class="success"><%= message %></p>
                <% } else { %>
                    <p class="error"><%= message %></p>
                <% }
            } %>
    </div>
</body>
</html>
    