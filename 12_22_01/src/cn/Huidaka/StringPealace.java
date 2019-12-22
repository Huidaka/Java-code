package cn.Huidaka;

public class StringPealace {
    String stringPealace(String str){
        int len = str.length();
        int len2;
        int count = 0;
        StringBuffer str1 = new StringBuffer(str);
        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        len2 = len + count*2;
        str1.setLength(len2);
        int i1 = len - 1;
        int i2 = len2 - 1;
        while (i1 != i2){
            if(str1.charAt(i1) == ' '){
                str1.setCharAt(i2--,'0');
                str1.setCharAt(i2--,'2');
                str1.setCharAt(i2--,'%');
            }
            else {
                str1.setCharAt(i2--, str1.charAt(i1));
            }
            i1--;
        }
        return str1.toString();
    }
}
