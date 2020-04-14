package Reflect;

class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}
class Student extends Person{
    public String name;
    public int age;
    private int grade;

    public Student(){
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Student(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public void eat(){
        System.out.println("吃饭");
    }

    private void func(String s){
        System.out.println("成绩");
    }
}

public class TestReflect {
    public static void main(String[] args) {
        Student student = new Student();
        Class<?> studentClass1 = student.getClass();
        Class<?> studentClass2 = Student.class;
        Class<?> studentClass3 = null;
        try {
            studentClass3 = Class.forName("Reflect.Student");//有包需要加包的路径
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(studentClass1.equals(studentClass2));
        System.out.println(studentClass1.equals(studentClass3));
        System.out.println(studentClass2.equals(studentClass3));
    }
}
