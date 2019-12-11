package oj;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(head.val-1);
        dummy.next = head;
        ListNode temp = head;
        while(temp.next != null){
            if(temp.val == temp.next.val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}
