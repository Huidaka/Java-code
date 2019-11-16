import java.util.*;
public class Digui {
	public static void main (String[] args) {
         System.out.println("请输入一个数");
         Scanner sc = new Scanner(System.in);
         int d = sc.nextInt();
         Digui Test = new Digui();
         System.out.println(Test.Diguijiecheng(d));
         //Test.Xunhuanjiecheng(d);
	}
	//递归
    int Diguijiecheng(int x) {
    	if(x == 1) {
    		return 1;
    	}
		int y;
		y = x*Diguijiecheng(x-1);
		return y;
	}
}
    
    /*循环
    void Xunhuanjiecheng(int x) {
    	int i;
    	int j = 1;
    	for(i = 1;i <= x; i++) {
    		j *= i;
    	}
    	System.out.println(j);
    }
    
}
*/
