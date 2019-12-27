package cn.huidaka;

import java.util.Scanner;

public class Coffee extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("加入咖啡豆");
    }

    @Override
    public void addCondiments() {
        System.out.println("加糖或者牛奶");
    }

    public boolean isCustomerWantsCondiments() {
        Scanner s = new Scanner(System.in);
        String c = s.next();
        while (c.equals("y") && c.equals("n")){
            System.out.println("输入有误");
            c = s.next();
        }
        if(c.equals("y")){
            return true;
        }
        else {
            return false;
        }
    }
}
