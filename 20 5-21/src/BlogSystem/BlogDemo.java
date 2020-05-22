package BlogSystem;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BlogDemo {
    private static User user = null;
    // 登录
    public boolean login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username1 = scanner.nextLine();
        System.out.println("请输入密码：");
        String password1 = scanner.nextLine();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select * from user where username = ? and password = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,username1);
            ps.setString(2,password1);
            resultSet = ps.executeQuery();
            if(resultSet.next() ){
                user = new User();
                user.setId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                System.out.println("登陆成功");
                System.out.println(user);
            }
            else{
                System.out.println("用户名或密码错误");
                return false;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            System.out.println("登陆失败");
        } finally {
            DBUtil.close(resultSet,ps,connection);
        }
        return true;
    }
    // 注册
    public void register()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into user(username,password) values(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            System.out.println(sql);
            ps.executeUpdate();
            System.out.println("注册成功");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
            System.out.println("注册失败");
        } finally {
            DBUtil.close(resultSet,ps,connection);
        }
        return;
    }
    // 发表文章
    public void publishedArticles(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文章标题：");
        String title = scanner.nextLine();
        System.out.println("请输入文章内容：");
        String content = scanner.nextLine();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pulished = simpleDateFormat.format(date);
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into article(author_id,title,content,pulished_at) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setString(4,pulished);
            ps.executeUpdate();
            System.out.println("发表成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("发表失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("发表失败");
        }
        finally {
            DBUtil.close(resultSet,ps,connection);
        }
    }
    // 评论文章
    public void contentArticles(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要评论文章id：");
        int article_id = scanner.nextInt();
        System.out.println("请输入评论内容：");
        String content = scanner.nextLine();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pulished = simpleDateFormat.format(date);
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into comments(author_id,content,article_id,pulished_at) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setString(2,content);
            ps.setInt(3,article_id);
            ps.setString(4,pulished);
            ps.executeUpdate();
            System.out.println("发表成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("发表失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("发表失败");
        }
        finally {
            DBUtil.close(resultSet,ps,connection);
        }
    }
    // 点赞文章
    public void likesArticles(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要点赞文章id：");
        int article_id = scanner.nextInt();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into likes(user_id,article_id) values(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ps.setInt(2,article_id);
            ps.executeUpdate();
            System.out.println("点赞成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("点赞失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("点赞失败");
        }
        finally {
            DBUtil.close(resultSet,ps,connection);
        }
    }
    // 查询你发表过的文章(详情页)
    public void selectArticles(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select article.* from article join likes on article.id = likes.article_id where user.id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println("文章id："+id);
                int author = resultSet.getInt(2);
                System.out.println("作者id："+author);
                String title = resultSet.getString(3);
                System.out.println("文章标题："+title);
                String content = resultSet.getString(4);
                System.out.println("文章内容："+content);
                String date = resultSet.getString(5);
                System.out.println("文章发表时间"+date);
                System.out.println("**********************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    // 查询你点赞过的文章
    public void selectLikes(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select article.* from likes join article on likes.article_id = article.id and likes.user_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,user.getId());
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println("文章id："+id);
                int author = resultSet.getInt(2);
                System.out.println("作者id："+author);
                String title = resultSet.getString(3);
                System.out.println("文章标题："+title);
                String content = resultSet.getString(4);
                System.out.println("文章内容："+content);
                String date = resultSet.getString(5);
                System.out.println("文章发表时间"+date);
                System.out.println("**********************************");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //8. 查询所有用户发表过的文章(列表页)
    public void allArticle(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "select article.* from user join article on user.id = author_id";
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println("文章id："+id);
                int author = resultSet.getInt(2);
                System.out.println("作者id："+author);
                String title = resultSet.getString(3);
                System.out.println("文章标题："+title);
                String content = resultSet.getString(4);
                System.out.println("文章内容："+content);
                String date = resultSet.getString(5);
                System.out.println("文章发表时间"+date);
                System.out.println("**********************************");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
