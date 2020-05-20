public class TestSingleton {
    static class Test{    //单例模式之饿汉模式
        private Test() {}
        private static Test t = new Test();
        private static Test getTest(){
            return t;
        }
    }
    public static void main(String[] args) {
        Test t1 = Test.getTest();
        Test t2 = Test.getTest();
        System.out.println(t1 == t2);
    }
}
