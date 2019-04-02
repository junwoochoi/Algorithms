package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2583
 * 백준 2583 영역구하기
 */
    public class Baekjoon2583 {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static int[][] map;
        private static int N = 0;
        private static int M = 0;
        private static int K = 0;
        private static boolean[][] visited;
    private static int[] dx = { 1, -1, 0, 0};
    private static int[] dy = { 0, 0, 1, -1};
    private static List<Integer> answer = new ArrayList<>();
    private static int index = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            for (int j = leftX; j < rightX; j++) {
                for (int k = leftY; k < rightY; k++) {
                    map[k][j] += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 0){
                    answer.add(0);
                    visited[i][j] = true;
                    dfs(i, j);
                    index++;
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int num : answer){
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static void dfs(int x, int y) {
        answer.set(index, answer.get(index)+1);

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if( nextX < 0 || nextY <0 || nextX >= N || nextY >= M) continue;

            if(!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                visited[nextX][nextY] = true;
                dfs(nextX, nextY);
            }
        }
    }


}
