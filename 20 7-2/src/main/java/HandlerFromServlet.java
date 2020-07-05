import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HandlerFromServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        resp.setContentType("text/html; charset=utf-8");
        if(userName.equals("郭奥辉") && passWord.equals("123456") ){
            resp.getWriter().write("<html>登录成功" + "<br/>" + userName + "<br/>" + passWord + "</html>");
        }
        else{
            resp.getWriter().write("<html>账号或密码错误</html>");
        }
    }
}
