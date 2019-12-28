package cn.huidaka;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("zhang",18);
        Person person1 = new Person("li",20);
        Person person2 = new Person ("wang",5);
        Person[] persons = new Person[]{person,person1,person2};
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));
        Person person3 = null;
        try {
            person3 = person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person == person3);
    }
}
