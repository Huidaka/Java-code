import java.util.Scanner;
public class JiOuXuLie{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        int k = 0;
        int n = 0;
        int[] arr1 = new int[16];
        int[] arr2 = new int[16];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(i=31; i>=0; i--){
            if(n < 0){
                n = -n;
                arr1[j] = ((n>>i) | 1);
                j++;
                continue;
            }
            if(i%2 == 1){
                arr1[j] = ((n>>i) & 1);
                j++;
            }
            else{
                arr2[k] = ((n>>i) & 1);
                k++;
            }
        }
        System.out.print("奇数：");
        for(i=0; i<=15; i++){
            System.out.print(arr1[i]);
        }
        System.out.println("");
        System.out.print("偶数：");
        for(i=0; i<=15; i++){
            System.out.print(arr2[i]);
        }
    }
}