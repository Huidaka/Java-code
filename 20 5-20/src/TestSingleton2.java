public class TestSingleton2 {

    static class Test2{    //单例模式之饱汉模式
        private Test2() {}
        private static Test2 t = null;
        private static Test2 getTest(){
            t = new Test2();
            return t;
        }
    }
    public static void main(String[] args) {
        Test2 t1 = new Test2();
        Test2 t2 = new Test2();
        System.out.println(t1 == t2);
    }
}
