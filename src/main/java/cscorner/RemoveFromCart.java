package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/RemoveFromCart")
public class RemoveFromCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bookToRemove = request.getParameter("bookname");
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

            // Prepare a SQL statement to delete the specified book from the user's cart table
            String cartTableName = username + "cart";
            String deleteSql = "DELETE FROM " + cartTableName + " WHERE bookname=?";
            PreparedStatement deleteStatement = conn.prepareStatement(deleteSql);
            deleteStatement.setString(1, bookToRemove);

            // Execute the SQL statement to remove the book from the cart table
            deleteStatement.executeUpdate();

            // Update total price after removing the item
            String updateTotalSql = "SELECT SUM(price * quantity) AS total FROM " + cartTableName;
            PreparedStatement updateTotalStatement = conn.prepareStatement(updateTotalSql);
            ResultSet resultSet = updateTotalStatement.executeQuery();
            double total = 0;
            if (resultSet.next()) {
                total = resultSet.getDouble("total");
            }

            // Update total price in the user's cart table
            String updatePriceSql = "UPDATE users SET total_price=? WHERE username=?";
            PreparedStatement updatePriceStatement = conn.prepareStatement(updatePriceSql);
            updatePriceStatement.setDouble(1, total);
            updatePriceStatement.setString(2, username);
            updatePriceStatement.executeUpdate();

            // Close the connections
            resultSet.close();
            deleteStatement.close();
            updateTotalStatement.close();
            updatePriceStatement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            // You may handle exceptions according to your application's requirements
        }

        // Redirect the user back to the cart view
        response.sendRedirect(request.getContextPath() + "/Viewcart");
    }
}


