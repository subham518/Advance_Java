package servlets;
// week 4 code

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/cookies") // to set cookies
//public class SessionManagement extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException{
//
//        //creating cookie
//        Cookie cookie = new Cookie("username", "subham2");
//
//        //setting cookie expiry (in seconds
//        cookie.setMaxAge(60*60);
//
//        //adding cookie to response
//        response.addCookie(cookie);
//
//        PrintWriter out = response.getWriter();
//        out.println("Cookie Created Successfully!");
//    }
//}

//@WebServlet("/cookiescheck") // route for read and check the cookies
//public class SessionManagement extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//
//        Cookie[] cookies = request.getCookies();
//        PrintWriter out = response.getWriter();
//
//        if (cookies != null){
//            for (Cookie c: cookies){
//                out.println("Name:"+ c.getName());
//                out.println("Value:"+ c.getValue());
//            }
//        }else {
//            out.println("No Cookies Found");
//        }
//    }
//}

//@WebServlet("/login")// servlet for URL Rewriting
//public class SessionManagement extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//
//        String user = request.getParameter("username");
//
//        PrintWriter out = response.getWriter();
//
//        out.println("<a href='welcome?username=" + user + "'>Go to Welcome Page</a>" );
//    }
//}

//@WebServlet("/welcome") // URL Rewriting Check
//public class URL_Rewriting_Check extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String user = request.getParameter("username");
//
//        PrintWriter out = response.getWriter();
//        out.println("Welcome: " + user);
//    }
//}

//@WebServlet("/Hidden_Field_Login")// servlet for HTML Hidden field login
//public class SessionManagement extends HttpServlet {
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//
//        response.setContentType("text/html");
//
//        String user = request.getParameter("username");
//
//        PrintWriter out = response.getWriter();
//
//        out.println("<form action='Hidden_Field_Welcome' method='post'>");
//        out.println("<input type='hidden' name='username' value='" + user + "'>");
//        out.println("<input type='submit' value='Go to Welcome'>");
//        out.println("</form>");
//
//
//    }
//}

//@WebServlet("/Hidden_Field_Welcome") // HTML Hidden field check route
//public class Hidden_field_Welcome extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException{
//
//
//        response.setContentType("text/html");
//
//        String user = request.getParameter("username");
//
//        PrintWriter out = response.getWriter();
//        out.println("Welcome: " + user);
//    }
//}

// two days code here: servlet chaining, filters, listeners and annotations

//@WebServlet( //servlet configure
//        urlPatterns = "/config",
//        initParams = {
//                @WebInitParam(name="student",
//                        value="subham")
//        }
//)
//public class SessionManagement extends HttpServlet{
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
//
//        ServletConfig config = getServletConfig();
//        String student = config.getInitParameter("student");
//        response.getWriter().println("Student:" + student);
//    }
//}

//@WebServlet("/context") //servlet context
//public class SessionManagement extends HttpServlet{
//    public void init(){
//        ServletContext context = getServletContext();
//        context.setAttribute("college", "GIET");
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        ServletContext context = getServletContext();
//
//        String college = (String) context.getAttribute("college");
//        response.getWriter().println("College:" + college);
//    }
//}





