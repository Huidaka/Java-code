import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        ArrayList的底层，add和set的区别，扩容（1.5倍扩容）
//        LinkList的底层，每次添加元素都会动态申请内存
        List<String> list = new LinkedList();
        list.add("ha");
        list.add("fs");
        list.add("d");
        list.add("fa");
        list.add("fds");
        list.add(1,"fsafd");
        System.out.println(list.toString());
    }
}
