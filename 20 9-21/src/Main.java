import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 找最大乘积
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arrayList = new ArrayList<>();
        String string = sc.nextLine();
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            arrayList.add(Integer.parseInt(strings[i]));
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(3);
        for (int i = 0; i < arrayList.size(); i++) {
            if(queue.size() > 3){
                queue.add(arrayList.get(i));
                queue.poll();
            }
            else {
                queue.add(arrayList.get(i));
            }
        }
        int ret = 1;
        for (Integer integer:queue) {
            ret *= integer;
        }
        System.out.println(ret);
    }
}
