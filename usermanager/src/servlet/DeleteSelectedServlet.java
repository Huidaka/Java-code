package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/deleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String[] strs = req.getParameterValues("id[]");
        int sum = 0;
        for(String s : strs){
            int id = Integer.parseInt(s);
            UserServices userServices = new UserServices();
            sum += userServices.delete(id);
        }
        Map<String,Boolean> map = new HashMap<>();
        if(sum == strs.length){
            map.put("msg",true);
        }
        else{
            map.put("msg",false);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),map);
    }
}
