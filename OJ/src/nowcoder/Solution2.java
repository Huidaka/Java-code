package nowcoder;

//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
//给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变

public class Solution2 {
    public ListNode partition(ListNode pHead, int x) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode newNode1 = new ListNode(-1);
        ListNode last1 = newNode1;
        ListNode newNode2 = new ListNode(-1);
        ListNode last2 = newNode2;
        while (pHead != null){
            ListNode node = new ListNode(0);
            if(pHead.val < x) {
                node.val = pHead.val;
                last1.next = node;
                last1 = node;
            }
            else{
                node.val = pHead.val;
                last2.next = node;
                last2 = node;

            }
            pHead = pHead.next;
        }
        last1.next = newNode2.next;
        return newNode1.next;
    }
}
