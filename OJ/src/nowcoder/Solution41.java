package nowcoder;

import java.util.Scanner;

/**
 * 球的半径和体积
 *
 */
public class Solution41 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();
            double a = Math.sqrt((x1-x0)*(x1-x0) + (y1-y0)*(y1-y0));
            double r = Math.sqrt((a*a) + (z1-z0)*(z1-z0));
            System.out.printf("%.3f ",r);
            double area = (4/3.0)*Math.acos(-1)*(r*r*r);
            System.out.printf("%.3f",area);
        }
    }
}
