package cn.Huidaka;

class Node{
    private Node next;
    private int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(Node next, int data) {
        this.next = next;
        this.data = data;
    }
}
//单链表实现
public class SingLeLinkesList {
    private int size;
    private Node first;
    private Node last;
    //默认添加方法：尾插
    public void add(int data){
        addLast(data);
    }
    //头插
    public void addFirst(int data){
        Node node = new Node(null, data);
        if(first == null){
            last = first = node;
            size++;
            return;
        }
        else{
            node.setNext(first);
            first = node;
            size++;
        }
    }
    //尾插
    public void addLast(int data){
        Node node = new Node(null, data);
        if(first == null){
            last = first = node;
            size++;
            return;
        }
        last.setNext(node);
        last = node;
        size++;
    }

    //回文链表（反转链表）
    public void reverse(){
        if(size == 0){
            return;
        }
        Node tempLeft = null;
        Node temp = first;
        Node tempRight = first.getNext();
        temp.setNext(null);
        while ((tempRight != null)) {
            tempLeft = temp;
            temp = tempRight;
            tempRight = temp.getNext();
            temp.setNext(tempLeft);
        }
        last  = first;
        first = temp;
    }
    //遍历链表
    public void print(){
        Node temp = first;
        while(temp != null){
            if(temp.getNext() == null) {
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
            else {
                System.out.print(temp.getData() + " ");
                temp = temp.getNext();
            }
        }
    }
}
