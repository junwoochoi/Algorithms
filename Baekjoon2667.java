package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667
 * 백준 단지번호 붙이기 2667번 문제
 */
public class Baekjoon2667 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int N = 0;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static boolean visited[][];
    private static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) == '1' ? 1 : 0;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0 && !visited[i][j]) {
                    bfs(new Node(i, j));
                }
            }
        }

        System.out.println(answer.size());

        Collections.sort(answer);

        for (int number : answer){
            System.out.println(number);
        }



    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();

        int count = 0;
        visited[node.x][node.y] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            count++;
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if(visited[nx][ny]) continue;

                if(map[nx][ny] != 0){
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        answer.add(count);

    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
