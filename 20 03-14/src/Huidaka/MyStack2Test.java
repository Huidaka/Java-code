package Huidaka;


class MyStack2Test {
    public static void main(String[] args) {
        MyStack2<String> myStack2 = new MyStack2<>();
        myStack2.push("1");
        myStack2.push("2");
        myStack2.push("3");
        myStack2.push("4");
        System.out.println(myStack2.peek());
        myStack2.pop();
        System.out.println(myStack2.peek());
    }
}