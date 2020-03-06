package user;

import operation.*;

import java.util.Scanner;

public class NomalUser extends User {
    @Override
    public int menu() {
        System.out.println("hello—" +
                ""+name+",欢迎使用图书管理系统");
        System.out.println("================================");
        System.out.println("=        1.查阅图书             =");
        System.out.println("=        2.借阅图书             =");
        System.out.println("=        3.归还图书             =");
        System.out.println("=        0.退出系统             =");
        System.out.println("================================");
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            if(n<=3 && n>=0){
                return n;
            }
            System.out.println("输入有误，请重新输入：");
        }
    }

    public NomalUser(String name) {
        super(name);
        this.iOperations = new IOperation[]{
                new EditOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }
}
