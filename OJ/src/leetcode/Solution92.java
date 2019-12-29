package leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n-m == 0){
            return head;
        }
        ListNode tempLeft = null;
        ListNode temp = head;
        ListNode tempRight = head.next;
        ListNode newprev = null;
        ListNode newlast = null;
        for(int i = 0 ; i <=  n-2; i++) {
            if(i >= m-1){
                if(i == m-1){
                    newprev = tempLeft;
                    newlast = temp;
                }
                tempLeft = temp;
                temp = tempRight;
                tempRight = temp.next;
                temp.next = tempLeft;
                continue;
            }
            tempLeft = temp;
            temp = tempRight;
            tempRight = temp.next;
        }
        if(newprev != null){
            newprev.next = temp;
        }
        else{
            head = temp;
        }
        newlast.next = tempRight;
        return head;
    }
}
