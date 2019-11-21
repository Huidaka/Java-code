import java.util.Scanner;;
//class BinaruySystemQiuYi{
//    public static void main(String[] args){
//        int n = 0;
//        int count = 0;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        if(n < 0){
//            count++;
//        }
//        while(n/2 != 0){
//            if(n%2==1 || n%2==-1){
//                count++;
//            }
//            n = n / 2;
//        }
//        count++;
//        System.out.println(count);
//    }
//}
class BinaruySystemQiuYi{
    public static void main(String[] args){
        int n = 0;
        int count = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n == 0){
            n = n & (n-1);
            count++;
        }
        System.out.println(count);
    }
}