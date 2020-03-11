package Huidaka;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 把student对象放进List中，并打印出他的属性
 */
class Student{
    String name;
    String calsse;
    double age;

    public Student(String name, String banji, double age) {
        this.name = name;
        this.calsse = banji;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", calsse='" + calsse + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestList {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", "java30班",30));
        students.add(new Student("李四", "java32班",65));
        students.add(new Student("王五", "java35班",40));
        System.out.println(students);
    }

}
