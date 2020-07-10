package model;

import sun.security.pkcs11.Secmod;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public void addUser(User user){
        Connection connection = DButil.getConnection();
        String sql = "insert into user(username,password) values(?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            int ret = statement.executeUpdate();
            if(ret != 1){
                throw new SQLException("用户插入信息失败");
            }
            System.out.println("用户插入信息成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,null);
        }
    }

    public User selectUserName(String username){
        Connection connection = DButil.getConnection();
        String sql = "select * from user where username = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,resultSet);
        }
        return null;
    }

    public User selectById(int id){
        Connection connection = DButil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = String.format("select * from user where userid = ?");
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.setUserId(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            DButil.close(connection,statement,resultSet);
        }
        return null;
    }

    public static void main(String[] args) {
//        User user = new User();
//        user.setUsername("郭奥辉");
//        user.setPassword("123456");
        UserDao userDao = new UserDao();
//        userDao.addUser(user);
        User user1 = userDao.selectUserName("郭奥辉");
        System.out.println(user1);
    }
}
