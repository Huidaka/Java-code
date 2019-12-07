package cn.Huidaka;

public class Test {
    public static void main(String[] args) {
        SingLeLinkesList s = new SingLeLinkesList();
        s.addFirst(3);
        s.addFirst(2);
        s.addFirst(1);
        s.print();
        //s.reverse();
        s.print();
        Node temp = s.reverse2(s.first);
        while(temp != null){
            if(temp.getNext() == null) {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
            else {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
        }
        s.addIndex(2,6);
        s.print();
        s.removeOne(6);
        s.print();
        s.addIndex(3,3);
        s.print();
        s.removeAll(3);
        s.print();
        s.modification(0,2);
        s.print();
        System.out.println(s.inquire(5));
    }
}
