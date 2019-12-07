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
    Node first;
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
    //任意插
    public void addIndex(int index,int data){
        if(index<0 || index>size){
            System.out.println("索引非法");
            return;
        }
        else{
            if(index == 0 || size == 1){
                addFirst(data);
            }
            else if(index == size){
                addLast(data);
            }
            else{
                Node node = new Node(null,data);
                Node temp = first;
                for (int i = 1; i < index; i++) {
                    temp = temp.getNext();
                }
                node.setNext(temp.getNext());
                temp.setNext(node);
            }
        }
    }
    //删除第一个出现的指定元素
    public void removeOne(int data){
        if(first.getData() == data){
            first = first.getNext();
        }
        else{
            Node temp = first;
            while (temp.getNext() != null){
                if(temp.getNext().getData() == data){
                    temp.setNext(temp.getNext().getNext());
                    return;
                }
                else {
                    temp = temp.getNext();
                }
            }
            System.out.println("没有找到该元素");
        }
    }
    //删除出现数值的全部
    public void removeAll(int data){
        while (first.getData() == data){
            first = first.getNext();
        }
        Node temp = first;
        while(temp.getNext() != null){
            if(temp.getNext().getData() == data){
                temp.setNext(temp.getNext().getNext());
            }
            else {
                temp = temp.getNext();
            }
        }
    }
    //修改下标为index的值为data
    public void modification(int index,int data){
        if(index<0 || index>size){
            System.out.println("索引非法");
            return;
        }
        else{
            Node temp = first;
            for (int i = 0; i < index ; i++) {
                temp = temp.getNext();
            }
            temp.setData(data);
        }
    }
    //查找链表中是否有指定元素
    public boolean inquire(int data){
        Node temp = first;
        while(temp.getNext() != null){
            if(temp.getData() == data){
                return true;
            }
            temp = temp.getNext();
        }
            return false;
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
    //创建新链表来反转链表
    public Node reverse2(Node head){
        if(size == 0 || head.getNext() == null){
            return head;
        }
        Node newNode = new Node(null,head.getData());
        while (head.getNext() != null){
            Node node = new Node(null,head.getNext().getData());
            node.setNext(newNode);
            newNode = node;
            head = head.getNext();
        }
       return newNode;
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
