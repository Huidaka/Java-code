package Huidaka;

import java.util.ArrayList;
import java.util.Comparator;

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("abc");
        list.add("gaobohhhh");
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s+" ");
            }
        });*/

        list.forEach(s->System.out.print(s+" "));

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        list.sort((o1, o2) ->  {return o1.length()-o2.length();});
    }
}
