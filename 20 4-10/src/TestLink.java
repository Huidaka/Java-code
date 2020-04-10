/**
 * 用实例内部类和泛型实现链表
 * @param <T>
 */
public class TestLink<T> {
    /**
     * 实例内部类
     */
    class Node{
        public T data;
        public Node next;
        public Node (T data) {
            this.data = data;
        }

        public Node() {
        }
    }

    public Node head;

    public void insertHead(T val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void insertTail(T val) {
        Node node = new Node(val);
        if(this.head == null) {
            this.head = node;
        }else {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            //cur  指向的位置 就是尾巴节点
            cur.next = node;
        }
    }

    public void show(TestLink.Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}

