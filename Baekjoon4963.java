package algo.Algorithms;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/4963
 * 백준 4963 섬의 개수
 */
public class Baekjoon4963 {
    private static int islandCount = 0;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = { -1, -1, -1, 0,  0, 1, 1, 1};
    static int[] dy = { -1,  0,  1, 1, -1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        String firstLine = "";
        while(true){
            islandCount = 0;
            firstLine = br.readLine();
            if(firstLine.equals("0 0")) break;

            StringTokenizer st = new StringTokenizer(firstLine, " ");
            countIsland(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

    }

    private static void countIsland(int width, int height) throws IOException {
        int[][] map = new int[width][height];

        for(int i=0; i<height; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");


            for(int j=0; j<width; j++){
                int num = Integer.parseInt(st.nextToken());
                map[j][i] = num;
            }
        }

        boolean[][] visited = new boolean[width][height];
        for(int x=0; x<width; x++){
            for(int y=0; y<height; y++){
                if(map[x][y] == 1 && !visited[x][y]){
                    bfs(x, y, visited, map);
                }
            }
        }

        System.out.println(islandCount);
    }

    private static void bfs(int x, int y, boolean[][] visited, int[][] map) {
        islandCount++;
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Pair<>(x, y));

        while(!queue.isEmpty()){
            Pair<Integer, Integer> current = queue.poll();

            for(int i=0; i<8; i++){
                int nextX = dx[i]+ current.getKey();
                int nextY = dy[i]+ current.getValue();

                if(nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) continue;

                if(map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true;
                    queue.offer(new Pair<Integer, Integer>(nextX, nextY));
                }
            }
        }
    }
}
