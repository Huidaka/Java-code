package leetcode;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        int count = 1;
        while (temp.next != null){
            count++;
            temp = temp.next;
        }
        temp = head;
        ListNode prev = null;
        int m = k % count;
        for (int i = 0; i < m; i++) {
            while (temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
