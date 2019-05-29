package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1600
 * 백준 말이 되고픈 원숭이
 */
public class Baekjoon1600 {
    private static int[][] map;
    private static int[][] visited;
    private static int[][] chance;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 1, -1};
    private static int[] horseX = {1, 2, -2, -1};
    private static int[] horseY = {2, 1, 1, 2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        map = new int[W][H];
        visited = new int[W][H];
        chance = new int[W][H];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Node(0, 0, 0), new Node(W - 1, H - 1, 0), K);
    }

    private static void bfs(Node start, Node end, int K) {
        Queue<Node> queue = new LinkedList();

        visited[start.x][start.y] = 0;
        chance[start.x][start.y] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            if (now.equals(end)) {
                System.out.println(visited[end.x][end.y]);
                return;
            }
            if (now.usedChance < K) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        int check = j == 0 ? 1 : -1;
                        int nextX = horseX[i] + now.x;
                        int nextY = horseY[i] * check + now.y;


                        if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;
                        if (map[nextX][nextY] == 1) continue;

                        if (visited[nextX][nextY] > visited[now.x][now.y] + 1) {
                            visited[nextX][nextY] = visited[now.x][now.y] + 1;
                            chance[nextX][nextY] = now.usedChance + 1;

                            queue.add(new Node(nextX, nextY, now.usedChance + 1));
                        }

                        if(visited[nextX][nextY] == visited[now.x][now.y]+1 && chance[nextX][nextY] != chance[now.x][now.y]+1){
                            visited[nextX][nextY] = visited[now.x][now.y] + 1;
                            chance[nextX][nextY] = now.usedChance + 1;

                            queue.add(new Node(nextX, nextY, now.usedChance + 1));
                        }
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + now.x;
                int nextY = dy[i] + now.y;


                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) continue;
                if (map[nextX][nextY] == 1) continue;

                if (visited[nextX][nextY] > visited[now.x][now.y] + 1) {
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                    chance[nextX][nextY] = now.usedChance;
                    queue.add(new Node(nextX, nextY, now.usedChance));
                }

                if(visited[nextX][nextY] == visited[now.x][now.y]+1 && chance[nextX][nextY] != chance[now.x][now.y]){
                    visited[nextX][nextY] = visited[now.x][now.y] + 1;
                    chance[nextX][nextY] = now.usedChance;

                    queue.add(new Node(nextX, nextY, now.usedChance));
                }
            }
        }

        if (visited[map[0].length - 1][map.length - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(visited[map[0].length - 1][map.length - 1]);
    }

    private static class Node {
        int x, y, usedChance;

        public Node(int x, int y, int usedChance) {
            this.x = x;
            this.y = y;
            this.usedChance = usedChance;
        }
    }
}
