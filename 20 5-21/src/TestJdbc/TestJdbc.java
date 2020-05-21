package TestJdbc;
import com.mysql.jdbc.Driver;

import java.sql.*;

public class TestJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //获取驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/students?useSSL=false";
        String username = "root";
        String password = "123456";

        //获取连接
        Connection connection = DriverManager.getConnection(url,username,password);

        //获取语句
        Statement statement = connection.createStatement();
        String sql = "select id,name from student";

        //执行语句
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.print(id);
            System.out.println(name);
        }

        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
