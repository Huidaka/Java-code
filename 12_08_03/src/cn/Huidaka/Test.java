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
        LinkSort1 l1 = new LinkSort1();
        LinkSort1 l2 = new LinkSort1();
        //s.print(m.mergeTwoLists(s.first,s2.first));
        //s.print(l.linkSort(s.first,s2.first));
        s.print(l1.linkSort(s.first,s2.first));
        s.print(l2.linkSort(s.first,s2.first));
    }
}
