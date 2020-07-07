import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
@MultipartConfig
public class UploadDemoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part image = req.getPart("myfile");
        File path = new File("E:\\tomcat\\apache-tomcat-9.0.35\\images\\"+image.getSubmittedFileName());
        image.write(path.toString());
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<html>");
        resp.getWriter().write("上传成功");
        resp.getWriter().write("</html>");
    }
}
