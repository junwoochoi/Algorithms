package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 * 백준 2178 미로탐색
 */
public class Baekjoon2178 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int visited[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        visited  = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.valueOf(input.charAt(j) -48);
            }
        }

        visited[0][0] =1;
        bfs(new Node(0,0));
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.x == N-1 && current.y == M-1) {
                System.out.println(visited[N-1][M-1]);
                break;
            }



            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(visited[nx][ny] != 0 || map[nx][ny] == 0) continue;

                visited[nx][ny] = visited[current.x][current.y]+1;
                queue.offer(new Node(nx, ny));
            }
        }
    }

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
