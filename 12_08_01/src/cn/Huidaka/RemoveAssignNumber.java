package cn.Huidaka;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//删除链表中值为val的所有元素
public class RemoveAssignNumber {
    public ListNode removeElements(ListNode head, int val) {
        ListNode xuninode = new ListNode(val-1 );
        xuninode.next = head;
        ListNode temp = head;
        while(temp.next != null ){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        head = xuninode.next;
        return head;
    }
}
