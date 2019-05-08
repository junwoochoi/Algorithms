package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10026
 * 백준 10026번 적록색약
 */
public class Baekjoon10026 {
    private static char[][] map;
    private static boolean[][] visited;
    private static int[] answer = {0, 0};
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = input.charAt(j);
                map[i][j] = c;
            }
        }



        //적록색약 아닌 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    answer[0]++;
                }
            }
        }

        visited = new boolean[n][n];

        //적록색약인 사람
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfsColorBlind(i, j);
                    answer[1]++;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);

    }

    private static void dfsColorBlind(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;
            if(visited[nextX][nextY]) continue;

            if(map[i][j] == 'B' && map[nextX][nextY] != 'B') continue;
            if(map[i][j] == 'R' || map[i][j] == 'G'){
                if(map[nextX][nextY] == 'B') continue;
            }

            dfsColorBlind(nextX, nextY);

        }
    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;

            if (map[i][j] == map[nextX][nextY] && !visited[nextX][nextY]){
                dfs(nextX, nextY);
            }

        }
    }
}
