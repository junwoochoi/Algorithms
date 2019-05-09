package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14501
 * 백준 14501번 퇴사
 */
public class Baekjoon14501 {
    private static int[][] works;
    private static long maxProfit = 0;
    private static boolean[] available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        works = new int[n + 1][2];
        available = new boolean[n + 1];
        Arrays.fill(available, true);

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            works[i][0] = Integer.parseInt(st.nextToken());
            works[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n + 1; i++) {
            if (i + works[i][0] <= available.length) {
                for (int j = i; j < i + works[i][0]; j++) {
                    if (j >= available.length) break;
                    available[j] = false;
                }

                dfs(i, works[i][1]);

                for (int j = i; j < i + works[i][0]; j++) {
                    if (j >= available.length) break;
                    available[j] = true;
                }
            }
        }

        System.out.println(maxProfit);


    }

    private static void dfs(int today, long profit) {
        maxProfit = Math.max(profit, maxProfit);

        for (int i = today + 1; i < available.length; i++) {
            if (available[i] && i + works[i][0] <= available.length) {
                for (int j = i; j < i + works[i][0]; j++) {
                    if (j >= available.length) break;
                    available[j] = false;
                }

                dfs(i, profit + works[i][1]);

                for (int j = i; j < i + works[i][0]; j++) {
                    if (j >= available.length) break;
                    available[j] = true;
                }
            }
        }
    }
}
