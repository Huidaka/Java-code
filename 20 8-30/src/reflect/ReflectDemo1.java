package reflect;

class Student{
    public String name;
    private int age;

    public Student() {
        System.out.println("Student");
    }

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private void func(){
        System.out.println("haahah");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class ReflectDemo1 {
    public static void main(String[] args) {
        //1.通过对象的getClass方法获取
        Student student = new Student();
        Class c1 = student.getClass();
        //2.通过类对象的forName方法获取用的最多，
        //但可能抛出 ClassNotFoundException 异常
        Class c2 = null;
        try {
            c2 = Class.forName("reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //3.直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        //这说明任何一个类都有一个隐含的静态成员变量 class
        Class c3 = Student.class;
        //一个类在 JVM 中只会有一个 Class 实例,即我们对上面获取的
        //c1,c2,c3进行 equals 比较，发现都是true
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
    }
}
