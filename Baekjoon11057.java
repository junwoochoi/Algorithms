package Algorithms;

import java.util.Scanner;

/**
 * 백준 오르막 수 11057번
 */
public class Baekjoon11057 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[10];
        for (int i = 0; i < 10; i++) dp[i] = 1;

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < 10; i++) {
                dp[i] += dp[i - 1] % 10007;
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += dp[i];
        }
        System.out.println(sum % 10007);


    }
}
