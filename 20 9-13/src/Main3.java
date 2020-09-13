import java.util.*;

/**
 * 填数字
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(i <= k && i >= 1){
                list.add(i);
            }
        }
        List<Integer> testList = new LinkedList<>();
        int ret = numberOfSchemes(list,testList,n,d);
        System.out.println(ret);
    }

    public static int numberOfSchemes(List<Integer> list,List<Integer> testList,int n,int d){
        int sum = 0;
        int max = 0;
        for(Integer integer : testList){
            sum += integer;
            if(integer > max){
                max = integer;
            }
        }
        if(sum >= n){
            if(max >= d && (sum == n)){
                return 1;
            }
            return 0;
        }
        int ret = 0;
        for(int i = 0; i<list.size(); i++){
            testList.add(list.get(i));
            ret += numberOfSchemes(list,testList,n,d)%998244353;
            testList.remove(list.get(i));
        }
        return ret %998244353;
    }
}
