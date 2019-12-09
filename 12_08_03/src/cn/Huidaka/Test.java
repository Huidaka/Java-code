package cn.Huidaka;

public class Test {
    public static void main(String[] args) {
        SingLeLinkesList s = new SingLeLinkesList();
        LinkSort l = new LinkSort();
        s.addFirst(7);
        s.addFirst(5);
        s.print(s.first);
        SingLeLinkesList s2 = new SingLeLinkesList();
        s2.addFirst(3);
        s2.addFirst(-9);
        s2.print(s2.first);
        MainClass m = new MainClass();
        //s.print(m.mergeTwoLists(s.first,s2.first));
        //s.print(l.linkSort(s.first,s2.first));
        NewLinked newLinked = new NewLinked();
        s.print(newLinked.newLinked(s.first,s2.first));
    }
}
