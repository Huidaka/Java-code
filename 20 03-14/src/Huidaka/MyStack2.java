package Huidaka;

/**
 * 实现链栈
 * @param <E>
 */
class Node<E> {
    public E data;
    public Node<E> next;

    public Node(E val) {
        //this.data = (E)new Object(); 没必要强转
        this.data = val;
    }
}

public class MyStack2<T> {
    private Node<T> head;

    /**
     * 压栈
     * @return
     */
    public void push(T val) {
        Node<T> node = new Node<>(val);
        node.next = head;
        this.head = node;
    }

    /**
     *  出栈：返回值是出栈的元素
     * @return
     */
    public T pop(){
        if(this.empty()){
            return null;
        }
        Node<T> ret = head;
        this.head = head.next;
        return ret.data;
    }

    /**
     * 得到栈顶元素但是不出栈
     * @return
     */
    public T peek(){
        if(this.empty()){
            return null;
        }
        return this.head.data;
    }
    /**
     * 测试堆栈是否为空
     * @return
     */
    public boolean empty(){
        if(this.head == null){
            return true;
        }
        return false;
    }

}
