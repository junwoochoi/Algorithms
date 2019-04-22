package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11050
 * 백준 11051번 이항계수 2
 */
public class Baekjoon11051 {
    private static long[][] cache;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        cache = new long[n+1][k+1];

        for (int i = 0; i < n+1; i++) {
            cache[i][0] = 1;
        }

        for (int i = 0; i < k+1; i++) {
            cache[i][i] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < k+1; j++) {
                    cache[i][j] = (cache[i-1][j] + cache[i-1][j-1]) % 10007;
            }
        }

        System.out.println(cache[n][k]);

    }

}
