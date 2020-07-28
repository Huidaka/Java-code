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

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=urf-8");
        User user = new User();
        user.setName(req.getParameter("name"));
        UserServices userServices = new UserServices();
        Map<String,Boolean> map = new HashMap<>();
        User dbUser = userServices.findName(user.getName());
        if(dbUser == null){
            user.setGender(req.getParameter("gender"));
            user.setAge(Integer.parseInt(req.getParameter("age")));
            user.setAddress(req.getParameter("address"));
            user.setQq(req.getParameter("qq"));
            user.setEmail(req.getParameter("email"));
            int result = userServices.add(user);
            if(result == 1){
                map.put("msg",true);
                map.put("User",false);
            }
            else{
                map.put("msg",false);
                map.put("User",false);
            }
        }
        else {
            map.put("User",true);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),map);
    }
}
