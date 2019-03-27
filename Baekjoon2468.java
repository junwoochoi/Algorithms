package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2468
 * 백준 2468 안전영역 문제
 */
public class Baekjoon2468 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int N;
    private static boolean[][] visited;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(map[i][j], max);
            }
        }

        int answer = 0;
        for (int i = 1; i < max; i++) {
            answer = Math.max(answer, getSafePlace(i));
        }
        if(answer==0){
            answer = 1;
        }
        System.out.println(answer);
    }

    private static int getSafePlace(int height) {
        visited = new boolean[N][N];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > height && !visited[i][j]) {
                    bfs(new Node(i, j), height);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(Node node, int height) {
        Queue<Node> queue = new LinkedList<>();

        visited[node.x][node.y] = true;
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx<0 || ny < 0 || nx>=N || ny >= N) continue;
                if(visited[nx][ny]) continue;

                if(map[nx][ny] > height){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
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
