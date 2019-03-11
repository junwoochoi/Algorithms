package algo.Algorithms;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/2665
 * 백준 미로만들기 2665번 다익스트라/bfs
 */
public class Baekjoon2665 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int map[][] = new int[n][n];
        int visited[][]= new int[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j) - 48;
            }
        }
        for(int[] arr: visited){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        bfs(map, visited);

        System.out.println(visited[n-1][n-1]);
    }

    private static void bfs(int[][] map, int[][] visited) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        queue.offer(new Pair<>(0, 0));
        visited[0][0] = 0;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> current = queue.poll();

            for(int i=0; i<4; i++){
                int nextX = dx[i] + current.getKey();
                int nextY = dy[i] + current.getValue();

                if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY>=map.length) continue;

                if(visited[current.getKey()][current.getValue()] >= visited[nextX][nextY]) continue;
                int nextValue = map[nextX][nextY];

                if(nextValue==1) {
                    visited[nextX][nextY] = visited[current.getKey()][current.getValue()];

                } else if(nextValue == 0){
                    visited[nextX][nextY] = visited[current.getKey()][current.getValue()]+1;
                }
                    queue.offer(new Pair<>(nextX, nextY));
            }
        }
    }
}
