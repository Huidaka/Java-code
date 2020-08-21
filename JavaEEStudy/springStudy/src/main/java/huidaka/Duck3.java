package huidaka;

public class Duck3 {
    private String name;
    private int age;
    private Duck3 next;

    public Duck3(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Duck3 getNext() {
        return next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNext(Duck3 next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Duck3{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", next=" + next +
                '}';
    }
}
