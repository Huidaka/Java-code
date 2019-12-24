package leetcode;

//单链表实现
public class SingLeLinkesList {
    private int size;
    ListNode first;
    private ListNode last;
    //默认添加方法：尾插
    public void add(int data){
        addLast(data);
    }
    //头插
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(first == null){
            last = first = node;
            size++;
            return;
        }
        else{
            node.next = first;
            first = node;
            size++;
        }
    }
    //尾插
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(first == null){
            last = first = node;
            size++;
            return;
        }
        last.next = node;
        last = node;
        size++;
    }
    //遍历链表
    public void print(ListNode head){
        ListNode temp = head;
        while(temp != null){
            if(temp.next == null) {
                System.out.println(temp.val);
                temp = temp.next;
            }
            else {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
    }

}
