import java.util.Arrays;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        sc.nextLine();
        String  string = sc.nextLine();
        String[] strings = string.split(" ");
        int[] price = new int[strings.length];
        for(int i=0; i<strings.length;i++){
            price[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(price);
        int ret = 0;
        for(int j=0; j<price.length; j++){
            ret += price[j];
            if (ret == money){
                System.out.println(ret);
                return;
            }
            if (ret > money){
                System.out.println(ret-price[j]);
                return;
            }
        }
    }
}
