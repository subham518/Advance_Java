package servlets;
// week 3 project with servlet.

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

@WebServlet("/students") // This is the URL path
public class StudentServlet extends HttpServlet {

    // GET: Triggered when you visit the URL directly in a browser
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("form.html").forward(request, response);

//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();

        // Let's try to read a 'name' parameter from the URL
//        String name = request.getParameter("user");

//        out.println("<h1>Hello!!</h1>");
    }

    // POST: Triggered by an HTML Form
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String url = "jdbc:mysql://localhost:3306/subhamdb";
        String user = "root";
        String password = "local@subham123";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url,user,password);

            String query = "INSERT INTO student_details (name, roll_no, phone, email) VALUES (?, ?, ?, ?)";
            PreparedStatement psmt = con.prepareStatement(query);
            psmt.setString(1,name);
            psmt.setString(2,rollno);
            psmt.setString(3, phone);
            psmt.setString(4,email);
            psmt.executeUpdate();
            out.println("Student Details Uploaded!!");

            String selectQuery = "SELECT * FROM student_details";
            PreparedStatement psmt2 = con.prepareStatement(selectQuery);
            ResultSet rs = psmt2.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name") +
                        " | Roll: " + rs.getString("roll_no") +
                        " | Phone: " + rs.getString("phone") +
                        " | Email: " + rs.getString("email"));
            }
            System.out.println();

            con.close();
        }catch (Exception e){
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
