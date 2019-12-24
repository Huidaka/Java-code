package leetcode;

import java.awt.*;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode1 = new ListNode(-1);
        ListNode last1 = newNode1;
        ListNode newNode2 = new ListNode(-1);
        ListNode last2 = newNode2;
        while(head != null){
            if(head.val < x){
                last1.next = head;
                last1 = head;
            }
            else{
                last2.next = head;
                last2 = head;
            }
            head = head.next;
        }
        last2.next = null;
        last1.next = newNode2.next;
        return newNode1.next;
    }
}
