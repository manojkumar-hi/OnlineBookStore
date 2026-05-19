package cscorner;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String category = request.getParameter("category");
        String bookName = request.getParameter("bookName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String authorName = request.getParameter("authorName");

        // JDBC driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost/bookstore";

        // Database credentials
        final String USER = "root";
        final String PASS = "Manoj@123";

        Connection conn = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Insert data into the category-specific table
            String insertCategoryQuery = null;
            switch (category) {
                case "fiction":
                    insertCategoryQuery = "INSERT INTO fiction (bookname, price, quantity, authorname) VALUES (?, ?, ?, ?)";
                    break;
                case "fantasy":
                    insertCategoryQuery = "INSERT INTO fantasy (bookname, price, quantity, authorname) VALUES (?, ?, ?, ?)";
                    break;
                case "biography":
                    insertCategoryQuery = "INSERT INTO biography(bookname, price, quantity, authorname) VALUES (?, ?, ?, ?)";
                    break;
                // Add more cases if you have more categories
            }

            // Execute the category-specific insert query
            stmt1 = conn.prepareStatement(insertCategoryQuery);
            stmt1.setString(1, bookName);
            stmt1.setDouble(2, price);
            stmt1.setInt(3, quantity);
            stmt1.setString(4, authorName);
            stmt1.executeUpdate();

            // Insert data into the 'addbook' table
            String insertAddBookQuery = "INSERT INTO addbook (category, bookname, price, quantity, authorname) VALUES (?, ?, ?, ?, ?)";
            stmt2 = conn.prepareStatement(insertAddBookQuery);
            stmt2.setString(1, category);
            stmt2.setString(2, bookName);
            stmt2.setDouble(3, price);
            stmt2.setInt(4, quantity);
            stmt2.setString(5, authorName);
            stmt2.executeUpdate();

            // Redirect to a success page or show a success message
            response.sendRedirect("success.html");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
            // Redirect to an error page or show an error message
            response.sendRedirect("error.html");
        } finally {
            // Close resources
            try {
                if (stmt1 != null)
                    stmt1.close();
                if (stmt2 != null)
                    stmt2.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
