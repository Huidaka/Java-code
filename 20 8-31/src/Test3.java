public class Test3 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Test3 test = new Test3();
        try {
            test.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack Length: " + test.stackLength);
            throw e;
        }
    }
}