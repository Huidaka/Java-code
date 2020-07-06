import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        resp.setContentType("text/html; charset=utf-8");
        resp.addCookie(new Cookie("firstnaem", firstname));
        resp.addCookie(new Cookie("lastnaem", lastname));
        resp.getWriter().write("<html>");
        resp.getWriter().write("数据提交成功");
        resp.getWriter().write("</html>");
    }
}
