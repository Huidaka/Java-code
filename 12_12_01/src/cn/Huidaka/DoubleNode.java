package cn.Huidaka;

public class DoubleNode {
    DoubleNode prev;
    int val;
    DoubleNode next;

    public DoubleNode(DoubleNode prev, int val, DoubleNode next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}
