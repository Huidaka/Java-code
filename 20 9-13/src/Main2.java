import java.util.Scanner;

/**
 *
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        int[] ks = new int[n];
        for (int i = 0; i < n; i++) {
            ks[i] = scanner.nextInt();
        }
        int i = 0 , j = i+(m-1);
        int count = 0;
        boolean flage = true;
        while (j < n){
            flage = true;
            for (int l = i; l <= j ; l++) {
                if(ks[l] < k){
                    flage = false;
                    break;
                }
            }
            if(flage){
                count++;
            }
            i = i+1;
            j = i+(m-1);
        }
        System.out.println(count);
    }
}
