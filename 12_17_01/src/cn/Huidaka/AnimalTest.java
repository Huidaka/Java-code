package cn.Huidaka;

//测试多态的好处；

class AnimalTest {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(),new Cat(),new birdie()};
        for (Animal animal:animals) {
            animal.cry();
        }
    }
}