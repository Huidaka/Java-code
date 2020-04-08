package Huidaka;

import java.util.Comparator;

/**
 * comparator和comparable的区别，comparator可以根据需要建立比较条件，
 * 而comparable会一下子在类里面把比较条件写死，一般情况下用comparator比较器的比较多
 */
class Student implements Comparable<Student>{
    int age;
    int arage;

    public Student(int age, int arage) {
        this.age = age;
        this.arage = arage;
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
class ArageComparator implements Comparator<Student>{

    @Override
    public int compare(Student t1, Student t2) {
        return t1.arage - t2.arage;
    }
}
public class ConparableAndConpartor {
    public static void main(String[] args) {
        ArageComparator arageComparator = new ArageComparator();
        Student s1 = new Student(20,100);
        Student s2 = new Student(21,100);
        System.out.println(s1.compareTo(s2));
        System.out.println(arageComparator.compare(s1,s2));
    }
}
