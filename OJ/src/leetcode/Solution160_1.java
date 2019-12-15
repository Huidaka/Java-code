package leetcode;
//相交链表，找交点
public class Solution160_1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb){
            pa = pa == null ? headB: pa.next;
            pb = pb == null ? headA: pb.next;
        }
        return pa;
    }
}
