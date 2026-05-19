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

@WebServlet("/AdminRegistrationServlet")  // ✅ THIS IS NECESSARY
public class AdminRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "Manoj@123");
            String n = request.getParameter("Username1");
            String p = request.getParameter("Password1");
            String e = request.getParameter("Email1");
            String m = request.getParameter("Mobile1");
            PreparedStatement ps = con.prepareStatement("INSERT INTO admin (AdminName, AdminPassword, AdminEmail, AdminMobile) VALUES (?, ?, ?, ?)");
            ps.setString(1, n);
            ps.setString(2, p);
            ps.setString(3, e);
            ps.setString(4, m);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                out.println("<font color=green size=18> Registration Successful!!<br>");
                out.println("<a href=UserRegistration.jsp> Login Here !!");
            } else {
                out.println("<font color=red size=18> Registration Failed!!<br>");
                out.println("<a href=UserRegistration.jsp> Try Again !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("An error occurred: " + e.getMessage());
        }
    }
}
