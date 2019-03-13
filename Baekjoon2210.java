package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2210
 * 백준 2210번 숫자판 점프
 */
public class Baekjoon2210 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] input = new int[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, String.valueOf(input[i][j]));
            }
        }

        System.out.println(set.size());

    }

    private static void dfs(int x, int y, int move, String string) {
        if (move == 5) {
            set.add(string);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nX = dx[i] + x;
            int nY = dy[i] + y;
            if (nX < 0 || nY < 0 || nX > 4 || nY > 4) continue;

            dfs(nX, nY, move + 1, string + input[nX][nY]);

        }

    }

}
