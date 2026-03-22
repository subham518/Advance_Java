package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/admin")
public class Admin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        HttpSession session = request.getSession(false);

        String role = (String) session.getAttribute("role");

        if(!"ADMIN".equals(role)){
            response.getWriter().println("Access Denied!!");
        }

        response.getWriter().println("Admin Panel");
    }
}