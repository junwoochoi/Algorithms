package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2589
 * 백준 2589번 보물찾기
 */
public class Baekjoon2589 {
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int maxLength = 0;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == 'L' ? 1 : 0;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    visited = new int[N][M];
                    initVisited();
                    bfs(i, j);
                }
            }
        }

        System.out.println(maxLength);

    }

    private static void initVisited() {
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
    }

    private static void bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<>();

        visited[x][y] = 0;
        queue.add(new Node(x, y));
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
                if (map[nextX][nextY] == 0) continue;

                if (visited[nextX][nextY] > visited[current.x][current.y] + 1) {
                    visited[nextX][nextY] = visited[current.x][current.y] + 1;
                    queue.offer(new Node(nextX, nextY));
                }

            }
        }

        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (visited[i][j] == Integer.MAX_VALUE) continue;
                maxLength = Math.max(visited[i][j], maxLength);
            }
        }

    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
