package cn.Huidaka;

public class DoubleLinkedList {
    public DoubleNode head;
    private int size = 0;
    public DoubleNode last;
//头插
    public void addFirst(int val){
        DoubleNode node = new DoubleNode(null,val,null);
        if(head == null){
            head = node;
            size++;
        }
        else{
            node.next = head;
            head.prev = node;
            head = node;
            size++;
        }
    }
    //尾插
    public void addLast(int val){
        DoubleNode node = new DoubleNode(null,val,null);
        if(last == null){
            head = last = node;
            size++;
        }
        else{
            last.next = node;
            node.prev = last;
            last = node;
            size++;
        }
    }
    //任意位置插入
    public void addIndex(int index,int val){
        if(index < 0 || index > size){
            System.out.println("索引非法");
            return;
        }
        else if(index == 0){
            addFirst(val);
        }
        else if(index == size){
            addLast(val);
        }
        else {
            DoubleNode prev = node(index).prev;
            DoubleNode node = new DoubleNode(prev,val,prev.next);
            node.next.prev = node;
            prev.next = node;
            size++;
        }
    }
    //删除指定位置的节点
    public void removeIndex(int index){
        if(index < 0 || index >= size){
            System.out.println("索引非法");
            return;
        }
        DoubleNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        unlink(temp);
    }
    //删除第一个指定值的节点
    public void removeData(int data){
        DoubleNode temp = head;
        while (temp != null){
            if(temp.val == data){
                unlink(temp);
                break;
            }
            else{
                temp = temp.next;
            }
        }
    }
    //删除所有指定值的节点
    public void removeAll(int data){
        DoubleNode temp = head;
        while (temp != null){
            if(temp.val == data){
                DoubleNode next = temp.next;
                unlink(temp);
                temp = next;
            }
            else{
                temp = temp.next;
            }
        }
    }
    //删除一个节点
    public void unlink(DoubleNode x){
        DoubleNode prev = x.prev;
        DoubleNode next = x.next;
        if(prev == null){
            head = head.next;
        }
        else{
            x.prev = null;
            prev.next = next;
        }
        if (next == null){
            last = prev;
        }
        else{
            next.prev = prev;
            x.next = null;
        }
        size--;
    }
    //查找索引为index的元素节点
    private DoubleNode node(int index) {
        if(index < 0 || index > size){
            System.out.println("索引非法");
            return head;
        }
        if (index < size >> 1) {
            DoubleNode temp = head;
            for (int i = 0; i <index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        else{
            DoubleNode temp = last;
            for (int i = size-1; i > 0 ; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }
    //遍历链表
    public void print(DoubleNode head){

        while (head != null){
            if(head.next == null){
                System.out.print(head.val);
                return;
            }
            System.out.print(head.val+",");
            head = head.next;
        }
    }
}
