package cn.huidaka;

public class Person implements Cloneable,Comparable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        if (this.age > p.age) {
            return 1;
        } else if (this.age < p.age) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}


