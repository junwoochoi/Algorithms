package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/12865
 * 백준 12865번 평범한 배낭
 */
public class Baekjoon12865 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] w;
    private static int[] v;
    private static int[][] d;
    private static int N = 0;
    private static int K = 0;


    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());

        w = new int[N + 1];
        v = new int[N + 1];
        d = new int[N + 1][K + 1];


        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());

            w[i] = Integer.parseInt(stringTokenizer.nextToken());
            v[i] = Integer.parseInt(stringTokenizer.nextToken());

        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                d[i][j] = d[i - 1][j];
                if (j - w[i] >= 0) {
                    d[i][j] = Math.max(d[i][j], d[i - 1][j - w[i]] + v[i]);
                }
            }
            System.out.println(Arrays.toString(d[i]));
        }


        System.out.println(d[N][K]);
    }


}
