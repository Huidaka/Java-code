package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //判断用户输入是否合法
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username==null || username.equals("") || password==null || password.equals("")){
            String html = HtmlGenerator.getMessagePage("输入有误，请重新输入","login.html");
            resp.getWriter().write(html);
        }
        else {
            //判断用户输入信息账号密码是否匹配
            //如果用户账号密码不匹配返回错误界面
            UserDao userDao = new UserDao();
            User user = userDao.selectUserName(username);
            if (user == null || !user.getPassword().equals(password)) {
                String html = HtmlGenerator.getMessagePage("账号或密码输入有误", "login.html");
                resp.getWriter().write(html);
            }
            else{
                //用户账号密码输入正确，返回正确界面，并返回session
                HttpSession session = req.getSession(true);
                session.setAttribute("User",user);
                String html = HtmlGenerator.getMessagePage("登录成功", "article");
                resp.getWriter().write(html);
            }
        }
    }
}
