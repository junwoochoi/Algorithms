package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1676
 * 백준 1676번 팩토리얼 0의 갯수
 */
public class Baekjoon1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] check = new int[6];

        for (int n = 5; n < num+1; n++) {
            int number = n;
            innerLoop: while(number > 1){
                if(number%5 == 0){
                    number/= 5;
                    check[5] += 1;
                } else if(number%2 ==0){
                    number/=2;
                    check[2] += 1;
                } else {
                    break innerLoop;
                }
            }
        }


        System.out.println(check[5]);
    }
}
