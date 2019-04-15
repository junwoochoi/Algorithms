package Algorithms;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/10250
 * 백준 10250번 ACM호텔
 */
public class Baekjoon10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        while (testCase-- > 0) {
            solution(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
    }

    private static void solution(int H, int W, int N) {
        int n = 0;
        int floor = 0;
        int number = 0;
        for (int i = 1; i <= W ; i++) {
            for (int j = 1; j <= H; j++) {
                n++;
                if(n==N) {
                    floor = j;
                    number = i;
                }
            }

        }


        StringBuilder sb = new StringBuilder();
        sb.append(floor);
        if (number < 10) {
            sb.append(0);
        }
        sb.append(number);

        System.out.println(sb.toString());


    }
}
