package user;

import operation.*;

import java.util.Random;
import java.util.Scanner;

public class AdminUser extends User {
    @Override
    public int menu() {
        System.out.println("hello—"+name+",欢迎使用图书管理系统");
        System.out.println("================================");
        System.out.println("=        1.查阅图书             =");
        System.out.println("=        2.新增图书             =");
        System.out.println("=        3.删除图书             =");
        System.out.println("=        4.显示所有图书         =");
        System.out.println("=        0.退出系统             =");
        System.out.println("================================");
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            if(n<=4 && n>=0){
                return n;
            }
            System.out.println("输入有误，请重新输入：");
        }
    }

    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new EditOperation(),
                new FindOperation(),
                new AddOperation(),
                new DeleteOperation(),
                new DisplayOperation()
        };
    }
}
