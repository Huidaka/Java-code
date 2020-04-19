package Huidaka;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s1 = new String[1000];
        for (int i = 0;; i++) {
            if(scanner.nextLine() == null){
                break;
            }
            s1[i] = scanner.nextLine();
        }
        String[][] s2 = new String[1000][1000];
        for (int i = 0; i < s1.length; i++) {
            s2[i] = s1[i].split(" ");
        }
        Set<String> set = new HashSet<>();
        for (int j = 0; j < s2.length; j++) {
            for (int k = 0; k < s2[j].length; k++) {
                set.add(s2[j][k]);
            }
        }
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(scanner.hasNext()){
            String[] str = scanner.nextLine().split(" ");
            for (String s:str) {
                set.add(s);
            }
        }
        System.out.println(set.size());
    }
}
