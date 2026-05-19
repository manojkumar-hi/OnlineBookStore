package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/BiographyServlet")
public class BiographyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = (String) request.getAttribute("username");
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String username1 = "root";
        String password = "Manoj@123";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username1, password);

            // Prepare a SQL statement to fetch data for the Fiction category
            String sql = "SELECT bookname, price, quantity, authorname FROM biography";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Render the HTML page with the fetched data
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<title>Biography Books</title>");
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
            out.println("<h2 class=\"category-heading\">Biography Books</h2>");
            out.println("<div class=\"results\">");
            out.println("<table>");
            out.println("<tr><th>Book Name</th><th>Price</th><th>Quantity</th><th>Author Name</th><th>  </th></tr>");

            // Iterate through the result set and display data in HTML table
            while (resultSet.next()) {
                out.println("<tr>");
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