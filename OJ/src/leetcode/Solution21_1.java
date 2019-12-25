package leetcode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 */
public class Solution21_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null && l2 == null) {
            return l1;
        }
        ListNode newNode = new ListNode(-1);
        ListNode last = newNode;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                last.next = l1;
                last = l1;
                l1 = l1.next;
            }
            else {
                last.next = l2;
                last = l2;
                l2 = l2.next;
            }
        }
        if(l1 == null){
            last.next = l2;
        }
        else{
            last.next = l1;
        }
        return newNode.next;
    }
}
