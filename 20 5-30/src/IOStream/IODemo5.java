package IOStream;

import javax.naming.spi.ObjectFactory;
import java.io.*;

/**
 * 序列化和反序列化
 */
class Person implements Serializable{
    public String name;
    public int age;
}
public class IODemo5 {
    public void serializePerson(Person person){
        // 把 Person 对象序列化并保存到文件中
        // ObjectOutputStream 既帮我们完成序列化, 也完成了 IO 操作.
        // 要想让对象能够借助 ObjectOutputStream 来序列化, 就必须让类实现 Serializable 接口
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("F:\\test.txt"))){
            objectOutputStream.writeObject(person);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Person deserializePerson(){
        //把文件中保存的序列化对象转化成非序列化对象
        // 把 Person 对象从文件中读出来, 并进行反序列化, 并返回.
        // readObject 既完成了 IO 操作, 也完成了反序列化操作.
        Person person = null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("F:\\test.txt")) {
        }){
            person = (Person) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void main(String[] args) {
          IODemo5 ioDemo5 = new IODemo5();
//        Person person = new Person();
//        person.name = "郭奥辉";
//        person.age = 18;
//        ioDemo5.serializePerson(person);
          Person person = ioDemo5.deserializePerson();
          System.out.println(person.name+"  "+person.age);
    }
}
