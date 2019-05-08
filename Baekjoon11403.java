package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11403
 * 백준 11403번 경로찾기
 */
public class Baekjoon11403 {
    private static int[][] map;
    private static int[] visited;
    private static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        map = new int[num][num];
        answer = new int[num][num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < num; i++) {
            visited = new int[num];
            dfs(i);

            for (int j = 0; j < num; j++) {
                answer[i][j] = visited[j];
            }
        }

        for (int[] arr : answer) {
            StringBuilder sb = new StringBuilder();
            for (int n : arr) {
                sb.append(n).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static void dfs(int now) {

        for (int i = 0; i < map.length; i++) {
            if (map[now][i] == 1 && visited[i] != 1) {
                visited[i] = 1;
                dfs(i);
            }
        }
    }
}