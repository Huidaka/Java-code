import java.util.Arrays;

class TestDemoTest {
    public static void main(String[] args) {
        TestLink<Integer> testLink1 = new TestLink<>();
        testLink1.insertTail(1);
        testLink1.insertTail(3);
        testLink1.insertTail(5);
        TestLink<Integer> testLink2 = new TestLink<>();
        testLink2.insertTail(2);
        testLink2.insertTail(4);
        testLink2.insertTail(6);
        testLink1.show(TestDemo.meageList(testLink1.head, testLink2.head));
    }
}