package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entiy.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService userService = new UserService();    //调用service层的登录方法，判断是否登录成功
        User user = userService.login(username,password);
        Map<String,Boolean> returnMap = new HashMap<>(); //创建一个map集合，存放返回到客户端的数据
        if(user == null){
            System.out.println("登录失败");
            returnMap.put("msg",false);
        }
        else{
            System.out.println("登录成功");
            //登录成功返回一个session，用来保存用户的登录信息,验证用户是否进行了登录
            req.getSession().setAttribute("root","123456");
            returnMap.put("msg",true);
        }
        //利用Jackson将map转化为json对象
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),returnMap);
    }
}
