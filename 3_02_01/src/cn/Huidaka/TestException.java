package cn.Huidaka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestException {
    public static void main1(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            arr = null;
            arr[100] = 10;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException a) {  //多个catch可以简写
            a.printStackTrace();
        }
        System.out.println("hahaha");
    }

    public static void main2(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {  //scanner写在try里面，会自动调用scanner.close方法
            int a = scanner.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {                                 //finally里面的语句总是被执行，可以用来回收资源
            System.out.println("哈哈哈");
        }
    }

    //ﬁnally 执行的时机是在方法返回之前(try 或者 catch 中如果有 return 会在这个 return 之前执行 ﬁnally).
    // 但是如果 ﬁnally 中也存在 return 语句, 那么就会执行 ﬁnally 中的 return, 从而不会执行到 try 中原有的 return
    // 一般我们不建议在 ﬁnally 中写 return (被编译器当做一个警告).
    public static void main3(String[] args) {
        System.out.println(func());
    }

    public static int func() {
        try {
            return 10;
        }
        finally {
            return 20;
        }
    }
    //在方法上加上异常说明, 相当于将处理动作交给上级调用者
    public static void main(String[] args) {
        try {
            System.out.println(readFile());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String readFile() throws FileNotFoundException {
        File file = new File("d:/test.txt");
        Scanner sc = new Scanner(file);
        return sc.nextLine();
    }
}
