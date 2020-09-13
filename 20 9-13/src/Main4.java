import java.util.Arrays;
import java.util.Scanner;
//根据必要性和优先级进行比较
class Matter implements Comparable<Matter>{
    int priority;
    int essential;
    int index;

    public Matter(int priority, int essential,int index) {
        this.priority = priority;
        this.essential = essential;
        this.index = index;
    }

    @Override
    public int compareTo(Matter o) {
        if(o.essential != this.essential ){
            return o.essential - this.essential;
        }
        else{
            return o.priority - this.priority;
        }
    }
}
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        scanner.nextLine();
        Matter[] matters = new Matter[len];
        for(int i=0; i<len; i++){
            String temp = scanner.nextLine();
            String[] strings = temp.split(" ");
            matters[i] = new Matter(Integer.parseInt(strings[0]),Integer.parseInt(strings[1]),i);
        }
        Arrays.sort(matters);
        for(Matter matter : matters){
            System.out.print(matter.index+1 + " ");
        }
    }
}
