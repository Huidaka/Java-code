package cn.huidaka;

public class Keyboard implements USB{
    @Override
    public void setUp() {
        System.out.println("安装键盘驱动");
    }

    @Override
    public void work() {
        System.out.println("键盘开始工作");
    }
}
