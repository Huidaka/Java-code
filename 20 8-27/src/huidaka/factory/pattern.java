package huidaka.factory;

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
//工厂描述
abstract class Factory{
    abstract Drinks cerateDrinks();
}
//生产可乐的具体工厂
class CokeFactory extends Factory{
    @Override
    public Drinks cerateDrinks() {
        return new Coke();
    }
}
//生产咖啡的具体工厂
class CoffeeFactory extends Factory{
    @Override
    public Drinks cerateDrinks() {
        return new Coffee();
    }
}
//生产茶的具体工厂
class TeaFactory extends Factory{

    @Override
    public Drinks cerateDrinks() {
        return new Tea();
    }
}

class Test{
    public static void main(String[] args) {
        //创建制造可乐的工厂来生产可乐
        Factory factory = new CokeFactory();
        factory.cerateDrinks();
        //创建制造咖啡的工厂来生产咖啡
        Factory factory1 = new CoffeeFactory();
        factory1.cerateDrinks();
    }
}