package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo2 {
    //创建对象
    public static void reflectInstance(){
        try {
            Class c1 = Class.forName("reflect.Student");
            Student student = (Student)c1.newInstance();
            System.out.println(student);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    //反射私有构造方法
    public static void  reflectPrivateConstructor(){
        try {
            Class c = Class.forName("reflect.Student");
            //获取到私有构造函数
            Constructor constructor = c.getDeclaredConstructor(String.class,int.class);
            //设置为true可以修改访问权限
            constructor.setAccessible(true);
            //获得私有构造函数并修改姓名和年龄
            Student student = (Student) constructor.newInstance("郭",18);
            System.out.println(student);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    // 反射私有属性
    public static void reflectPrivateField() {
        try {
            Class classStudent = Class.forName("reflect.Student");
            Field field = classStudent.getDeclaredField("age");
            field.setAccessible(true);
            //可以修改该属性的值
            Student student = (Student) classStudent.newInstance();;
            field.set(student, 100);
            int age = (int) field.get(student);
            System.out.println("反射私有属性修改了name：" + age);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //反射私有方法
    public static void refectPrivateMethod(){
        try {
            Class classStudent = Class.forName("reflect.Student");
            Method method = classStudent.getDeclaredMethod("func");
            method.setAccessible(true);
            Student student = (Student) classStudent.newInstance();
            method.invoke(student);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        reflectPrivateConstructor();
        reflectPrivateField();
        refectPrivateMethod();
    }
}
