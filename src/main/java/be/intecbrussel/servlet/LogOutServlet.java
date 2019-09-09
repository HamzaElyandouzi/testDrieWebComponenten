package be.intecbrussel.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logout", value = "/logout")
public class LogOutServlet extends HttpServlet {


    /*
    *the following doPost methode removes the name attribute end closes/invalidates
    * the session.
    * afterwards it will redirect towards back to the login page.
    */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("name");
        httpSession.invalidate();
        RequestDispatcher requestDispatcher = request
                .getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }
}
