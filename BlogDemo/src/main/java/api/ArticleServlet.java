package api;

import model.Article;
import model.ArticleDao;
import model.User;
import model.UserDao;
import view.HtmlGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf8");
        //判断当前用户是否登录
        HttpSession session = req.getSession(false);
        //未登录即返回错误界面
        if(session == null){
            String html = HtmlGenerator.getMessagePage("未登录，请登陆后使用","login.html");
            resp.getWriter().write(html);
        }
        else{
            String articleid = req.getParameter("articleid");
            User user = (User)session.getAttribute("User");
            String delete = req.getParameter("delete");
            if(delete!=null && delete.equals("1")){
                deleteArticle(articleid,user,resp);
            }
            else if(articleid==null || articleid.equals("")){
                getAllArticle(user,resp);
            }
            else{
                getOneArticle(Integer.parseInt(articleid),user,resp);
            }
        }
    }

    public static void getAllArticle(User user,HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        List<Article> list = articleDao.selectAllArticle();
        String html = HtmlGenerator.getArticleListPage(user,list);
        resp.getWriter().write(html);
    }

    public static void getOneArticle(int id, User user,HttpServletResponse resp) throws IOException {
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(id);
        UserDao userDao = new UserDao();
        User author = userDao.selectById(article.getUserId());
        String html = HtmlGenerator.getArticleDetailPage(user,author,article);
        resp.getWriter().write(html);
    }

    public static void deleteArticle(String articleId, User user, HttpServletResponse resp) throws IOException {
        //判断参数是否合法
        if (articleId == null) {
            // 参数不完整, 返回一个提示页面.
            String html = HtmlGenerator.getMessagePage("文章 id 非法.", "article");
            resp.getWriter().write(html);
            return;
        }
        int id = Integer.parseInt(articleId);
        // 从数据库中查找文章信息.
        ArticleDao articleDao = new ArticleDao();
        Article article = articleDao.selectById(id);
        if (article == null) {
            // 参数不完整, 返回一个提示页面.
            String html = HtmlGenerator.getMessagePage("要删除的文章不存在",
                    "article");
            resp.getWriter().write(html);
            return;
        }
        //判断用户是否是该文章的作者
        //用户是文章作者执行删除操作
        if(article.getUserId() == user.getUserId()){
            articleDao.delete(id);
            String html = HtmlGenerator.getMessagePage("删除成功",
                    "article");
            resp.getWriter().write(html);
        }
        else {
            //不是文章作者返回错误信息
            String html = HtmlGenerator.getMessagePage("对不起，您不是文章作者无权删除",
                    "article");
            resp.getWriter().write(html);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf8");
        //判断当前用户是否登录
        HttpSession session = req.getSession(false);
        //未登录即返回错误界面
        if(session == null){
            String html = HtmlGenerator.getMessagePage("未登录，请登陆后使用","login.html");
            resp.getWriter().write(html);
        }
        else {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            if(title==null||title.equals("")||content==null||content.equals("")){
                String html = HtmlGenerator.getMessagePage("输入有误，请重新输入","article");
                resp.getWriter().write(html);
            }
            else{
                User user = (User) session.getAttribute("User");
                Article article = new Article();
                article.setTitle(title);
                article.setContent(content);
                article.setUserId(user.getUserId());
                ArticleDao articleDao = new ArticleDao();
                articleDao.addArticle(article);
                String html = HtmlGenerator.getMessagePage("发布成功","article");
                resp.getWriter().write(html);
            }
        }
    }
}
