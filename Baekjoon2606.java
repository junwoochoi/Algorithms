package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 * 백준 2606번 바이러스
 */
public class Baekjoon2606 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int computerCount = Integer.parseInt(br.readLine());
        int connectionCount = Integer.parseInt(br.readLine());

        map = new int[computerCount+1][computerCount+1];
        visited = new boolean[computerCount+1];
        visited[0] = true;
        for (int t = 0; t < connectionCount; t++) {
            StringTokenizer st= new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map[n][m] = 1;
            map[m][n] = 1;
        }


        Queue<Integer> queue = new LinkedList<>();

        visited[1] = true;
        queue.add(1);
        int answer = 0;

        while(!queue.isEmpty()){
            int current = queue.poll();


            for (int i = 1; i < computerCount+1; i++) {
                if(map[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    answer++;
                    queue.add(i);
                }
            }
        }

        System.out.println(answer);

    }
}
