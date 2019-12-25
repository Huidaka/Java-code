package leetcode;

/**
 * 给出两个非空的链表用来表示两个非负的整数。其中它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        int num = 0;
        int flag = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode newNode = new ListNode(-1);
        ListNode last = newNode;
        while (temp1 != null || temp2 != null){
            int x = (temp1 != null) ? temp1.val : 0;
            int y = (temp2 != null) ? temp2.val : 0;
            num = x + y + flag;
            ListNode node = new ListNode(num%10);
            last.next = node;
            last = node;
            flag = num>=10 ? 1 : 0;
            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        if(flag == 1){
            ListNode node = new ListNode(1);
            last.next = node;
            last = node;
        }
        return newNode.next;
    }
}
