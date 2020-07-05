import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        resp.setContentType("text/html; charset=utf-8");
        if(a==null || b==null || a.isEmpty() || b.isEmpty()){
            resp.getWriter().write("<html>参数错误</html>");
        }
        else{
            int ret = Integer.parseInt(a) + Integer.parseInt(b);
            String rets = String.format("<html>a+b = %d</html>",ret);
            resp.getWriter().write(rets);
        }
    }
}
