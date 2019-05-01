package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9465
 * 백준 9465번 스티커
 */
public class Baekjoon9465 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[N][2];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st= new StringTokenizer(br.readLine());

                for (int k = 0; k < N; k++) {
                    stickers[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            solution(stickers);
        }
    }

    private static void solution(int[][] stickers) {
        stickers[1][0] += stickers[0][1];
        stickers[1][1] += stickers[0][0];

        for (int i = 2; i < stickers.length; i++) {
            stickers[i][0] += Math.max(stickers[i-1][1], Math.max(stickers[i-2][0], stickers[i-2][1]));
            stickers[i][1] += Math.max(stickers[i-1][0], Math.max(stickers[i-2][0], stickers[i-2][1]));
        }

        System.out.println(Math.max(stickers[stickers.length-1][0], stickers[stickers.length-1][1]));
    }
}
