package leetcode;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 */
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode temp = head;
        ListNode newhead = head;
        ListNode prev = dummy;
        ListNode tempnext = null;
        int count = 1;
        int n = 1;
        while(temp != null){
            if(count == n*k){
                tempnext = temp.next;
                prev.next = reverseList(newhead,temp);
                prev = newhead;
                newhead.next = tempnext;
                newhead = tempnext;
                count++;
                temp = tempnext;
                n++;
                continue;
            }
            count++;
            temp = temp.next;
        }

        return dummy.next;
    }
    public ListNode reverseList(ListNode head, ListNode last) {
        last.next = null;
        if(head == null || head.next == null){
            return head;
        }
        ListNode tempLeft = null;
        ListNode temp = head;
        ListNode tempRight = temp.next;
        temp.next = null;
        while(tempRight != null){
            tempLeft = temp;
            temp  = tempRight;
            tempRight = temp.next;
            temp.next = tempLeft;
        }
        head = temp;
        return head;
    }
}
