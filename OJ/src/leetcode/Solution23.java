package leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 */
public class Solution23 {
    /**
     * 采用分治法聚合k个链表，采用循环逐一聚合的时间复杂度为O（NK），而分治法的时间复杂度是O（N*logK）
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        else {
            int len = lists.length;
            while(len > 1) {
                for (int i = 0; i < len/2; i++) {
                    lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
                }
                len = (len+1) / 2;
            }
            return lists[0];
        }
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        }else if(l2 == null){
            last.next = l1;
        }
        return newNode.next;
    }
}
