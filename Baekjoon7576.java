package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576
 * 백준 7576번 토마토
 */
public class Baekjoon7576 {
    private static int[][] box;
    private static int[] dx = {1, 0, -1, 0};
    private static int[][] visited;
    private static int[] dy = {0, 1, 0, -1};
    private static Queue<Node> queue = new LinkedList<>();
    private static Queue<Node> waitingQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        getInputData();

        int days = 0;

        while (!isAllRipe()) {
            int changed = dayPass();
            if (changed == 0) {
                System.out.println(-1);
                return;
            }

            days++;
        }

        System.out.println(days);

    }

    private static int dayPass() {
        int check = 0;
        while(!waitingQueue.isEmpty()){
            Node top = waitingQueue.poll();
            visited[top.x][top.y] = 1;
            queue.add(top);
        }

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= box.length || nextY >= box[0].length) continue;
                if (visited[nextX][nextY] == 1) continue;
                if (box[nextX][nextY] == 0) {
                    check++;
                    box[nextX][nextY] = 1;
                    waitingQueue.add(new Node(nextX, nextY));
                }
            }
        }

        return check;
    }

    private static boolean isAllRipe() {
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) return false;
            }
        }

        return true;
    }

    private static void getInputData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        box = new int[M][N];
        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    waitingQueue.add(new Node(i, j));
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
