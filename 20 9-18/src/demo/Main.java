package demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            //保存输入击球数字符串
            String string = sc.nextLine();
            int k = 0;
            //记录每轮得分数和击球情况
            int[][] arr = new int[11][3];
            //记录得分总和
            int sum = 0;
            for (int i = 0; i < arr.length-1; i++) {
                //前九次击球数统计
                if(i < 9){
                    char temp = string.charAt(k);
                    if(temp == 'X'){                    //第1次击中10个球
                        arr[i][0] = 10;
                        arr[i][1] = -1;
                        k++;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1) == '/'){
                        arr[i][0] = string.charAt(k) - '0';                 //第一轮补中
                        arr[i][1] = 10-(string.charAt(k) - '0');
                        k += 2;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1) == '-'){
                        arr[i][0] = string.charAt(k) - '0';  //第一轮未补中
                        arr[i][1] = 0;
                        k += 2;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1)>0 && string.charAt(k+1) <= '9'){
                        arr[i][0] = string.charAt(k) - '0';
                        arr[i][1] = string.charAt(k+1) - '0';
                        k += 2;
                    }
                }//X72X9/7-9/XX9/9- X7/368-XX8/637/9/X
                if(i == 9){
                    char temp = string.charAt(k);
                    char tempNext = string.charAt(k+1);
                    if(temp == 'X'){
                        arr[9][0] = 10;
                        arr[9][1] = -1;
                        if(tempNext == 'X'){
                            arr[10][0] = 10;
                        }
                        else {
                            arr[10][0] = tempNext - '0';
                        }
                        if(tempNext == 'X'){
                            arr[10][1] = 10;
                        }
                        else {
                            arr[10][1] = string.charAt(k+2) - '0';
                        }
                        k++;
                    }
                    else if(temp > '0' && temp <= '9' && tempNext == '/'){
                        arr[9][0] = string.charAt(k) - '0';
                        arr[9][1] = 10-(string.charAt(k) - '0');
                        if(string.charAt(k+2) == 'X'){
                            arr[10][0] = 10;
                        }
                        else if(string.charAt(k+2) == '-'){
                            arr[10][0] = 0;
                        }
                        else {
                            arr[10][0] = string.charAt(k+2) - '0';
                        }
                        arr[10][1] = -1;
                        k += 2;
                    }
                    else if(temp > '0' && temp <= '9' && tempNext == '-'){
                        arr[9][0] = temp - '0';
                        arr[9][1] = 0;
                        arr[10][0] = 0;
                        arr[10][1] = 0;
                        k += 2;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1)>0 && string.charAt(k+1) <= '9'){
                        arr[9][0] = temp - '0';
                        arr[9][1] = tempNext - '0';
                        arr[10][0] = 0;
                        arr[10][1] = 0;
                        k += 2;
                    }
                }
            }
            k = 0;
            for (int i = 0; i < arr.length-1; i++) {
                if(i < 9){
                    char temp = string.charAt(k);
                    if(temp == 'X'){
                        if(arr[i+1][1] == -1){
                            arr[i][2] = 10 + arr[i+1][0] + arr[i+2][0];
                        }
                        else {
                            arr[i][2] =  10 + arr[i+1][0] + arr[i+1][1];
                        }
                        sum += arr[i][2];
                        k++;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1) == '/'){
                        arr[i][2] = arr[i][0] + arr[i][1] + arr[i+1][0];
                        sum += arr[i][2];
                        k += 2;
                    }
                    else if(temp > '0' && temp <= '9' && string.charAt(k+1) == '-' || string.charAt(k+1)>0 && string.charAt(k+1) <= '9'){
                        arr[i][2] = arr[i][0] + arr[i][1];
                        sum += arr[i][2];
                        k += 2;
                    }
                }
                if(i == 9){
                    char temp = string.charAt(k);
                    char tempNext = string.charAt(k+1);
                    if(temp == 'X'){
                        arr[9][2] = arr[9][0] + arr[10][0] + arr[10][1];
                    }
                    else if(temp > '0' && temp <= '9' && tempNext == '/'){
                        arr[9][2] = arr[9][0] + arr[9][1] + arr[i+1][0];
                    }
                    else if(temp > '0' && temp <= '9' && tempNext == '-' || string.charAt(k+1)>0 && string.charAt(k+1) <= '9'){
                        arr[9][2] = arr[9][0] + arr[9][1];
                    }
                    sum += arr[9][2];
                }
            }
            System.out.println(sum);
        }
    }
}
