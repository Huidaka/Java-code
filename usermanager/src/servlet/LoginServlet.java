package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entiy.User;
import services.UserServices;

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
        UserServices userServices = new UserServices();
        User user = userServices.login(username,password);
        Map<String,Boolean> returnMap = new HashMap();
        if(user == null){
            System.out.println("登录失败");
            returnMap.put("msg",false);
        }
        else{
            System.out.println("登陆成功");
            req.getSession().setAttribute("root","123456");
            returnMap.put("msg",true);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),returnMap);
    }
}
