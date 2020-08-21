package huidaka;

public class Duck2 {
    public String name;
    public int age;

    public Duck2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Duck2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
