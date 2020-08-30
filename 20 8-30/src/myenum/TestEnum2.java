package myenum;

public enum TestEnum2 {
    INSTANCE;

    public TestEnum2 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        TestEnum2 singleton1 = TestEnum2.INSTANCE;
        TestEnum2 singleton2 = TestEnum2.INSTANCE;
        System.out.println("两个实例是否相同：" + (singleton1 == singleton2));
    }
}
