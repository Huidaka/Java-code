package leetcode;
//相交链表，找出交点
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int countA = 0;
        int countB = 0;
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA!= null){
            countA++;               //计算出a的长度
            pA = pA.next;
        }
        while (pB != null){
            countB++;               //计算出b的长度
            pB = pB.next;
        }
        while(countA >countB){
            countA--;
            headA = headA.next;
        }                                 //截取长的链表
        while(countA < countB){
            countB--;
            headB = headB.next;
        }
        while(headA != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
