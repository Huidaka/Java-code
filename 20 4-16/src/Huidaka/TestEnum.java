package Huidaka;

import java.lang.reflect.Constructor;

public enum TestEnum {

    //枚举对象
    RED("红色",1),GREEN("绿色",2),BLACK("黑色",3);

    public String color;
    public int num;
    /*
    TestEnum() {

    }*/

    TestEnum(String color,int num) {
        this.color = color;
        this.num = num;
    }

    public static TestEnum getEnumKey (int key) {
        for (TestEnum t: TestEnum.values()) {
            if(t.num == key) {
                return t;
            }
        }
        return null;
    }


    public static void reflectPrivateConstructor() {
        try {
            Class<?> classStudent = Class.forName("Huidaka.TestEnum");

            Constructor<?> declaredConstructorStudent =
                    classStudent.getDeclaredConstructor(String.class, int.class,String.class, int.class);

            //设置为true后可修改访问权限
            declaredConstructorStudent.setAccessible(true);
            //写的Eunm默认继承于Object的Eunm，四个形参中后边两个是给父类构造的
            Object objectStudent = declaredConstructorStudent.newInstance("棕色", 666,"父类的",14);
            TestEnum testEnum = (TestEnum) objectStudent;
            System.out.println("获得枚举的私有构造函数：" + testEnum);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        reflectPrivateConstructor();
    }

    public static void main3(String[] args) {
        System.out.println(getEnumKey(3));
    }

    public static void main2(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for (int i = 0; i < testEnums.length; i++) {
            //testEnums[i].ordinal()  枚举对象在 其中的 索引位置
            System.out.println(testEnums[i]+" " + testEnums[i].ordinal());
        }
        System.out.println("=================");
        TestEnum testEnum = TestEnum.valueOf("GREEN");
        System.out.println(testEnum);
    }

    public static void main1(String[] args) {
        TestEnum testEnum = TestEnum.RED;
        switch (testEnum) {
            case BLACK:
                System.out.println("BLACK");
                break;
            case RED:
                System.out.println("RED");
                break;
            case GREEN:
                System.out.println("GREEN");
                break;
        }
    }

}
