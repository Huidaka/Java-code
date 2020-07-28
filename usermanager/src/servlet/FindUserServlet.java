package servlet;

import entiy.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String idStr = req.getParameter("id");
        int id = Integer.parseInt(idStr);
        UserServices userServices = new UserServices();
        User user = userServices.find(id);
        if(user == null){
            System.out.println("未找到用户");
        }
        else{
            req.getSession().setAttribute("User",user);
            resp.sendRedirect("update.html");
        }
    }
}
