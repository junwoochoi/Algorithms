package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11050
 * 백준 11051번 이항계수 2
 */
public class Baekjoon6591 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        while (n != 0 || k != 0) {


            System.out.println(solution(n, k));
            n = scanner.nextInt();
            k = scanner.nextInt();
        }

    }

    private static long solution(long n, long k) {

        return 0;
    }

}