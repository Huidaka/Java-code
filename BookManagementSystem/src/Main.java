import book.BookList;
import user.AdminUser;
import user.NomalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //准备数据
        BookList bookList = new BookList();
        //登录
        User user = login();
        while(true) {
            //打印菜单
            int n = user.menu();
            //选择功能
            user.doOperation(n, bookList);
            if(n == 0) return;
            System.out.println("返回上一步请输入：1 ，退出系统请输入：0");
            n = scanner.nextInt();
            if(n == 0){
                return;
            }
        }
    }

    /**
     * 确认登陆身份
     * @return
     */
    private static User login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你的名字");
        String name = scanner.nextLine();
        System.out.println("请选择你的身份：——> 0:普通用户  1:管理员");
        while(true){
            int i = scanner.nextInt();
            if(i == 0){
                return new NomalUser(name);
            }
            if(i == 1){
                return new AdminUser(name);
            }
            System.out.println("输入错误，请重新选择 ——> 0:普通用户  1:管理员\"");
        }
    }

}