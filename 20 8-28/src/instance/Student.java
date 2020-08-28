package instance;

import java.util.Arrays;

public class Student implements Comparable<Student>{
    String name;
    int num;
    int age;

    public Student(String name, int num, int age) {
        this.name = name;
        this.num = num;
        this.age = age;
    }


    @Override
    public int compareTo(Student o) {
        return  o.age - this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("小李",001,18),
                new Student("小王",002,20),
                new Student("小明",003,16),
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

}
