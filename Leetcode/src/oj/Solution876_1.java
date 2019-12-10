package oj;
//给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
public class Solution876_1 {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
