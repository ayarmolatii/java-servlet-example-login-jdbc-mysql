package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/university";
    private static final String JDBC_USER = "user";
    private static final String JDBC_PASSWORD = "UserPassword123!";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //out.println("<h2>ACCESS GRANTED</h2>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body {");
		out.println("  display: flex;");
		out.println("  justify-content: center;");
		out.println("  align-items: center;");
		out.println("  height: 100vh;");
		out.println("  background-color: #f4f4f9;");
		out.println("  font-family: Arial, sans-serif;");
		out.println("  margin: 0;");
		out.println("}");
		out.println(".message {");
		out.println("  background-color: #4CAF50;");
		out.println("  color: white;");
		out.println("  padding: 20px;");
		out.println("  border-radius: 8px;");
		out.println("  font-size: 24px;");
		out.println("  text-align: center;");
		out.println("  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='message'>");
		out.println("<h2>ACCESS GRANTED</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

            } else {
                //out.println("<h2>ACCESS DENIED</h2>");
		out.println("<html>");
		out.println("<head>");
		out.println("<style>");
		out.println("body {");
		out.println("  display: flex;");
		out.println("  justify-content: center;");
		out.println("  align-items: center;");
		out.println("  height: 100vh;");
		out.println("  background-color: #f4f4f9;");
		out.println("  font-family: Arial, sans-serif;");
		out.println("  margin: 0;");
		out.println("}");
		out.println(".message {");
		out.println("  background-color: #f44336;");  // Red color for "ACCESS DENIED"
		out.println("  color: white;");
		out.println("  padding: 20px;");
		out.println("  border-radius: 8px;");
		out.println("  font-size: 24px;");
		out.println("  text-align: center;");
		out.println("  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='message'>");
		out.println("<h2>ACCESS DENIED</h2>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace();
        }
    }
}
