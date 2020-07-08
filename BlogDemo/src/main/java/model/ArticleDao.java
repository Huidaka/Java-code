package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    public void addArticle(Article article){
        Connection connection = DButil.getConnection();
        String sql = "insert into article(title,content,userid) values(?,?,?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,article.getTitle());
            statement.setString(2,article.getContent());
            statement.setInt(3,article.getUserId());
            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new SQLException("插入失败");
            }
            System.out.println("插入成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,resultSet);
        }
    }
    public Article selectById(int articleid){
        Connection connection = DButil.getConnection();
        String sql = "select * from article where articleid = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleid);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Article article = new Article();
                article.setArticleid(resultSet.getInt(1));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt(4));
                return article;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,resultSet);
        }
        return null;
    }

    public List<Article> selectAllArticle(){
        Connection connection = DButil.getConnection();
        String sql = "select * from article";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Article> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Article article = new Article();
                article.setArticleid(resultSet.getInt(1));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(resultSet.getInt(4));
                list.add(article);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection, statement, resultSet);
        }
        return null;
    }

    public void delete(int articleid){
        Connection connection = DButil.getConnection();
        String sql = "delete from article where articleid = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,articleid);
            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new SQLException("删除失败");
            }
            System.out.println("删除成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,resultSet);
        }
    }

    public static void main(String[] args) {
//        Article article1 = new Article();
//        article1.setTitle("哈哈哈");
//        article1.setContent("呼呼呼呼哈哈哈哈呼呼呼呼哈哈哈哈呼呼呼呼哈哈哈哈");
//        article1.setUserId(1);
//        Article article2 = new Article();
//        article2.setTitle("啊啊啊");
//        article2.setContent("2222222222222222222222222222222222222222");
//        article2.setUserId(1);
        ArticleDao articleDao = new ArticleDao();
//        articleDao.addArticle(article1);
//        articleDao.addArticle(article2);
        Article article = articleDao.selectById(2);
        System.out.println(article);
        List<Article> list = articleDao.selectAllArticle();
        for (Article article3 : list){
            System.out.println(article3);
        }
    }
}
