package BlogSystem;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import sun.plugin2.message.GetAppletMessage;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.*;

/**
 * 获取数据库连接和关闭数据库连接
 */
public class DBUtil {
    static String url = "jdbc:mysql://127.0.0.1:3306/blogdemo?useSSL=false";
    static String username = "root";
    static String password = "123456";

    private static DataSource DATASOURCE;
    private static DataSource getDataSource(){
        // 双重校验锁
        if(DATASOURCE == null){
            synchronized (DBUtil.class){
                if(DATASOURCE == null){
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource) DATASOURCE).setUrl(url);
                    ((MysqlDataSource) DATASOURCE).setUser(username);
                    ((MysqlDataSource) DATASOURCE).setPassword(password);
                }
            }
        }
        return DATASOURCE;
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return getDataSource().getConnection();
    }


    public static void close(ResultSet resultSet, PreparedStatement ps, Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps != null){
            try {
                ps.close();
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
