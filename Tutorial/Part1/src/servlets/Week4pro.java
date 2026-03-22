package servlets;

// project for authentication and authorization.(secure login system)

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class Week4pro extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String user = request.getParameter("username");
        String password = request.getParameter("password");

        //Demo authentication
        if(user.equals("admin") && password.equals("1234")){

            HttpSession oldSession = request.getSession(false);
            if(oldSession != null){
                oldSession.invalidate();
            }
            HttpSession session = request.getSession(true);

            session.setAttribute("username", user);
            session.setAttribute("role", "ADMIN");

            session.setMaxInactiveInterval(300);

            response.sendRedirect("dashboard");
        }
        else if(user.equals("user") && password.equals("1111")){
            HttpSession session = request.getSession();

            session.setAttribute("username", user);
            session.setAttribute("role", "USER");

            response.sendRedirect("dashboard");
        }
        else{
            response.getWriter().println("Invalid Credentials!!");
        }
    }
}