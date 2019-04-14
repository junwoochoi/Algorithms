package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1193
 * 백준 1193 분수찾
 */
public class Baekjoon1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int x = 1;
        int y = 1;
        int count = 0;

        for (int i = 1; i < n; i++) {
            if(y==1){
                count++;
                y=x+1;
                x=1;
                continue;
            }

            x++;
            y--;
        }
        if(count%2 == 0){
            int temp = x;
            x=y;
            y=temp;
        }
        System.out.println(x+"/"+y);

    }
}
