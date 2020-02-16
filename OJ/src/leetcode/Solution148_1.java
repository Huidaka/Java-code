package leetcode;

public class Solution148_1 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        quickSort(head,null);
        return head;
    }

    private void quickSort(ListNode head, ListNode tail){
        if(head == tail || head.next == tail) return;
        int pivot = head.val;
        ListNode left = head;
        ListNode cur = head.next;

        while(cur != tail){
            if(cur.val < pivot){
                left = left.next;
                swap(left, cur);
            }
            cur = cur.next;
        }
        swap(head, left);
        quickSort(head, left);
        quickSort(left.next, tail);
    }

    private void swap(ListNode l1 , ListNode l2){
        int temp = l1.val;
        l1.val = l2.val;
        l2.val = temp;
    }
}
