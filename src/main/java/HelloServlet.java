import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HelloServlet")
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookiePromo = new Cookie("promo", "$100");
        cookiePromo.setMaxAge(30*24*3600);
        response.addCookie(cookiePromo);

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String check = request.getParameter("check");
        boolean userFound = (new UserData()).findUser(name, password);
        if(userFound){
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            session.setAttribute("password", password);

            if(check!=null){
                session.setAttribute("value", "yes");
                Cookie cookie = new Cookie("username", name);
                cookie.setMaxAge(24*30*3600);
                response.addCookie(cookie);

            }
            else{
                session.setAttribute("value", "no");
            }
            response.sendRedirect("logged.jsp");
        }
        else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("value").equals("no")) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (cookie.getValue().equals(session.getAttribute("username"))) {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                        break;
                    }
                }
            }
        }
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
