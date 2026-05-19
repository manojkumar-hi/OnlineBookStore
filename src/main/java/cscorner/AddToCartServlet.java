package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // Import HttpSession from javax.servlet.http
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve parameters from the request
    	 String username = request.getParameter("username");
        String bookname = request.getParameter("bookname");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantityRequested = Integer.parseInt(request.getParameter("quantity"));
        int quantityAvailable = Integer.parseInt(request.getParameter("quantityAvailable")); // Retrieve quantity available
        
        String message;
       

       if (username != null) {
            // If the user is logged in, insert the book into their cart table
            insertIntoCart(username, bookname, price, quantityRequested);
             // Redirect to View Cart page
            message = "Book successfully added to cart.";
            
        } else {
            // If the user is not logged in, redirect to the login page
           // Change the path to your login page
        	 message = "Failed to add book to cart.";
        }
    // Set message as request attribute to be displayed in the JSP
       request.setAttribute("message", message);
       // Forward the request to a JSP page to display the message
       request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    // Method to insert book into user's cart table
    private void insertIntoCart(String username, String bookname, double price, int quantity) {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "Manoj@123");
            String cartTableName = username + "cart";
            String insertQuery = "INSERT INTO " + cartTableName + " (bookname, price, quantity) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, bookname);
            ps.setDouble(2, price);
            ps.setInt(3, quantity);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle exception
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}

