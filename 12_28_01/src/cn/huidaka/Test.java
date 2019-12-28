package cn.huidaka;

public class Test {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();
        Computer computer = new Computer();
        computer.plugin(mouse);
        computer.plugin(keyboard);
    }
}
