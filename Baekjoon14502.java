package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14502
 * 백준 14502번 연구소
 */
public class Baekjoon14502 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int[][] tempMap;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] visited;
    private static long maxSafe = 0;
    private static int[][] virusMap;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    tempMap = new int[N][M];
                    copyArr(map, tempMap);

                    tempMap[i][j] = 1;

                    buildWalls(1);

                    tempMap[i][j] = 0;
                }
            }
        }


        System.out.println(maxSafe);

    }

    private static void buildWalls(int depth) {
        if (depth == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < tempMap.length; i++) {
            for (int j = 0; j < tempMap[0].length; j++) {
                if (tempMap[i][j] == 0) {
                    tempMap[i][j] = 1;

                    buildWalls(depth + 1);

                    tempMap[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus() {
        visited = new boolean[tempMap.length][tempMap[0].length];
        virusMap = new int[tempMap.length][tempMap[0].length];
        copyArr(tempMap, virusMap);
        Queue<Node> queue = new LinkedList<>();


        for (int i = 0; i < tempMap.length; i++) {
            for (int j = 0; j < tempMap[0].length; j++) {
                if (virusMap[i][j] == 2 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= tempMap.length || nextY >= tempMap[0].length) continue;
                if(virusMap[nextX][nextY] == 1 || visited[nextX][nextY]) continue;

                virusMap[nextX][nextY] = 2;
                visited[nextX][nextY] = true;
                queue.offer(new Node(nextX, nextY));
            }
        }


        countSafePlace();


    }

    private static void countSafePlace() {
        long count = 0;
        for (int i = 0; i < tempMap.length; i++) {
            for (int j = 0; j < tempMap[0].length; j++) {
                if(virusMap[i][j] == 0) count++;
            }
        }

        maxSafe = Math.max(maxSafe, count);
    }

    private static void copyArr(int[][] original, int[][] copied) {
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                copied[i][j] = original[i][j];
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
