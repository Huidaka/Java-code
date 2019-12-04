package cn.Huidaka;

import java.sql.SQLOutput;

public class BinarySystemOneNumber {
    int m;
    //利用二进制按位与1计算出二进制中一的个数
    public int binarySystemOneNumber1(int m){
        int folag = 1;
        int count = 0;
        while (folag != 0){
            if((m&folag) != 0){
                count++;
            }
            folag = folag<<1;
        }
        return count;
    }
    //利用n按位与上n-1可以将n的最后一位置零
    public int binarySystemOneNumber2(int m){
        int count = 0;
        while (m != 0){
            m = m & (m-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        BinarySystemOneNumber binarySystemOneNumber = new BinarySystemOneNumber();
        System.out.println(binarySystemOneNumber.binarySystemOneNumber1(-1));
        System.out.println(binarySystemOneNumber.binarySystemOneNumber2(-1));
    }
}
