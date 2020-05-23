public class Singleton {
    public static volatile Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        //采用两个if可以解决第二次调用的时候会触发获取锁的操作;
        if (instance == null) {
            synchronized (Singleton.class) {
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
//双if可以解决程序效率问题；
//sunchornized可以解决多个线程同时获取对象重复创建对象的问题
//volatile可以解决编辑器过度优化问题