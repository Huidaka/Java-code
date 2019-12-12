package leetcode;

public class Solution21 {
    public  ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null && l2 != null){
            return l2;
        }
        if(l1 != null && l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return l1;
        }
        ListNode newLast = null;
        ListNode newNode = null;
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                ListNode node = new ListNode(l1.val);
                if(newNode == null){
                    newNode = node;
                    newLast = node;
                }
                else{
                    newLast.next = node;
                    newLast = node;
                }
                l1 = l1.next;
            }
            else{
                ListNode node = new ListNode(l2.val);
                if(newNode == null){
                    newNode = node;
                    newLast = node;
                }
                else{
                    newLast.next = node;
                    newLast = node;
                }
                l2 = l2.next;
            }
        }
        while (l1 != null){
            ListNode node = new ListNode(l1.val);
            newLast.next = node;
            newLast = node;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode node = new ListNode(l2.val);
            newLast.next = node;
            newLast = node;
            l2 = l2.next;
        }
        return newNode;
    }
}
