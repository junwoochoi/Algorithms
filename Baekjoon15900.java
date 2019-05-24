package Algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 15900번 나무탈출
 * https://www.acmicpc.net/problem/15900
 */
public class Baekjoon15900 {
    private static List<Integer>[] map;
    private static boolean[] visited;
    private static int count = 0;
    private static int N = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            map[i] = new ArrayList();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].add(end);
            map[end].add(start);
        }

        visited = new boolean[N+1];

        visited[1] = true;
        dfs(1, 0);


        if (count % 2 == 0) {
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }

    private static void dfs(int current, int depth) {

        for (int i = 0; i < map[current].size(); i++) {
            int next = map[current].get(i);
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, depth + 1);
            }
        }

        if(map[current].size()==1){
            count+=depth;
        }

    }
}
