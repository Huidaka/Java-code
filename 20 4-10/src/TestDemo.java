/**
 * 合并泛型内部类链表
 */
public class TestDemo {

    public static<T extends Comparable<T>> TestLink<T>.Node meageList(TestLink<T>.Node headA , TestLink<T>.Node headB){
        if(headA == null || headB == null){
            if(headA ==null && headB == null){
                return null;
            }
            return headA == null ? headB : headA;
        }
        TestLink<T>.Node dummy = new TestLink<T>().new Node();
        TestLink<T>.Node last = dummy;
        while (headA != null && headB != null){
            if(headA.data.compareTo(headB.data) >= 0) {
                last.next = headB;
                last = headB;
                headB = headB.next;
            }
            else {
                last.next = headA;
                last = headA;
                headA = headA.next;
            }
        }
        if(headA == null){
            last.next = headB;
        }
        if(headB == null){
            last.next = headA;
        }
        return dummy.next;
    }
}
