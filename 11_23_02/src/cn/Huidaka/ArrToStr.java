package cn.Huidaka;

import javax.print.DocFlavor;

public class ArrToStr {
    public static void main(String[] args){
        int[] arr = {2,3,4,5};
        System.out.println(arrTostr(arr));
    }
    public static String arrTostr(int[] arr){    //将数组变为字符串输出
        int i = 0;
        String str = "[" ;
        for(i=0; i<arr.length; i++){
            if(i == arr.length-1){
                str += (arr[i] + "]");
                break;
            }
            str += (arr[i] + ",");//不能写’，‘  字符会按int类型处理
        }
        return str;
    }

}
