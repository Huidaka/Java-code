import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        resp.setContentType("text/html; charset=utf-8");
        int count = 0;
        String username = null;
        if(session.isNew()){
            count = 1;
            session.setAttribute("username","tz");
        }
        else{
            count = (int)session.getAttribute("count") + 1;
            username = session.getAttribute("username").toString();
        }
        session.setAttribute("count",count);
        resp.getWriter().write("<html>");
        resp.getWriter().write("username: " + username);
        resp.getWriter().write("<br/>");
        resp.getWriter().write("count: " + count);
        resp.getWriter().write("</html>");

    }
}
