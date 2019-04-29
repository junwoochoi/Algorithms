package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1149
 * 백준 1149 RGB거리
 */
public class Baekjoon1149 {
    private static Scanner sc = new Scanner(System.in);
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;


    public static void main(String[] args) {
        int house = sc.nextInt();
        long[][] map = new long[house + 1][3];
        long[][] cost = new long[house + 1][3];

        for (int i = 1; i <= house; i++) {
            for (int j = 0; j < 3; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= house; i++) {

            map[i][RED] = Math.min(map[i - 1][GREEN], map[i - 1][BLUE]) + cost[i][RED];
            map[i][GREEN] = Math.min(map[i - 1][RED], map[i - 1][BLUE]) + cost[i][GREEN];
            map[i][BLUE] = Math.min(map[i - 1][RED], map[i - 1][GREEN]) + cost[i][BLUE];
        }

        System.out.println(Math.min(Math.min(map[house][RED], map[house][BLUE]), map[house][GREEN]));

    }
}
