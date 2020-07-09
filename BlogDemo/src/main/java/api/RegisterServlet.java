package api;

import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //获取用户输入的信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //判断用户输入信息是否合法
        //用户信息不合法返回错误界面
        if(username==null || username.equals("") || password==null || password.equals("")){
            String html = HtmlGenerator.getMessagePage("输入有误","register.html");
            resp.getWriter().write(html);
            return;
        }
        //生成用户实体信息
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao userDao = new UserDao();
        User retuser = userDao.selectUserName(username);
        if(retuser == null) {
            //用户信息合法将信息添加到数据库中
            //返回注册成功界面
            userDao.addUser(user);
            String html = HtmlGenerator.getMessagePage("注册成功，请点击跳转登录","login.html");
            resp.getWriter().write(html);
        }
        else {
            //查看用户是否存在存在就返回错误界面
            if (retuser.getUsername().equals(username)) {
                String html = HtmlGenerator.getMessagePage("用户已经存在，请重新填写", "register.html");
                resp.getWriter().write(html);
            }
        }
    }
}
