package cn.Huidaka;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
public class MiddLeNode {
    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode temp = head;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        for (int i = 1; i <= count/2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
