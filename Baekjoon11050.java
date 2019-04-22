package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11050
 * 백준 11050번 이항계수 1
 */
public class Baekjoon11050 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();


        System.out.println(factorial(n) / factorial(k) / factorial(n-k));
    }

    private static int factorial(int n) {
        int answer = 1;
        for (int i = 2; i < n+1; i++) {
            answer *= i;
        }

        return answer;
    }
}
