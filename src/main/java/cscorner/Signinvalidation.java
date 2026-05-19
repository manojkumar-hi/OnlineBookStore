package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.*;

@WebServlet("/Signinvalidation")
public class Signinvalidation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String dbUsername = "root";
        String dbPassword = "Manoj@123";

        // SQL query to check if the username and password match
        String query = "SELECT * FROM admin WHERE AdminName=? AND AdminPassword=?";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, Username);
            pstmt.setString(2, Password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                // Successful sign-in
                response.sendRedirect("AdminPage.jsp");
            } else {
                // Invalid credentials
                response.sendRedirect("HomePage.jsp?error=invalid_credentials");
            }
            
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


