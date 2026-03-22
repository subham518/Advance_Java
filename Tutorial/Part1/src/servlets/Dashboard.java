package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        String user = (String) session.getAttribute("username");
        String role = (String) session.getAttribute("role");

        var out = response.getWriter();

        out.println("<h2>Welcome " + user + "</h2>");
        out.println("<a href='logout'>Logout</a><br>");

        // Admin link
        if("ADMIN".equals(role)){
            out.println("<br><a href='admin'>Go to Admin Panel></a>");
        }
    }
}