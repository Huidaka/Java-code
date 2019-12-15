package leetcode;
//给定一个链表，判断链表中是否有环。
//快慢指针
public class Solution1141_1 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if(fast == low){
                return true;
            }
        }
        return false;
    }
}
