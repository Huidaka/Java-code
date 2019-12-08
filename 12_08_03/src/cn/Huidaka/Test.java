package cn.Huidaka;

public class Test {
    public static void main(String[] args) {
        SingLeLinkesList s = new SingLeLinkesList();
        s.addFirst(4);
        s.addFirst(2);
        s.addFirst(1);
        s.print(s.first);
        SingLeLinkesList s2 = new SingLeLinkesList();
        s2.addFirst(4);
        s2.addFirst(3);
        s2.addFirst(1);
        s2.print(s.first);
        MainClass m = new MainClass();
        s.print(m.mergeTwoLists(s.first,s2.first));
    }
}
