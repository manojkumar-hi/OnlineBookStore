package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ViewallServlet")
public class ViewallServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract the username from the request attribute
        String username = request.getParameter("username");

        // JDBC URL, username, and password of MySQL server
        String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
        String dbUser = "root";
        String dbPassword = "Manoj@123";

        // Initialize variables for database connection and query
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);

            // SQL query to retrieve all data from the addbook table
            String sql = "SELECT * FROM Addbook";

            // Create a PreparedStatement object
            statement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = statement.executeQuery();

            // Initialize a PrintWriter to send HTML response
            PrintWriter out = response.getWriter();

            // Set response content type
            response.setContentType("text/html");

            // Create the HTML table to display the retrieved data
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Fantasy Books</title>");
            out.println("<style>");
            out.println(".container { text-align: center; }");
            out.println(".frame { border: 1px solid #ccc; padding: 20px; }");
            out.println(".category-heading { color: #007bff; }");
            out.println(".results table { width: 100%; border-collapse: collapse; }");
            out.println(".results th, .results td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            out.println(".results th { background-color: #007bff; color: white; }");
            out.println(".add-to-cart-btn { background-color: #007bff; color: white; border: none; border-radius: 5px; padding: 10px 20px; cursor: pointer; text-align: center; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"container\">");
            out.println("<div class=\"frame\">");
            out.println("<h2 class=\"category-heading\">Fantasy Books</h2>");
            out.println("<div class=\"results\">");
            out.println("<table>");
            out.println("<tr><th>Category</th><th>Book Name</th><th>Price</th><th>Quantity</th><th>Author Name</th><th>  </th></tr>");
            // Iterate through the result set and display data in HTML table
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("category") + "</td>");
                out.println("<td>" + resultSet.getString("bookname") + "</td>");
                out.println("<td>" + resultSet.getDouble("price") + "</td>");
                out.println("<td>" + resultSet.getInt("quantity") + "</td>");
                out.println("<td>" + resultSet.getString("authorname") + "</td>");
                out.println("<td>");
                out.println("<form action=\"AddToCartServlet\" method=\"post\">");
                out.println("<input type=\"hidden\" name=\"username\" value=\"" + username + "\">"); // Pass the username
                out.println("<input type=\"hidden\" name=\"bookname\" value=\"" + resultSet.getString("bookname") + "\">");
                out.println("<input type=\"hidden\" name=\"price\" value=\"" + resultSet.getDouble("price") + "\">");
                out.println("<input type=\"hidden\" name=\"quantityAvailable\" value=\"" + resultSet.getInt("quantity") + "\">"); // Add hidden input for quantity available
                out.println("<input type=\"number\" name=\"quantity\" value=\"1\" min=\"1\" max=\"" + resultSet.getInt("quantity") + "\">"); 
                out.println("<input type=\"submit\" value=\"Add to Cart\" class=\"add-to-cart-btn\">");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            // Close all resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        // Extract the book name parameter from the request
        String bookname = request.getParameter("bookname");
        
        if (bookname != null && !bookname.isEmpty()) {
            // Process the book name parameter
            // For example, you can log it or perform any other action
            
            // Send a response back to the client
            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Book name received: " + bookname);
        } else {
            // If no book name parameter is provided, handle it accordingly
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book name parameter is missing");
        }
    }
}
