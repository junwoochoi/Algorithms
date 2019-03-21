package algo.Algorithms;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/9663
 * 백준 9663 n-queen
 */
public class Baekjoon9663 {
    public static int[][] map;
    public static int count = 0;
    public static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];


        dfs(0);

        System.out.println(count);
    }

    private static void dfs(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isAvailable(row, i)) continue;

            map[row][i] = 1;
            dfs(row+1);
            map[row][i] = 0;
        }

    }

    private static boolean isAvailable(int row, int col) {
        //세로가 겹침
        for (int i = 0; i < N; i++) {
            if (i == row) continue;
            if (map[i][col] == 1) return false;
        }

        //대각선 겹침
        for (int i = 1; i < N; i++) {
            if (row - i < 0 || col - i < 0) continue;
            if (map[row - i][col - i] == 1) return false;
        }

        for (int i = 1; i < N; i++) {
            if (row - i < 0 || col + i >= N) continue;
            if (map[row - i][col + i] == 1) return false;
        }

        return true;
    }


}
