package Huidaka;

class MyStack1Test {
    public static void main(String[] args) {
        MyStack1<Integer> m = new MyStack1<>();
        m.push(1);
        m.push(2);
        m.push(3);
        m.push(4);
        System.out.println(m.peek());
        System.out.println(m.pop());
        System.out.println(m.peek());
    }

}