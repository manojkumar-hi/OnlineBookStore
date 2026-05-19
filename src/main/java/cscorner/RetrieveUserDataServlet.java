package cscorner;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/RetrieveUserDataServlet")
public class RetrieveUserDataServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

            // SQL query to retrieve all data from the user table
            String sql = "SELECT * FROM user";

            // Create a PreparedStatement object
            statement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = statement.executeQuery();

            // Initialize a PrintWriter to send HTML response
            PrintWriter out = response.getWriter();

            // Set response content type
            response.setContentType("text/html");

            // Create the HTML table to display the retrieved data
            out.println("<html><body>");
            out.println("<h2 style='text-align: center; color: #007bff;'>All_Users</h2>");
            out.println("<table border='1'>");
            out.println("<tr><th>User ID</th><th>Email</th><th>Phone no:</th></tr>");

            // Iterate through the ResultSet and display each row in the table
            while (resultSet.next()) {
                out.println("<tr>");
            
                out.println("<td>" + resultSet.getString("UserName") + "</td>");
                out.println("<td>" + resultSet.getString("UserEmail") + "</td>");
                out.println("<td>" + resultSet.getString("UserMobile") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body></html>");

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
    }
}

