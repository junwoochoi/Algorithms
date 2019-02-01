package algo.Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1260
 * 백준 1260번 DFS와 BFS 문제
 *
 */
public class DfsAndBfs {
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder bfs = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer>[] vertexes = new PriorityQueue[N+1];
        for(int i=1; i<=N; i++){
            vertexes[i] = new PriorityQueue<>();
        }
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            vertexes[n].add(m);
            vertexes[m].add(n);
        }
        boolean[] visited = new boolean[vertexes.length];
        visited[0] = true;

        dfs(vertexes, V, visited);

        System.out.println(sb.toString().trim());

        boolean[] bfsVisited = new boolean[vertexes.length];
        bfsVisited[0] = true;

        bfs(vertexes, V, bfsVisited);

        System.out.println(bfs.toString().trim());

    }

    private static void bfs(Queue<Integer>[] vertexes, int v, boolean[] visited) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        bfs.append(v);
        bfs.append(" ");

        if(!vertexes[v].isEmpty()){
            for(Object num : vertexes[v]){
                visited[(int) num] = true;
                bfs.append(num);
                bfs.append(" ");

            }
        }
    }

    private static void dfs(Queue[] vertexes, int v, boolean[] visited) {
        visited[v] = true;
        sb.append(v);
        sb.append(" ");
        if(!vertexes[v].isEmpty()){
            boolean isAllVisited = true;
            for(Object num : vertexes[v]){
                if(!visited[(int) num]){
                    isAllVisited = false;
                    dfs(vertexes, (Integer) num, visited);
                    break;
                }
            }
            if(isAllVisited){

            }
        }
    }
}
