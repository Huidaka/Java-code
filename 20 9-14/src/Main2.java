public class Main2 {
    public static void func(String string){
        int count = 0;
        for (int i = 0; i < string.length()-1;) {
            char c1 = string.charAt(i);
            char c2 = string.charAt(i+1);
            if( (c1=='u' && c2=='u') || (c1=='n' && c2=='n')){
               count = count*2;
                i += 2;
            }
            else {
                i++;
            }
        }
        System.out.println(count*2);
    }

    public static void main(String[] args) {
        func("uuu");
    }
}
