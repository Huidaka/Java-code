import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ShowRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> heads = req.getHeaderNames();
        StringBuilder ret = new StringBuilder("");
        while (heads.hasMoreElements()){
            String name = heads.nextElement();
            ret.append(name + ": " + req.getHeader(name) + "<br/>");
        }
        resp.getWriter().write("<html>" + ret.toString() + "</html>");
    }
}
