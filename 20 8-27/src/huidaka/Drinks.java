package huidaka;
//描述产品
abstract class Drinks {
    String name = null;
}
//具体产品
class Coke extends Drinks {
    public Coke() {
        name = "可乐";
    }
}
//具体产品
class Coffee extends Drinks {
    public Coffee() {
        name = "咖啡";
    }
}
//具体产品
class Tea extends Drinks {
    public Tea() {
        name = "茶";
    }
}
//生产产品的工厂
class Factory{
    public static Drinks cerateDuicks(String drinks){
        switch (drinks){
            case "A": return new Coke();
            case "B": return new Coffee();
            case "C": return new Tea();
        }
        return null;
    }
}
//测试
class Test{
    public static void main(String[] args) {
        Drinks drinks = Factory.cerateDuicks("A");
        System.out.println(drinks.name);
        Drinks drinks1 = Factory.cerateDuicks("C");
        System.out.println(drinks1.name);
    }
}