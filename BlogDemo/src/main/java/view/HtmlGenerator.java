package view;

import model.Article;
import model.User;
import model.UserDao;

import java.util.List;

public class HtmlGenerator {

    public static String getMessagePage(String message, String url){
        StringBuilder ret = new StringBuilder("");
        ret.append("<html>");
        ret.append("<head>");
        ret.append("<meta charset=\"UTF-8\">");
        ret.append("<title>提示界面</title>");
        ret.append("</head>");
        ret.append("<body>");
        ret.append("<h3>"+message+"</h3>");
        ret.append(String.format("<a href = \"%s\"> 请点击跳转 </a>",url));
        ret.append("</body>");
        ret.append("</html>");
        return ret.toString();
    }

    public static String getArticleListPage(User user, List<Article> list){
        StringBuilder ret = new StringBuilder("");
        ret.append("<html>");
        ret.append("<head>");
        ret.append("<meta charset=\"UTF-8\">");
        ret.append("<title>博客列表</title>");
        ret.append("</head>");
        ret.append("<body>");
        ret.append("<h3>欢迎您！"+user.getUsername()+"</h3>");
        for (Article articles : list) {
            ret.append(String.format("<div><a href=\"article?articleid=%d\"> %s </a>"+
                    "<a href=\"article?articleid=%d&delete=1\">删除</a></div>"
                    ,articles.getArticleid(),articles.getTitle(),articles.getArticleid()));
        }

        ret.append("<br>");
        ret.append("<hr>"); // hr 是一个分割线
        ret.append("<br>");
        ret.append("<div> 发布文章 </div>");
        ret.append("<form method=\"post\" action=\"article\">");
        ret.append("<div><input type=\"text\" style=\"width: 50%\" name=\"title\" placeholder=\"请输入标题\"></div>");
        ret.append("<div><textarea name=\"content\" style=\"width: 50%; height: 500px\"></textarea></div>");
        ret.append("<div><input type=\"submit\" style=\"width: 100px; height: 50px\" value=\"发布文章\"></div>");
        ret.append("</form>");
        ret.append("</body>");
        ret.append("</html>");
        return ret.toString();
    }

    public static String getArticleDetailPage(User user, User author,Article article){
        StringBuilder ret = new StringBuilder("");
        ret.append("<html>");
        ret.append("<head>");
        ret.append("<meta charset=\"UTF-8\">");
        ret.append("<title>博客详情页</title>");
        ret.append("</head>");
        ret.append("<body>");
        ret.append("<h3>欢迎您！"+user.getUsername()+"</h3>");
        ret.append("<h3>文章标题："+article.getTitle()+"</h3>");
        ret.append("<h5>作者："+author.getUsername()+"</h5>");
        ret.append("<h4>正文："+article.getContent().replaceAll("\n","<br/>")+"</h3>");
        ret.append("</body>");
        ret.append("</html>");
        return ret.toString();
    }
}
