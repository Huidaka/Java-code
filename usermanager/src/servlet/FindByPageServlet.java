package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import entiy.PageBean;
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

@WebServlet("/findByPageServlet")
public class FindByPageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,String[]> map = req.getParameterMap();
        Map<String,String[]> stringMap = new HashMap<>(map);
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows");
        stringMap.remove("currentPage");
        stringMap.remove("rows");
        UserServices userServices = new UserServices();
        PageBean<User> pageBean = userServices.findAllByPage(Integer.parseInt(currentPage),Integer.parseInt(rows),stringMap);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(resp.getWriter(),pageBean);
    }
}
