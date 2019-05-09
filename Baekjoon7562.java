package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7562
 * 백준 7562번 나이트의 이동
 */
public class Baekjoon7562 {
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = {1, 2, -2, -1};
    private static int[] dy = {2, 1, 1, 2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            visited = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            Node start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            Node end = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            solution(start, end);

        }
    }

    private static void solution(Node start, Node end) {
//        dfs(start, end, 0);
//        System.out.println(visited[end.x][end.y]);
        bfs(start, end);
    }

    private static void bfs(Node start, Node end) {
        Queue<Node> queue = new LinkedList();

        visited[start.x][start.y] = 0;
        queue.add(start);

        while (!queue.isEmpty()){
            Node now = queue.poll();
            if(now.equals(end)){
                System.out.println(visited[end.x][end.y]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    int check = j == 0 ? 1 : -1;
                    int nextX = dx[i] + now.x;
                    int nextY = dy[i] * check + now.y;


                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;

                    if(visited[nextX][nextY] > visited[now.x][now.y]+1){
                        visited[nextX][nextY] = visited[now.x][now.y]+1;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }
        }
    }

    private static void dfs(Node now, Node end, int depth) {
        visited[now.x][now.y] = depth;

        if(now.equals(end)){
            return;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                int check = j == 0 ? 1 : -1;
                int nextX = dx[i] + now.x;
                int nextY = dy[i] * check + now.y;


                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) continue;
                if(end.x + 5 < nextX || end.y + 5 < nextY) continue;

                if(visited[nextX][nextY] > depth+1){
                    dfs(new Node(nextX, nextY), end, depth+1);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x &&
                    y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
