package dao;

import entiy.User;
import util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDao {
    //验证用户登录
    public User login(String loginname, String loginpassword){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "select * from usermessage where username = ? and password = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,loginname);
            statement.setString(2,loginpassword);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return resultCreateUser(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //添加用户
    public int add(User user){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "insert into usermessage(name,username,password,gender,age,address,qq,email) value(" +
                    "?,?,?,?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getName());
            statement.setString(2,user.getUsername());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getGender());
            statement.setInt(5,user.getAge());
            statement.setString(6,user.getAddress());
            statement.setString(7,user.getQq());
            statement.setString(8,user.getEmail());
            int ret = statement.executeUpdate();
            return ret;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    //根据id删除用户
    public int delete(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "delete from usermessage where id = ?";;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int ret = statement.executeUpdate();
            return ret;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    //根据id查找用户
    public User find(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "select * from usermessage where id = ?";;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet= statement.executeQuery();
            if(resultSet.next()){
                return resultCreateUser(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //根据name查找用户
    public User findName(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "select * from usermessage where name = ?";;
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            resultSet= statement.executeQuery();
            if(resultSet.next()){
                return resultCreateUser(resultSet);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    //更新用户信息
    public int updateUser(User upUser){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DButil.getConnection();
            String sql = "update usermessage set gender=? ,age=? ,address=?, qq=?, email=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,upUser.getGender());
            statement.setInt(2,upUser.getAge());
            statement.setString(3,upUser.getAddress());
            statement.setString(4, upUser.getQq());
            statement.setString(5, upUser.getEmail());
            statement.setInt(6,upUser.getId());
            int ret = statement.executeUpdate();
            return ret;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 查询当前条件下的所有的用户信息。
     * 当然这个条件随机：组合，或者不给条件
     * @param start 开始查询的起始位置
     * @param rows  每次查询多少条记录
     * @param map  name,address,email
     *             Map<String, String[]> map
     *             map{name:"gaobo",address:"陕西",email:"123...."}
     *             这里我们在后续说。
     *             String[]实际上，只放了一个元素。
     * @return
     */
    public List<User> findByPage(int start, int rows, Map<String,String[]> map){
        List<User> userList = new ArrayList<>();
        String sql = "select * from usermessage where 1=1"; // 模糊查询 and name like ？
        Set<String> set = map.keySet();
        StringBuffer sb = new StringBuffer(sql);
        List<Object> list = new ArrayList<>();
        for(String str : set){
            String value = map.get(str)[0];
            if(value!=null && !value.equals("")){
                sb.append(" and ").append(str).append(" like ?"); //拼接sql模糊查询语句
                list.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,?");
        list.add(start);
        list.add(rows);

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        connection = DButil.getConnection();
        try {
            statement = connection.prepareStatement(sb.toString());
            //给sql语句赋值
            for(int i=0; i<list.size(); i++){
                statement.setObject(i+1,list.get(i));
            }
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                //根据返回结果集创建用户
                userList.add(resultCreateUser(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return userList;
    }
    //查询共有多少条记录
    public  int findAllRecord(Map<String, String[]> map) {
        int count = 0;
        String sql = "select count(*) from usermessage where 1=1"; // 模糊查询 and name like ？
        Set<String> set = map.keySet();
        StringBuffer sb = new StringBuffer(sql);
        List<Object> list = new ArrayList<>();
        for(String str : set){
            String value = map.get(str)[0];
            if(value!=null && !value.equals("")){
                sb.append(" and ").append(str).append(" like ?"); //拼接sql模糊查询语句
                list.add("%"+value+"%");
            }
        }
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        connection = DButil.getConnection();
        try {
            statement = connection.prepareStatement(sb.toString());
            //给sql语句赋值
            for(int i=0; i<list.size(); i++){
                statement.setObject(i+1,list.get(i));
            }
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                count = resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally{
            try {
                DButil.close(connection,statement,resultSet);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return count;
    }

    //根据返回的结果集创建用户user
    private User resultCreateUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(1));
        user.setName(resultSet.getString(2));
        user.setUsername(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setGender(resultSet.getString(5));
        user.setAge(resultSet.getInt(6));
        user.setAddress(resultSet.getString(7));
        user.setQq(resultSet.getString(8));
        user.setEmail(resultSet.getString(9));
        return user;
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
//        User user = userDao.login("zhangfei","123");
//        if(user != null){
//            System.out.println("登录成功");
//            System.out.println(user.getName());
//            System.out.println(user.getAge());
//        }
//        else{
//            System.out.println("登录失败");
//        }
//        if(UserDao.add(user) == 1){
//            System.out.println("添加成功");
//        }
//        else{
//            System.out.println("添加失败，用户名重复");
//        }
//        UserDao.delete(13);
//        User  user1 = UserDao.find(7);
//        System.out.println(user1);
//        HashMap<String,String[]> map = new HashMap<>();
//        String[] names = {"张"};
//        map.put("name",names);
//        List<User> list = UserDao.findByPage(0,5,map);
//        for(User user2 : list){
//            System.out.println(user2);
//        }
//    }
//        User user = UserDao.find(9);
//        user.setAge(100);
//        System.out.println(user);
//        UserDao.updateUser(user);
//        Map<String,String[]> map = new HashMap<>();
//        String[] names = {"张"};
//        map.put("name",names);
//        int count = UserDao.findAllRecord(map);
//        System.out.println(count);
    }
}
