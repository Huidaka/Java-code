import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

public class CookieDemo2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html; charset=utf-8");
        resp.setStatus(200);
        resp.getWriter().write("<html>");
        for(Cookie cookie :  cookies){
            resp.getWriter().write("<div>");
            resp.getWriter().write(cookie.getName() + ": " + cookie.getValue());
            resp.getWriter().write("</div>");
        }
        resp.getWriter().write("</html>");
    }
}
