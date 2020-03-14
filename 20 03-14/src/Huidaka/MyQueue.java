package Huidaka;

/**
 * 实现链队列
 * @param <T>
 */
public class MyQueue<T> {
    private Node<T> head;
    private Node<T> last;

    /**
     * 压栈
     * @return
     */
    public void push(T val) {
        Node<T> node = new Node<>(val);
        if(this.head == null){
            this.head = node;
            this.last = node;
            return;
        }
        this.last.next = node;
        this.last = node;
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
        return this.last.data;
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
