package nowcoder;

//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针

public class Solution1 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode prev = dummy;
        ListNode temp = pHead;
        while (temp != null) {
            if (temp.next != null && temp.val == temp.next.val) {
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                prev.next = temp.next;
                temp = temp.next;
            } else {
                temp = temp.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
