package cn.huidaka;

public class Tea extends CaffeineBeverage{
    @Override
    public void brew() {
        System.out.println("泡茶包");
    }

    @Override
    public void addCondiments() {
        System.out.println("加枸杞");
    }
}
