package leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode temp2 = null;
        while(temp != null && temp.next != null) {
            temp2 = temp.next.next;
            if (prev == null) {
                head = temp.next;
            } else {
                prev.next = temp.next;
            }
            temp.next.next = temp;
            temp.next = temp2;
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
