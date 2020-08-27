package huidaka.abstracts;
//抽象食物类
abstract class Food{
    String type;
}
//抽象面包类
abstract class Bread extends Food{
    String name;
    public Bread() {
        this.type = "面包";
    }
}
//抽象饮料类
abstract class Drinks extends Food{
    String name;
    public Drinks() {
        this.type = "饮料";
    }
}
//具体饮料可乐
class Coke extends Drinks {
    public Coke() {
        name = "可乐";
    }
}
//具体饮料咖啡
class Coffee extends Drinks {
    public Coffee() {
        name = "咖啡";
    }
}
//具体面包加糖面包
class SugarBread extends Bread {
    public SugarBread() {
        this.name = "加糖面包";
    }
}
//具体面包全麦面包
class GrahamBread extends Drinks {
    public GrahamBread() {
        this.name = "全麦面包";
    }
}

//抽象工厂类接口
interface Fatory{
    public Food createDrinks();
    public Food createBread();
}
//具体工厂A
class FactoryA implements Fatory{
    @Override
    public Drinks createDrinks() {
        return new Coke();
    }

    @Override
    public Bread createBread() {
        return new SugarBread();
    }
}
public class Test{
    public static void main(String[] args) {
        FactoryA fatoryA = new FactoryA();
        Bread bread = (Bread) fatoryA.createBread();
        System.out.println(bread.type + " " + bread.name);
        Drinks drinks = (Drinks) fatoryA.createDrinks();
        System.out.println(drinks.type + " " + drinks.name);
    }
}