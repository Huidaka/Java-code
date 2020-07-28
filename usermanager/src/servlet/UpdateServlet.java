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

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        User user = (User)req.getSession().getAttribute("User");
        user.setName(req.getParameter("name"));
        user.setGender(req.getParameter("gender"));
        user.setAge(Integer.parseInt(req.getParameter("age")));
        user.setAddress(req.getParameter("address"));
        user.setQq(req.getParameter("qq"));
        user.setEmail(req.getParameter("email"));
        UserServices userServices = new UserServices();
        int result = userServices.updateUser(user);
        Map<String,Boolean> map = new HashMap<>();
        if(result == 1){
            map.put("msg",true);
        }
        else{
            map.put("msg",false);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),map);
    }
}
