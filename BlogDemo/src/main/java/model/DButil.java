package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;

public class DButil {
    private static DataSource dataSource = null;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/blogdemo2?characterEncoding=utf-8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    public static DataSource getDataSource() {
        if(dataSource == null){
            synchronized (DButil.class){
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL(URL);
                    ((MysqlDataSource)dataSource).setUser(USERNAME);
                    ((MysqlDataSource)dataSource).setPassword(PASSWORD);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close ();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
