import java.util.*;
class Pyramid{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        int n = 0;
        int m = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(i=0; i<m-n+1; i++){
            for(j=m-n-i; j>0; j--){
                System.out.print(" ");
            }
            for(j=0; j<=i; j++){
                System.out.print(+n+i+" ");
            }
            System.out.println();
        }
    }
}