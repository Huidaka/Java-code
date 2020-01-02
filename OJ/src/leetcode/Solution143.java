package leetcode;

/**
 * 重排链表
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode middNode = middleNode(head);
        ListNode newHead = middNode.next;
        middNode.next = null;
        newHead = reverseList(newHead);
        ListNode temp = head;
        while(newHead != null){
            ListNode newHeadNext = newHead.next;
            newHead.next = temp.next;
            temp.next = newHead;
            temp = temp.next.next;
            newHead = newHeadNext;
        }
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
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
    /**
     * 找出中间节点
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }
        return low;
    }
}
