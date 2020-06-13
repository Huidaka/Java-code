package nowcoder;

/**
 * 生成格雷码
 */
public class Solution26 {
    public static String[] getGray(int n) {
        // write code here
        if(n == 1){
            return new String[]{"0","1"};
        }
        String[] str = getGray(n-1);
        int len = str.length;
        String[] str2 = new String[len*2];
        for(int i = 0; i<str2.length; i++){
            if(i<len){
                str2[i] = "0" + str[i];
            }
            else{
                str2[i] = "1" + str[str2.length-1-i];
            }
        }
        return str2;
    }

    public static void main(String[] args) {
        String[] strs = getGray(3);
        for(String s: strs){
            System.out.print(s + " ");
        }
    }
}
