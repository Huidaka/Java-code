package Huidaka;

public class Testlambda {
    public static void main1(String[] args) {
        A a = () -> {
            System.out.println("hahaha");
        };
        a.func();
    }
}
