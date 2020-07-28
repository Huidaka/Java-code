package services;

import dao.UserDao;
import entiy.PageBean;
import entiy.User;

import java.util.List;
import java.util.Map;

public class UserServices {

    public User login(String loginname, String loginpassword){
        UserDao userDao = new UserDao();
        User user = userDao.login(loginname,loginpassword);
        return user;
    }

    public int add(User user){
        UserDao userDao = new UserDao();
        int ret = userDao.add(user);
        return ret;
    }

    public int delete(int id) {
        UserDao userDao = new UserDao();
        int ret = userDao.delete(id);
        return ret;
    }

    public User find(int id) {
        UserDao userDao = new UserDao();
        User user = userDao.find(id);
        return user;
    }

    public User findName(String name){
        UserDao userDao = new UserDao();
        User user = userDao.findName(name);
        return user;
    }

    public  int updateUser(User upUser) {
        UserDao userDao = new UserDao();
        int ret = userDao.updateUser(upUser);
        return ret;
    }

    /**
     * @param currentPage 当前页
     * @param rows 每页的行数
     * @param map  包含 name address email  根据map当中的条件  进行查询
     * @return
     *
     * 确定
     *     private int totalCount;   //总记录数     12   findAllRecord  完成
     *     private int totalPage; //总页码          3      完成
     *     private List<T> list;  //每页中的数据 ---》  findByPage  完成
     *     private int currentPage;  //当前页码   已知的          完成
     *     private int rows;   //每页的记录数       5        完成
     *
     */
    public PageBean<User> findAllByPage(int currentPage, int rows, Map<String, String[]> map) {
        UserDao userDao = new UserDao();
        PageBean<User> pageBean = new PageBean<>();
        //设置总记录数
        int totalCount = userDao.findAllRecord(map);
        pageBean.setTotalCount(totalCount);
        //设置总页数
        int totalPage = 0;
        if(totalCount % rows == 0){
            totalPage = totalCount / rows;
        }
        else {
            totalPage = (totalCount / rows )+ 1;
        }
        pageBean.setTotalPage(totalPage);
        //设置每页中的数据
        int start = (currentPage-1)*rows;
        List<User> listUser = userDao.findByPage(start,rows,map);
        pageBean.setList(listUser);
        //设置当前页数
        pageBean.setCurrentPage(currentPage);
        //设置每页记录数
        pageBean.setRows(rows);
        return pageBean;
    }
}
