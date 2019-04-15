package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1011
 * 백준 Fly me to the Alpha Centauri 1011
 */
public class Baekjoon1011 {
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-- > 0) {
            count = 1;
            solution(sc.nextLong(), sc.nextLong());
        }
    }

    private static void solution(long x, long y) {
        long diff = y - x;
        if (diff < 4) {
            System.out.println(diff);
            return;
        }

        int num = 1;
        while (Math.pow(num, 2) <= diff) {
            num++;
        }

        num--;

        int answer = 2 * num - 1;
        if (Math.pow(num, 2) != diff) {
            int leftNum = (int) (diff - Math.pow(num, 2));
            while (leftNum > 0) {
                leftNum -= num;
                answer++;
            }
        }

        System.out.println(answer);
    }


}
