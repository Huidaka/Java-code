package Reflect;

import com.sun.tools.attach.AgentInitializationException;

import javax.xml.transform.Source;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflecClassDemo {

    public static void reflectConstructor() {
        try {
            Class<?> studentClass = Class.forName("Reflect.Student");
            Constructor constructor = studentClass.getConstructor(String.class, int.class);
            System.out.println(constructor);
            Constructor constructor2 = studentClass.getConstructor();
            System.out.println(constructor2);
            System.out.println("****************************");
            Constructor[] constructors = studentClass.getConstructors();
            for (Constructor c :constructors) {
                System.out.println(c);
            }
            System.out.println("****************************");
            Constructor[] constructors2 = studentClass.getDeclaredConstructors();
            for (Constructor c :constructors2) {
                System.out.println(c);
            }
            System.out.println("****************************");
            constructors2[0].setAccessible(true);
            Student students = (Student) constructors2[0].newInstance("郭奥辉",20,100);
            System.out.println(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflectNewInstance(){
        try {
            Class<?> studentClass = Class.forName("Reflect.Student");
            Student student = (Student) studentClass.getConstructor().newInstance();
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reflectField(){
        try {
            Class<?> studentClass = Class.forName("Reflect.Student");
            Constructor constructor = studentClass.getDeclaredConstructor(String.class, int.class,int.class);
            constructor.setAccessible(true);
            Student student = (Student) constructor.newInstance("郭奥辉",20,100);
            System.out.println(student);
            Field field1 = studentClass.getField("age");
            field1.set(student,21);
            Field field2 = studentClass.getDeclaredField("grade");
            field2.setAccessible(true);
            field2.set(student,150);
            System.out.println(student);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void reflectMethod(){
        try {
            Class<?> studentClass = Class.forName("Reflect.Student");
            Student student = (Student) studentClass.getConstructor().newInstance();
            Method method = studentClass.getDeclaredMethod("func",String.class);
            method.setAccessible(true);
            method.invoke(student,"hahaha");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //reflectNewInstance();
        //reflectConstructor();
        //reflectField();
        reflectMethod();
    }
}
