package leetcode;

public class Test {
    public static void main(String[] args) {
        SingLeLinkesList s = new SingLeLinkesList();
        s.addLast(1);
        s.addLast(4);
        s.addLast(3);
        s.addLast(2);
        s.addLast(5);
        s.addLast(2);
        s.print(s.first);
        Solution86 solution86 = new Solution86();
        s.print(solution86.partition(s.first,3));
    }
}
