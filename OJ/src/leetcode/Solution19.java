package leetcode;
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
  */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        while (fast != null){
            fast = fast.next;
            count++;
            if(count >= n+2){
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        if(n>count){
            System.out.println("n输入有误");
        }
        return dummy.next;
    }
}
