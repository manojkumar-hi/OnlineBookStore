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

@WebServlet("/Viewcart")
public class Viewcart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the username from the session attribute
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

            // Prepare a SQL statement to fetch data from the user's cart table
            String cartTableName = username + "cart";
            String sql = "SELECT bookname, price, quantity FROM " + cartTableName;
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Render the HTML table with the fetched data
            out.println("<h2>Your Cart</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Book Name</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("<th></th>");
            out.println("</tr>");

            double total = 0;
			while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("bookname") + "</td>");
                out.println("<td>" + resultSet.getDouble("price") + "</td>");
                out.println("<td>" + resultSet.getInt("quantity") + "</td>");
                
                // Calculate and display the total price for each book
                double totalPriceForBook = resultSet.getDouble("price") * resultSet.getInt("quantity");
                out.println("<td>" + totalPriceForBook + "</td>");
                
                // Add select and remove buttons dynamically
                out.println("<td><button class=\"select-button\" onclick=\"selectBook('" + resultSet.getString("bookname") + "')\">Buy Now</button></td>");
                out.println("<td><form action=\"/RemoveCart\" method=\"post\"><input type=\"hidden\" name=\"bookname\" value=\"" + resultSet.getString("bookname") + "\">" +
                        "<button class=\"remove-button\">Remove</button></form></td>");

                
                out.println("</tr>");
                
                // Update total price of all books
                total += totalPriceForBook;
            }
            // Display total price at the end of the table
            out.println("<tr>");
            out.println("<td colspan=\"3\">Total Price:</td>");
            out.println("<td colspan=\"2\">" + total + "</td>");
            out.println("</tr>");
            out.println("</table>");

            // Close the connections
            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    }
}