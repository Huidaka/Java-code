package cn.Huidaka;

public class LengthOfLongestSubstring {
    String str;
    int count = 1;
    public int lengthOfLongestSubstring(String str) {
        int j;
        char[] arr = str.toCharArray();
        int falog = 0;
        for (int i = 0; i < arr.length; i++) {
            char[] a = new char[arr.length];
            a[0] = arr[i];
            count = 1;
            for (j = i+1; j < arr.length; j++) {
                if (!arraysIncludeNumber(arr[j], a)) {
                    a[count] = arr[j];
                    count++;
                }
                else{
                    break;
                }
            }
            if (falog < count) {
                falog = count;
            }
        }
        return falog;
    }

    public boolean arraysIncludeNumber(char a,char[] arr){
        int i;
        for (i = 0; i < count; i++) {
            if(arr[i] == a){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "abcabcdbcfcasv";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(str));
    }
}
