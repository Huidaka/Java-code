package leetcode;
//给定一个链表，判断链表中是否有环。
class Solution141 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode temp1 = head.next;
        ListNode temp2 = head;
        while (temp1.next != null){
            temp2 = head;
            while(temp1.next != temp2 && temp1 != temp2){
                temp2 = temp2.next;
            }
            if(temp1.next == temp2){
                return true;
            }
            temp1 = temp1.next;
        }
        return false;
    }
}

