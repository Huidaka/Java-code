package cn.Huidaka;
/*
测试向上溯型
 */
class Shape{
    protected void paint(){
        System.out.println("");
    }
}
class Cricle extends Shape{
    protected void paint(){
        System.out.println("画一个圆");
    }
}
class Triangle extends Shape{
    protected void paint(){
        System.out.println("画一个三角形");
    }
}
class Square extends Shape{
    protected void paint(){
        System.out.println("画一个正方形");
    }
}
public class Paint {
    public static void draw(Shape s){
        s.paint();
    }
    public static void main(String[] args) {
        Shape s = null;
        int n = (int)(Math.random()*2);
        switch (n){
            case 0: s = new Cricle(); break;
            case 1: s = new Triangle(); break;
            case 2: s = new Square(); break;
            default:
        }
        draw(s);
    }
}
