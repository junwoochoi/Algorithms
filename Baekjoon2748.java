package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2748
 * 백준 2748번 피보나치 수 2
 */
public class Baekjoon2748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] fibonacci = new long[n+1];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibonacci[i] = fibonacci[i-1]+fibonacci[i-2];
        }


        System.out.println(fibonacci[n]);

    }
}
