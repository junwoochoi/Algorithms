package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * 백준 DFS와 BFS
 */
public class Baekjoon1260 {
    private static Integer N, M, V;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static boolean[] visited;
    private static List<Integer> dfsList = new ArrayList<>();
    private static List<Integer> bfsList = new ArrayList<>();
    private static boolean dfsFlag;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        V = Integer.valueOf(st.nextToken());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            map[first][second] = 1;
            map[second][first] = 1;
        }
        visited[V] = true;
        dfs(V);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dfsList.size(); i++) {
            sb.append(dfsList.get(i))
                    .append(" ");
        }
        System.out.println(sb.toString().trim());

        visited = new boolean[N+1];
        bfs();

    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList();
        visited[V] = true;
        queue.add(V);

        while(!queue.isEmpty()){
            int current = queue.poll();
            bfsList.add(current);

            for (int i = 1; i < N+1; i++) {
                if(map[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bfsList.size(); i++) {
            sb.append(bfsList.get(i))
                    .append(" ");
        }
        System.out.println(sb.toString().trim());


    }

    private static void dfs(Integer current) {
        dfsList.add(current);

        int count = 0;
        for (int i = 1; i < N+1; i++) {
            if(map[current][i] == 1 && !visited[i]){
                count++;
                visited[i] = true;
                dfs(i);
            }
        }



    }
}
