public class TestSingleton2 {

    static class Test2{    //单例模式之饱汉模式
        private Test2() {}
        private static Test2 t = null;
        private static Test2 getTest(){
            if(t == null) {
                t = new Test2();
            }
            return t;
        }
    }
    public static void main(String[] args) {
        Test2 t1 = Test2.getTest();
        Test2 t2 = Test2.getTest();
        System.out.println(t1 == t2);
    }
}
