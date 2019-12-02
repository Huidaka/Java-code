package cn.Huidaka;

interface Cry {
    void cry();
    public static void main(String[] args) {
        //Cry c = new Dog();
    }
}
class Dog implements Cry {
    private Dog(){

    }
    public void cry(){
        System.out.println("wangwangwang");
    }
}
class Cat{
    public void cry(){
        System.out.println("miaomiaomiao");
    }
}
