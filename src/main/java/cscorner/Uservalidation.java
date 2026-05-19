package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.*;
import java.sql.*;
@WebServlet("/Uservalidation")
public class Uservalidation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String dbUsername = "root";
        String dbPassword = "Manoj@123";

        // SQL query to check if the username and password match
        String query = "SELECT * FROM user WHERE UserName=? AND UserPassword=?";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, Username);
            pstmt.setString(2, Password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("username", Username);
                // Successful sign-in
                response.sendRedirect("UserPage.jsp");
                
                // Create cart table for the user
                String cartTableName = Username + "_cart";
                String createCartTableQuery = "CREATE TABLE IF NOT EXISTS " + cartTableName + " ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY,"
                        + "bookname VARCHAR(255),"
                        + "price DOUBLE,"
                        + "quantity INT"
                        + ")";
                PreparedStatement createCartTableStatement = con.prepareStatement(createCartTableQuery);
                createCartTableStatement.executeUpdate();
                
                // Create orders table for the user
                String ordersTableName = Username + "_orders";
                String createOrdersTableQuery = "CREATE TABLE IF NOT EXISTS " + ordersTableName + " ("
                        + "OrderID INT AUTO_INCREMENT PRIMARY KEY,"
                        + "OrderDate DATE,"
                        + "OrderDetails VARCHAR(255)"
                        + ")";
                PreparedStatement createOrdersTableStatement = con.prepareStatement(createOrdersTableQuery);
                createOrdersTableStatement.executeUpdate();
                
            } else {
                // Invalid credentials
                response.sendRedirect("HomePage.jsp?error=invalid_credentials");
            }
            
            con.close();
        }   catch (Exception e) {
            e.printStackTrace();
        }
    }
}
