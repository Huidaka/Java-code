package BlogSystem;

import java.util.Scanner;

public class Menu {
    public static int menu1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== 欢迎使用Huidaka博客系统 =====");
        System.out.println("=============1.登录=============");
        System.out.println("=============2.注册=============");
        System.out.println("=============0.退出=============");
        int n = scanner.nextInt();
        return n;
    }
    public static int menu2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("================================================");
        System.out.println("=========== 1.发表文章                    =======");
        System.out.println("=========== 2.评论文章                    =======");
        System.out.println("=========== 3.点赞文章                    =======");
        System.out.println("=========== 4.查询你发表过的文章(详情页)     =======");
        System.out.println("=========== 5.查询你点赞过的文章            =======");
        System.out.println("=========== 6.查询所有用户发表过的文章(列表页)=======");
        System.out.println("=========== 0.退出系统                    =======");
        System.out.println("================================================");
        int n = scanner.nextInt();
        return n;
    }
}
