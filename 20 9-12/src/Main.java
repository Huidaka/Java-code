public class Main {
    //对字母进行全排列
    public static void range(char[] chars, int start, int len){
        if(start == len-1){
            System.out.println(chars);
            return;
        }
        for (int i = start; i < len; i++) {
            if (!isInChar(chars, start, i, chars[i])) {
                char temp = chars[start];
                chars[start] = chars[i];
                chars[i] = temp;
                range(chars, start + 1, len);
                temp = chars[start];
                chars[start] = chars[i];
                chars[i] = temp;
            }
        }
    }

    private static boolean isInChar(char[] chars,int start, int end, char c) {
        for (int i = start; i < end; i++) {
            if(c == chars[i]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String string = "aaca";
        range(string.toCharArray(),0,string.length());
    }
}
