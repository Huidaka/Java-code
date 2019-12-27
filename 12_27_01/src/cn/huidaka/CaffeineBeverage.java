package cn.huidaka;

public abstract class CaffeineBeverage{
    public final void  prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(isCustomerWantsCondiments()){
            addCondiments();
        }
    }

    public void boilWater(){
        System.out.println("将水烧开");
    }

    public abstract void brew();

    public void pourInCup(){
        System.out.println("将饮料倒入杯中");
    }

    public abstract void addCondiments();

    public  boolean isCustomerWantsCondiments() {
        return true;
    }
}
