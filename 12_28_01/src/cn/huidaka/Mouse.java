package cn.huidaka;

public class Mouse implements USB{
    @Override
    public void setUp() {
        System.out.println("安装鼠标驱动");
    }

    @Override
    public void work() {
        System.out.println("鼠标开始工作");
    }
}
