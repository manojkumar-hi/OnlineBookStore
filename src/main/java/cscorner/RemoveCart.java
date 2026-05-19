package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/RemoveCart")
public class RemoveCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters from the request
        String bookname = request.getParameter("bookname");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String dbUsername = "root";
        String dbPassword = "Manoj@123";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Prepare a SQL statement to delete the specified row from the user's cart table
            String cartTableName = username + "cart";
            String sql = "DELETE FROM " + cartTableName + " WHERE bookname = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, bookname);

            // Execute the delete query
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                // If deletion successful, redirect back to Viewcart servlet to display updated cart
                response.sendRedirect(request.getContextPath() + "/Viewcart");
            } else {
                // If no rows were deleted, display a message indicating failure
                PrintWriter out = response.getWriter();
                out.println("Failed to remove item from the cart.");
            }

            // Close the connections
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            out.println("Error: " + e.getMessage());
        }
    }
}



