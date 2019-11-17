import java.util.Scanner;
public class HexOut
{
    public static void main(String[] args)
    { 
        int i = 0;
        int n;
        int[] arr = new int[32];
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n >=0 ){
            for(i=0; i<32; i++){
                arr[i] = ((n>>31-i) & 1);
            }
        }
        else{
            n = -n;
            for(i=0; i<32; i++){
                if(i == 0){
                    arr[i] = ((n>>31-i) | 1);
                    continue;
                }
                arr[i] = ((n>>31-i) & 1);
            }   
        }
        for(i=0; i<=31; i++){
            System.out.print(arr[i]);
        }
    }
}
