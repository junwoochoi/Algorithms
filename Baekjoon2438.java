package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2438
 * 백준 별찍기
 */
public class Baekjoon2438 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
