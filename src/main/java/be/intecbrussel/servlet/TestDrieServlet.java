package be.intecbrussel.servlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testdrie", value = "/testdrie")
public class TestDrieServlet extends HttpServlet {
    private String name;


    //when the servlet is called it will automatically call the doGet first.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //if the name reference is null it will redirect to the login will not change the url.
        if (name == null){
                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this methode will save the name name reference with the value
        //send from the login form with the name of login.
        name =  request.getParameter("login");;

        try {
            //if the isName methode returns true.
            if (isName(name)) {
                //the following code will set the following attribute to the name value
                //and makes it accessible to the session so it can be called up from
                // the other servlets and jsp
                request.setAttribute("name", name);
                //afterwards it will redirect towards the welcome page which will contain
                // the name printed on the page
                RequestDispatcher requestDispatcher = request
                        .getRequestDispatcher("/welcome.jsp");
                requestDispatcher.forward(request, response);
            } else {

                //if the name reference is send from the login.jsp form as a null
                //then the following code will rerender until correctly filled in.
                try(PrintWriter out = response.getWriter()){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>login</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Hello Guest, " +
                            "gelieve een geldige naam in te voeren</h1>");
                    out.println("<h2>Give a name to Log in</h2>");
                    //the following form calls back this servlet until the above code returns
                    //true
                    out.println("<form method='post' action='testdrie'>");
                    out.println("name: <input type=\"text\" name=\"login\">\n" +
                            "<input type=\"submit\" value=\"Push here\">");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //this methode will check the input if it contains a string
    // value and return true if so.
    private static boolean isName(String str) {
        String expression = "^[a-zA-Z\\s]+";
        return str.matches(expression);
    }
}
